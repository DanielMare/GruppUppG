import java.io.*;
import java.net.Socket;

public class GameClient {
    BufferedReader stdIn;
    public Socket socket;
    public ObjectOutputStream output;
    public ObjectInputStream input;
    public static final int PORT_NUMBER = 8181;
    public static final String LOCAL_HOST = "127.0.0.1";
    public GameClient(){
        try{
            System.out.println("Waiting for server");
            socket = new Socket(LOCAL_HOST, PORT_NUMBER);
            processConnection();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public void processConnection(){
        String message = "";
        do{
            try{
                System.out.println("I am right here...");
                stdIn = new BufferedReader(new InputStreamReader(System.in));
                output = new ObjectOutputStream(socket.getOutputStream());
                input = new ObjectInputStream(socket.getInputStream());
                String serverMessage = (String)input.readObject();
                System.out.println(serverMessage);
                message = stdIn.readLine();
                System.out.println("Client>> "+message);
                output.writeObject(message);
                output.flush();
                serverMessage = (String)input.readObject();
                System.out.println(serverMessage);
                break;
            }catch (IOException|ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }while(!message.equals("bye"));
    }

    public static void main(String[] args) {
        new GameClient();
    }
}
