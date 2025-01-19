import java.util.Scanner;
public class CRC1Exp2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of data bits: ");
        int dataBitsCount = Integer.parseInt(sc.nextLine());
        System.out.print("Enter data bits: ");
        int[] message = sc.nextLine().replaceAll(" ", "").chars().map(c -> c - '0').toArray();
        System.out.print("Enter the no. of generator bits: ");
        int generatorBitsCount = Integer.parseInt(sc.nextLine());
        System.out.print("Enter generator bits: ");
        int[] generator = sc.nextLine().replaceAll(" ", "").chars().map(c -> c - '0').toArray();
        int[] data = new int[message.length + generator.length - 1];
        System.arraycopy(message, 0, data, 0, message.length);
        int[] tempData = data.clone();
        for (int i = 0; i <= data.length - generator.length; i++)
            if (tempData[i] == 1)
                for (int j = 0; j < generator.length; j++)
                    tempData[i + j] ^= generator[j];
        System.out.print("The code bits added are : ");
        for (int i = message.length; i < tempData.length; i++) System.out.print(tempData[i]);
        System.out.println();
        System.arraycopy(tempData, message.length, data, message.length, generator.length - 1);
        System.out.print("The code data is : ");
        for (int bit : data) System.out.print(bit);
        System.out.println();
    }
}