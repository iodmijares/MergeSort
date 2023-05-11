import javax.swing.JOptionPane;

public class MergeSort {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter a list of numbers separated by spaces:");
        String[] numbers = input.split(" ");
        int[] arr = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }

        mergeSort(arr, 0, arr.length - 1);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            result.append(arr[i]).append(" ");
        }
        JOptionPane.showMessageDialog(null, "The original list: " + input);
        JOptionPane.showMessageDialog(null, "Sorted numbers: " + result.toString());
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }
}
