package chat.clien;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in); // читаем с консоли
            System.out.println("Введите своё имя: ");
            String name = scanner.nextLine(); // вводим с консоли
            Socket socket = new Socket("localhost", 1500);         // установка соединения с сервером
            Client client = new Client(socket, name);
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("Inet Adress: " + inetAddress);
            String remoteIp = inetAddress.getHostAddress();
            System.out.println("Remote IP: " + remoteIp);
            System.out.println("LocalPort: " + socket.getLocalPort());

            client.listenForMessage();
            client.sendMessage();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
