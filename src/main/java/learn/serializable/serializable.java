package learn.serializable;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

class User{
    private Integer id ;
    private String name ;
    private Integer age ;

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
public class serializable {
    public static void main(String[] args)throws Exception{
        Socket socket = new Socket("localhost",8080) ;
        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream()) ;
            User user = new User(1 , "lpy" , 22);
            outputStream.writeObject(user);
            outputStream.flush();
            System.out.println(" Object is sent : " + user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(!socket.isClosed()){
                socket.close();
            }
        }

        ServerSocket serverSocket = new ServerSocket(8080) ;

    }

}
