import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionHandler extends Server implements Runnable{

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private String nick;

    public ConnectionHandler(Socket client){
            this.client = client;
    }

    @Override
    public void run() {
        try{
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out.println("Te rog inregistreaza-te cu comanda /register: ");
            nick = in.readLine();
            System.out.println(nick + " s-a conectat!");
            broadcast(nick + " s-a conectat la chat!");
            String message;
            while((message = in.readLine()) != null){
                if(message.startsWith("/register ")){
                    String[] messageSplit = message.split(" ", 2);
                    if(messageSplit.length == 2){
                        broadcast(nick + " si-a schimbat numele in " + messageSplit[1]);
                        System.out.println(nick + " si-a schimbat numele in " + messageSplit[1]);
                        nick = messageSplit[1];
                        out.println("Te-ai inregistrat cu numele " + nick + '!');
                    } else {
                        out.println("Nu mi-ai dat niciun nickname sub care sa te inregistrezi!");
                    }
                } else if(message.startsWith("/quit")){
                    broadcast(nick + "a iesit din chat!");
                   shutdownClient();
                } else {
                    broadcast(nick + ": " + message);
                }
            }
        } catch (IOException e){
            shutdownClient();
        }
    }
    public void sendMessage(String message){
        out.println(message);
    }

    public void shutdownClient() {
        try {
            in.close();
            out.close();
            if (!client.isClosed()) {
                client.close();
            }
        } catch (IOException e){
            // ignore
        }
    }



}
