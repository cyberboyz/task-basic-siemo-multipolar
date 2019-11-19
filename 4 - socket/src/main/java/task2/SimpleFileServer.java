package task2;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class SimpleFileServer extends Thread {

    private ServerSocket ss;
    private String fileName = "files_di_server.txt";

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/employee_db";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public SimpleFileServer(int port) {
        try {
            ss = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                Socket clientSock = ss.accept();
                connectToDB();
                readFileFromClient(clientSock);
                closeDBConnection();

            } catch (IOException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeDBConnection() throws SQLException {
        stmt.close();
        conn.close();
    }

    private void connectToDB() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
    }

    private void insertEmployeeToDB(String name, String group, int monthlySalary) throws SQLException {
        String sql = "INSERT INTO employee (name, emp_group, monthly_salary) VALUE('%s', '%s', '%d')";
        sql = String.format(sql, name, group, monthlySalary);

        stmt.execute(sql);
    }

    private void readFileFromClient(Socket clientSock) throws IOException, SQLException {
        saveFile(clientSock, fileName);
        String fileContent = readFromFile(fileName);
        splitAndInsertString(fileContent);
    }

    private void splitAndInsertString(String string) throws SQLException {
        String[] splitFileContent = string.split("\n");
        for (String fileContentOneLine: splitFileContent) {
            String[] splitFileContentOneLine = fileContentOneLine.split(",(\\s)*");
            insertEmployeeToDB(splitFileContentOneLine[0], splitFileContentOneLine[1], Integer.parseInt(splitFileContentOneLine[2].trim()));
            System.out.println("Nama: " + splitFileContentOneLine[0] + ", Golongan: " + splitFileContentOneLine[1] + ", Gaji: " + splitFileContentOneLine[2]);
        }
    }

    private String readFromFile(String fileName) throws IOException {
        String fileContent = new String(Files.readAllBytes(Paths.get(fileName)));
        return fileContent;
    }

    private void saveFile(Socket clientSock, String fileName) throws IOException {
        DataInputStream dis = new DataInputStream(clientSock.getInputStream());
        FileOutputStream fos = new FileOutputStream(fileName);
        byte[] buffer = new byte[4096];

        int filesize = 151230; // Send file size in separate msg
        int read = 0;
        int totalRead = 0;
        int remaining = filesize;
        while((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
            totalRead += read;
            remaining -= read;
            System.out.println("read " + totalRead + " bytes.");
            fos.write(buffer, 0, read);
        }
        fos.close();
        dis.close();
    }

    public static void main(String[] args) {
        SimpleFileServer fs = new SimpleFileServer(1988);
        fs.start();
    }
}