public class Main {

    // 1. Implementasi Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Tukar elemen
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Optimasi: Jika tidak ada pertukaran, array sudah urut
            if (!swapped) break;
        }
    }

    // 2. Implementasi Binary Search
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // Optimasi: Menghindari overflow pada angka besar
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Ditemukan
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Tidak ditemukan
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Data sebelum diurutkan:");
        printArray(data);

        // Proses Sorting
        bubbleSort(data);
        System.out.println("\nData setelah Bubble Sort:");
        printArray(data);

        // Proses Searching
        int target = 22;
        int result = binarySearch(data, target);
        
        if (result == -1) {
            System.out.println("\nElemen " + target + " tidak ditemukan.");
        } else {
            System.out.println("\nElemen " + target + " ditemukan pada indeks ke-" + result);
        }
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}