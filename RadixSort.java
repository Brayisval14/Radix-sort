public class RadixSort {

    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int n : arr) {
            if (n > max) max = n;
        }
        return max;
    }

    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] salida = new int[n];
        int[] conteo = new int[10];

        for (int i = 0; i < n; i++) {
            conteo[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            conteo[i] += conteo[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            salida[conteo[(arr[i] / exp) % 10] - 1] = arr[i];
            conteo[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = salida[i];
        }
    }

    public static void main(String[] args) {
        int[] datos = {170, 45, 75, 90, 802, 24, 2, 66, 456, 123, 789, 34, 567, 890, 12};
        radixSort(datos);
        for (int n : datos) System.out.print(n + " ");
    }
}
