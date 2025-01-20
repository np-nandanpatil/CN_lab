import java.io.*;
import java.net.*;
class ARPClientExp6a {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Socket cs = new Socket("127.0.0.1", 1399);
        DataInputStream in = new DataInputStream(cs.getInputStream());
        DataOutputStream out = new DataOutputStream(cs.getOutputStream());
        System.out.print("Enter the ip to find it's mac: ");
        String ip = input.readLine();
        out.writeBytes(ip+'\n');
        String mac = in.readLine();
        System.out.println(mac);
    }
}