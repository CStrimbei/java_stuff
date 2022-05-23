import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Server{

    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        new UserSystem();
        try{
            serverSocket = new ServerSocket(5000);
            while(true){
                System.out.println("Astept clienti.");
                Socket socket = serverSocket.accept();
                new CThread(socket, server).start();
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            server.stop();
        }
    }
    public void stop() throws IOException{
        serverSocket.close();
    }

    private String getInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void timerAccept() throws SocketException {
        serverSocket.setSoTimeout(1000);
    }
}
