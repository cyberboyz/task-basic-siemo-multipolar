package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This class implements java socket client
 * @author pankaj
 *
 */
public class DemoMultithreadedSocketClient {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        MultithreadedSocketClient M1 = new MultithreadedSocketClient("Client-1");
        M1.start();

        MultithreadedSocketClient M2 = new MultithreadedSocketClient("Client-2");
        M2.start();

        MultithreadedSocketClient M3 = new MultithreadedSocketClient("Client-3");
        M3.start();

        MultithreadedSocketClient M4 = new MultithreadedSocketClient("Client-4");
        M4.start();
    }
}