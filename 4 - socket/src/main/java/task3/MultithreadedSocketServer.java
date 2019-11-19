package task3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class implements java Socket server
 * @author pankaj
 *
 */
public class MultithreadedSocketServer {
    //static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 9876;

    public static void main(String args[]) throws IOException, ClassNotFoundException{
        //create the socket server object
        server = new ServerSocket(port);
        ObjectInputStream ois = null;

        while (!false) {
            //creating socket and waiting for client connection
            Socket socket = server.accept();

            //read from socket to ObjectInputStream object
            ois = new ObjectInputStream(socket.getInputStream());

            //convert ObjectInputStream object to String
            String message = (String) ois.readObject();
            System.out.println("Message: " + message);

            //close resources
            ois.close();
            socket.close();
        }
        //close the ServerSocket object
//        server.close();
    }
}