import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    public ServerSocket server;
    public Socket socket;
    public Question question;
    public ObjectOutputStream output;
    public ObjectInputStream input;
    public static final int PORT_NUMBER = 8181;
    public QuestionBank questions;
    public GameServer(){
        questions = new QuestionBank();
        try {
            System.out.println("Waiting for connection");
            server = new ServerSocket(PORT_NUMBER);
            socket = server.accept();
            System.out.println("Connected "+socket.getInetAddress().getHostName());
            processConnection();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public void processConnection(){
        String send_message = "";
        String input_message = "";
        List<Question> qs = new ArrayList<>();
        List<Option> op = new ArrayList<>();
        do{
            try{
                output = new ObjectOutputStream(socket.getOutputStream());
                op = questions.getOptions();
                for(Option s: op){
                    send_message = send_message+"\n"+s.getName();
                }
                System.out.println("message is: "+send_message);
                output.writeObject(send_message);
                output.flush();
                input = new ObjectInputStream(socket.getInputStream());
                input_message = (String) input.readObject();
                if (input_message.equals("Football")){
                    qs = questions.getQuestions();
                    for(int i = 0; i<1; i++){
                        Question   ques = qs.get(i);
                        String text = ques.getQuestion1()+"\n"+ques.getChoice1()+"\n" +
                                ""+ques.getChoice2()+"\n"+ques.getChoice3()+"\n"+ques.getCorrectAnswer();
                        output.writeObject(text);
                        output.flush();
                    }
                    break;
                    //output.writeObject(send_message);
                    //output.flush();
                }

            }catch (IOException|ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }while (!input_message.equals("bye"));
    }

    public static void main(String[] args) {
        new GameServer();
    }
}

