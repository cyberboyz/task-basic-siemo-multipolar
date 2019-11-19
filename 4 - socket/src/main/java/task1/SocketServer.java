package task1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class implements java Socket server
 * @author pankaj
 *
 */
public class SocketServer {
    //static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 9876;

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        //create the socket server object
        server = new ServerSocket(port);
        ObjectInputStream ois;

        //keep listens indefinitely until receives 'exit' call or program terminates
        System.out.println("Waiting for the client request");

        //creating socket and waiting for client connection
        Socket socket = server.accept();

        //read from socket to ObjectInputStream object
        ois = new ObjectInputStream(socket.getInputStream());

        //convert ObjectInputStream object to String
        String message = (String) ois.readObject();
        System.out.println("Message Received: " + message);
        writeToFile(message, "message_from_client.txt");

        //close resources
        ois.close();
        socket.close();

        //close the ServerSocket object
        server.close();
    }

    private static void writeToFile(String data, String fileName) {
        try {
            Files.write(Paths.get(fileName), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}