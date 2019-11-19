
package com.journaldev.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This class implements java socket client
 * @author pankaj
 *
 */
public class SocketClientExample {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;

        //establish socket connection to server
        socket = new Socket(host.getHostName(), 9876);

        //write the message to be sent to the server
        System.out.println("Masukkan pesan yang ingin dikirimkan");
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String message = reader.readLine();

        //write to socket using ObjectOutputStream
        oos = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Mengirimkan pesan ke server: \"" + message + "\"");
        oos.writeObject(message);

        //close resources
        oos.close();
    }
}