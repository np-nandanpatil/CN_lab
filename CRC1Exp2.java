import java.util.Scanner;

public class CRC1 {

    private static int[] convertToBinaryArray(String input) {
        return input.replaceAll(" ", "").chars().map(c -> c - '0').toArray();
    }

    private static void performDivision(int[] data, int[] divisor) {
        for (int i = 0; i <= data.length - divisor.length; i++) {
            if (data[i] == 1)
                for (int j = 0; j < divisor.length; j++)
                    data[i + j] ^= divisor[j];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of data bits and the data bits
        System.out.print("Enter the no. of data bits: ");
        int dataBitsCount = Integer.parseInt(sc.nextLine());
        System.out.print("Enter data bits: ");
        int[] message = convertToBinaryArray(sc.nextLine());

        // Input number of generator bits and the generator bits
        System.out.print("Enter the no. of generator bits: ");
        int generatorBitsCount = Integer.parseInt(sc.nextLine());
        System.out.print("Enter generator bits: ");
        int[] generator = convertToBinaryArray(sc.nextLine());

        // Append zeros for division
        int[] data = new int[message.length + generator.length - 1];
        System.arraycopy(message, 0, data, 0, message.length);

        // Calculate CRC
        int[] tempData = data.clone();
        performDivision(tempData, generator);

        // Extract CRC bits
        int[] crc = new int[generator.length - 1];
        System.arraycopy(tempData, message.length, crc, 0, crc.length);

        // Append CRC to message
        System.arraycopy(crc, 0, data, message.length, crc.length);

        // Display results
        System.out.print("The code bits added are : ");
        for (int bit : crc) System.out.print(bit);
        System.out.println();

        System.out.print("The code data is : ");
        for (int bit : data) System.out.print(bit);
        System.out.println();

        sc.close();
    }
}
