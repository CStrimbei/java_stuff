import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable{

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private Boolean done;

    public Client(){
        done = false;
    }

    @Override
    public void run() {
        try{
            client = new Socket("127.0.0.1", 5000);
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            InputHandler inputHandler = new InputHandler();
            Thread t = new Thread(inputHandler);
            t.start();

            String inMessage;
            while((inMessage = in.readLine())!=null){
                System.out.println(inMessage);
            }
        } catch (IOException e){
            shutdown();
        }
    }
    public void shutdown(){
        done = true;
        try{
            in.close();
            out.close();
            if(!client.isClosed()){
                client.close();
            }
            System.out.println("M-am deconectat!");
        } catch (IOException e){
            // ignore
        }
    }
    class InputHandler implements Runnable{

        @Override
        public void run() {
            try{
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
                while(!done){
                    String mesaj = inputReader.readLine();
                    if(mesaj.equals("/quit")){
                        inputReader.close();
                        shutdown();
                    } else{
                        out.println(mesaj);
                    }
                }
            } catch (IOException e){
                shutdown();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
