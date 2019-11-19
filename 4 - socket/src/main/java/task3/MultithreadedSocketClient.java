package task3;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultithreadedSocketClient implements Runnable{
    private InetAddress host = InetAddress.getLocalHost();
    private Socket socket = null;
    private ObjectOutputStream oos = null;
    private Thread t;
    private String threadName;
    private String generatedString;
    private String message;

    public MultithreadedSocketClient(String name) throws UnknownHostException {
        this.threadName = name;
    }

    public void run() {
        try {
            for(int i = 0; i < 10; i ++) {
                socket = new Socket(host.getHostName(), 9876);
                generatedString = RandomString.getAlphaNumericString(15);
                message = threadName + " says : " +generatedString;
                oos = new ObjectOutputStream(socket.getOutputStream());
                System.out.println(threadName + " to server: \"" + generatedString + "\"");
                oos.writeObject(message);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
