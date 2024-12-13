import java.io.*;
import java.net.*;

public class UdpDnsClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress serverAddress = (args.length == 0) ? InetAddress.getLocalHost() : InetAddress.getByName(args[0]);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the hostname: ");
        String hostname = reader.readLine();

        byte[] sendData = hostname.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 1362);
        clientSocket.send(sendPacket);

        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("IP Address: " + response);

        clientSocket.close();
    }
}
