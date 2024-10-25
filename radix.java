import java.util.Arrays;

public class RadixSort {

    // Function to get the maximum value in the array
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Function to perform counting sort based on the specified digit place (exp)
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Output array to store sorted values
        int[] count = new int[10]; // Array to store the count of digits (0-9)

        // Initialize count array
        Arrays.fill(count, 0);

        // Count occurrences of each digit in the given place (exp)
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Change count[i] to represent the actual position of the digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the sorted values back to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Function to perform radix sort on the array
    public static void radixSort(int[] arr) {
        // Find the maximum number to determine the number of digits
        int max = getMax(arr);

        // Perform counting sort for each digit place (1s, 10s, 100s, etc.)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // Main function to test the radix sort implementation
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original Array: " + Arrays.toString(arr));

        radixSort(arr);

        System.out.println("Sorted Array:   " + Arrays.toString(arr));
    }
}
