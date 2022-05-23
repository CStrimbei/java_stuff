import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {

    private ArrayList<ConnectionHandler> connections;
    private ServerSocket server;
    private Boolean done;

    private ExecutorService threadPool;

    public Server() {
        connections = new ArrayList<>();
        done = false;
    }

    @Override
    public void run() {
        try {
            server = new ServerSocket(5000);
            threadPool = Executors.newCachedThreadPool();
            while (!done) {
                Socket client = server.accept();
                ConnectionHandler handler = new ConnectionHandler(client);
                connections.add(handler);
                threadPool.execute(handler);
            }
        } catch (Exception e) {
            shutdown();
        }
    }

    public void broadcast(String mesaj) {
        for (ConnectionHandler o : connections) {
            if (o != null) {
                o.sendMessage(mesaj);
            }
        }
    }

    public void shutdown() {
        try {
            done = true;
            if (!server.isClosed()) {
                server.close();
            }
            for (ConnectionHandler o : connections) {
                o.shutdown();
            }
        } catch (IOException e) {
            // ignore
        }

    }

    class ConnectionHandler implements Runnable {


        private Socket client;
        private BufferedReader in;
        private PrintWriter out;
        private String nick;

        public ConnectionHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(client.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out.println("Scrie-ti nicknameul! De asemenea, vei putea folosi /register pentru a il reinregistra ulterior!");
                nick = in.readLine();
                System.out.println(nick + " s-a conectat!");
                broadcast(nick + " s-a alaturat chatului!");
                String mesaj = null;
                while ((mesaj = in.readLine()) != null) {
                    if (mesaj.startsWith("/register ")) {
                        String[] mesajSplit = mesaj.split(" ", 2);
                        if (mesajSplit.length == 2) {
                            broadcast(nick + " si-a pus nicknameul " + mesajSplit[1]);
                            System.out.println(nick + " si-a pus nicknameul " + mesajSplit[1]);
                            nick = mesajSplit[1];
                            out.println("Ti-ai pus nicknameul " + nick + "!");
                        } else {
                            out.println("Nu ai oferit un nickname valid!");
                        }
                    } else if (mesaj.startsWith("/quit")) {
                        broadcast(nick + " a iesit din chat!");
                        shutdown();
                    } else {
                        broadcast(nick + " : " + mesaj);
                    }
                }
            } catch (IOException e) {
                shutdown();
            }
        }

        public void shutdown() {
            try {
                in.close();
                out.close();
                if (!client.isClosed()) {
                    client.close();
                }
            } catch (IOException e) {
                // ignore
            }

        }

        public void sendMessage(String mesaj) {
            out.println(mesaj);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }

}

