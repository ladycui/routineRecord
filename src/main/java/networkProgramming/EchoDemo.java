package networkProgramming;
/*
 * 此demo演示客户端和服务器echo过程，即客户端向服务器发送一段信息，服务器再返回这个信息
 * */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoDemo {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("server is on, listening client's connection");
            Socket socket = serverSocket.accept();
            System.out.println("client " + serverSocket.getInetAddress().getHostAddress() + " is connected to server");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String info = reader.readLine();
            System.out.println(info);

            PrintStream printStream = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            printStream.println("echo: " + info);
            printStream.flush();
            printStream.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
