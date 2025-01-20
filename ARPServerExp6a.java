import java.io.*;
import java.net.*;
class ARPServerExp6a {
    public static void main(String[] args) throws Exception {
        // Take server socket
        ServerSocket ss = new ServerSocket(1399);
        String[] ip = {"192.65.22.11", "123.76.54.4"};
        String[] mac = {"jhgkjbhvg", "tfrddrtyui"};
        while(true){
            Socket cs = ss.accept();
            DataInputStream in = new DataInputStream(cs.getInputStream());
            DataOutputStream out = new DataOutputStream(cs.getOutputStream());
            String reqIP = in.readLine();
            for(int i=0; i<ip.length; i++){
                if(reqIP.equals(ip[i])){
                    out.writeBytes(mac[i] + '\n');
                    break;
                }
            }
            cs.close();
        }
    }
}