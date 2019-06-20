package networkProgramming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiServer {
    public static void main(String[] args) {
        //创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("server is on, listening to client's connection");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(socket.getInetAddress().getHostAddress() + " is connected to server");
                executorService.execute(new UserRunnable(socket));

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

class UserRunnable implements Runnable {

    private Socket socket;

    public UserRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream printStream = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            String info = reader.readLine();
            printStream.println("echo: " + info);
            printStream.flush();
            printStream.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}