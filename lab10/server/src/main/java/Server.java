import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable{

    private ArrayList<ConnectionHandler> connections;
    private ServerSocket server;
    private Boolean done;
    private ExecutorService pool;
    public Server(){
        connections = new ArrayList<>();
        done = false;
    }

    @Override
    public void run(){
        try {
            server = new ServerSocket(5000);
            pool = Executors.newCachedThreadPool();
            while(!done){
                Socket client = server.accept();
                ConnectionHandler handler = new ConnectionHandler(client);
                connections.add(handler);
                pool.execute(handler);
            }

        } catch (Exception e) {
            shutdown();
        }
    }

    public void shutdown(){
        try{
            done = true;
            if(!server.isClosed()){
                server.close();
            }
            for(ConnectionHandler o : connections){
                o.shutdownClient();
            }
        } catch (IOException e){
            // ignore
        }

    }

    public void broadcast(String message){
        for(ConnectionHandler o : connections){
            if(o != null){
                o.sendMessage(message);
            }
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }

}
