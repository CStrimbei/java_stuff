import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class CThread extends Thread{
    private long timer = System.currentTimeMillis();
    private long timerStop = timer + 60*1000;
    private Socket socket;
    private User user;
    private PrintWriter out;
    private BufferedReader in;
    private final Server server;
    public CThread(Socket socket, Server server) {
        this.socket=socket;
        this.server = server;
    }

    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                String buffer = in.readLine();
                if(buffer==null)
                    break;
                if(System.currentTimeMillis()>timerStop){
                    try{
                        System.out.println("Thread inactiv. Am inchis conexiunea.");
                        out.println("Thread inactiv. Am inchis conexiunea.");
                        in.close();
                        out.close();
                        socket.close();
                        break;
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("Am primit inputul " + buffer);
                processInput(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processInput(String buffer){
        String serverBuffer = null;
        /*String [] splitBuffer = buffer.split(" ");
        String nick = splitBuffer[1];
        System.out.println(Arrays.toString(splitBuffer));*/
        if(buffer.contains("/stop")){
            try{
                Server.timerAccept();
            } catch (IOException e){
                e.printStackTrace();
            }
        } else if(buffer.contains("/register")){
            //System.out.println("Am ajuns la /register in mortii ma-tii!");
            newTimer();
            boolean userContained = false;
            for(User o : UserSystem.getUserList()){
                String nick = buffer.substring(10);
                if(o.getUsername().equals(nick)){
                    serverBuffer = "Numele este deja luat!";
                    userContained = true;
                }
            }
            if (!userContained) {
                String nick = buffer.substring(10);
                UserSystem.addUsertoList(new User(nick));
                serverBuffer = "Userul a fost inregistrat cu succes!";
            }
        } else if (buffer.contains("/login")){
            newTimer();
            boolean userConnected = false;
            for(User user : UserSystem.getUserList()){
                if(user.getUsername().equals(buffer.substring(7))){
                    this.user = user;
                    serverBuffer = "Clientul s-a conectat cu userul: " + user.getUsername();
                    userConnected = true;
                }
            }
            if(!userConnected){
                serverBuffer = "Nu s-a putut realiza loginul. Contul nu a fost inregistrat";
            }
        } else if (buffer.contains("/friend")){
            newTimer();
            if(this.user!=null){
                boolean userExists = false;
                for(User u : UserSystem.getUserList()){
                    String nick = buffer.substring(8);
                    if(user.getUsername().equals(nick)){
                        serverBuffer = "Am adaugat userul cu succes in lista de prieteni!";
                        this.user.friendAdd(u);
                        userExists = true;
                    }
                }
                if(!userExists){
                    serverBuffer = "Nu am gasit userul in sistemul nostru!";
                }
            } else {
                serverBuffer = "Trebuie sa fii logat ca sa adaugi prieteni!";
            }
        } else if(buffer.contains("/send")){
            newTimer();
            String mesaj = buffer.substring(6);
            for(User user : this.user.getFriends()){
                user.mesajAdd(mesaj);
            }

            serverBuffer = "Am trimis mesajul cu succes!";

        } else if(buffer.contains("/read")){
            newTimer();
            /*System.out.println("Am ajuns in /read!");
            System.out.println(this.user.getMesaje());*/
            for(String mesaj : this.user.getMesaje()){
                serverBuffer = mesaj;
                out.println(serverBuffer);
            }
        }

        /*switch (splitBuffer[0]){
            case "/stop" : {
                try{
                    Server.timerAccept();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            case "/register" : {
                newTimer();
                boolean userContained = false;
                for(User o : UserSystem.getUserList()){
                    if(o.getUsername().equals(nick)){
                        serverBuffer = "Numele este deja luat!";
                        userContained = true;
                    }
                }
                if (!userContained) {
                    UserSystem.addUsertoList(new User(nick));
                }
            }
            case "/login" : {
                newTimer();
                boolean userConnected = false;
                for(User user : UserSystem.getUserList()){
                    this.user = user;
                    serverBuffer = "Clientul s-a conectat cu userul: " + user.getUsername();
                    userConnected = true;
                }
                if(!userConnected){
                    serverBuffer = "Nu s-a putut realiza loginul. Contul nu a fost inregistrat";
                }
            }
            case "/friend" : {
                newTimer();
                if(this.user!=null){
                    boolean userExists = false;
                    for(User u : UserSystem.getUserList()){
                        if(user.getUsername().equals(nick)){
                            serverBuffer = "Am adaugat userul cu succes in lista de prieteni!";
                            this.user.friendAdd(u);
                            userExists = true;
                        }
                    }
                    if(!userExists){
                        serverBuffer = "Nu am gasit userul in sistemul nostru!";
                    }
                } else {
                    serverBuffer = "Trebuie sa fii logat ca sa adaugi prieteni!";
                }
            }
            case "/showfriends" : {
                newTimer();
                System.out.println(this.user.getFriends());
            }
            case "/send" : {
                newTimer();
                for(String mesaj : this.user.getMesaje()){
                    serverBuffer = mesaj;
                    out.println(serverBuffer);
                }
            }
        }*/
        if(serverBuffer == null){
            serverBuffer = "N-am primit nimic de la clienti momentan";
        }
        out.println(serverBuffer);
        out.flush();
    }

    private void newTimer(){
        this.timer = System.currentTimeMillis();
        this.timerStop = this.timer + 60 * 1000;
    }

}
