package networkProgramming;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class EchoClientDemo {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6666);
            PrintStream printStream = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            String info = scanner.nextLine();
            printStream.println(info);
            printStream.flush();
            info = reader.readLine();
            System.out.println(info);

            printStream.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
