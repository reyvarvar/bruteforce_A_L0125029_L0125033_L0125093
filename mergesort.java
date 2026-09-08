import java.util.Arrays;

public class mergesort {

    // Prosedur utama untuk membagi elemen array
    public static void sort(int arr[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            sort(arr, l, mid);
            sort(arr, mid + 1, r);

            // Memanggil prosedur gabung
            merge(arr, l, mid, r);
        }
    }

    // Prosedur untuk menggabungkan dua subarray yang sudah terurut
    public static void merge(int arr[], int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int arraykiri[] = new int[n1];
        int arraykanan[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            arraykiri[i] = arr[l + i];
        }

        for (int j = 0; j < n2; ++j) {
            arraykanan[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (arraykiri[i] <= arraykanan[j]) {
                arr[k] = arraykiri[i];
                i++;
            } else {
                arr[k] = arraykanan[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = arraykiri[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = arraykanan[j];
            j++;
            k++;
        }
    }

    public static void main(String args[]) {

        //masukan angka yang ingin di test disii
        int datatest[] = {
             8, 3, 9, 1, 0, 7, 2, 6, 4
        };

        System.out.println("Data blm urut: " + Arrays.toString(datatest));

        long start = System.nanoTime();
        sort(datatest, 0, datatest.length - 1);
        long waktuSelesai = System.nanoTime();

        System.out.println("\nData setelah diurutkan: " + Arrays.toString(datatest));
        System.out.println("Kondisi: Sukses");
        System.out.println("Waktu run = " + (waktuSelesai - start) + " nanodetik");
    }
}