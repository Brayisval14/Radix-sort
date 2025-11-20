import java.io.*;
import java.util.*;

public class RadixSort {

    // -------------------- RADIX SORT --------------------
    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr)
            if (num > max)
                max = num;
        return max;
    }

    public static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] salida = new int[n];
        int[] conteo = new int[10];

        for (int value : arr)
            conteo[(value / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            conteo[i] += conteo[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            salida[conteo[(arr[i] / exp) % 10] - 1] = arr[i];
            conteo[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(salida, 0, arr, 0, n);
    }

    // --------------------------- MAIN ---------------------------
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("input.txt"));
            List<Integer> lista = new ArrayList<>();

            while (sc.hasNextInt())
                lista.add(sc.nextInt());

            int[] datos = lista.stream().mapToInt(i -> i).toArray();

            radixSort(datos);

            PrintWriter pw = new PrintWriter("output.txt");

            for (int n : datos)
                pw.print(n + " ");

            pw.close();

            System.out.println("ESTE ES MI RADIX SORT CORRECTO");


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
