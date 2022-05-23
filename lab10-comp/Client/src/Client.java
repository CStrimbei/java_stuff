import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private static BufferedReader in;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        Socket socket = new Socket("127.0.0.1", 5000);
        try{
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                String clientBuffer = client.readKeyboard();
                if(clientBuffer.equals("/stop")){
                    client.sendBuffer(clientBuffer);
                    in.close();
                    out.close();
                    socket.close();
                    break;
                } else{
                    client.sendBuffer(clientBuffer);
                }
            }
            System.out.println("Am inchis clientul.");
        } catch (UnknownHostException e){
            System.err.println("Nu am gasit un server la care sa ma conectez! " + e);
        }
    }

    private String readKeyboard(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void sendBuffer(String clientBuffer) throws IOException{
        try{
            out.println(clientBuffer);
            out.flush();
            clientBuffer = in.readLine();
            System.out.println("Ce am primit de la server: " + clientBuffer);
        } catch (SocketException e){
            System.out.println("Eroare la sendBuffer!");
        }
    }

}
