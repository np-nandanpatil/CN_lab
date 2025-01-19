import java.io.*;
import java.net.*;

public class UdpDnsServer {
    public static void main(String[] args) throws IOException {
        String[] hosts = {"yahoo.com", "gmail.com", "cricinfo.com", "facebook.com"};
        String[] ips = {"68.180.206.184", "209.85.148.19", "80.168.92.140", "69.63.189.16"};
        DatagramSocket serverSocket = new DatagramSocket(1362);
        byte[] buffer = new byte[1024];

        System.out.println("DNS Server running... Press Ctrl + C to quit.");
        while (true) {
            DatagramPacket request = new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(request);

            String host = new String(request.getData(), 0, request.getLength()).trim();
            System.out.println("Request for host: " + host);

            String response = "Host Not Found";
            for (int i = 0; i < hosts.length; i++) {
                if (hosts[i].equalsIgnoreCase(host)) {
                    response = ips[i];
                    break;
                }
            }

            DatagramPacket reply = new DatagramPacket(response.getBytes(), response.length(),
                    request.getAddress(), request.getPort());
            serverSocket.send(reply);
        }
    }
}
