import java.util.*;
public class LeakyBucketExp8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = 4, outRate = 3, rem = 0;
        System.out.println("Enter the number of packets:");
        int n = sc.nextInt();
        int[] packets = new int[n];
        System.out.println("Enter the packet sizes:");
        for (int i = 0; i < n; i++) packets[i] = sc.nextInt();
        System.out.println("Clock\tPacket\tAccept\tSent\tRemaining");
        for (int i = 0; i < n; i++) {
            int received = (rem + packets[i] > cap) ? -1 : packets[i];
            if (received != -1) rem += packets[i];
            int sent = Math.min(rem, outRate);
            rem -= sent;
            System.out.println((i + 1) + "\t\t" + packets[i] + "\t\t" + (received == -1 ? "Dropped" : received) + "\t\t" + sent + "\t\t" + rem);
        }
        sc.close();
    }
}