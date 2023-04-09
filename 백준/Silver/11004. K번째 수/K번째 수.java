import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, N - 1, K - 1);
        System.out.println(arr[K - 1]);
    }

    public static void quickSort(int[] arr, int start, int end, int K) {

        if (start < end) {
            int pivot = partition(arr, start, end);
            if (pivot == K) {
                return;
            } else if (K < pivot) {
                quickSort(arr, start, pivot - 1, K);
            } else {
                quickSort(arr, pivot + 1, end, K);
            }
        }
    }

    public static int partition(int[] arr, int start, int end) {

        if (start + 1 == end) {
            if (arr[start] > arr[end]) swap(arr, start, end);
            return end;
        }

        int m = (start + end) / 2;
        swap(arr, start, m);
        int pivot = arr[start];
        int i = start + 1, j = end;

        while (i <= j) {
            while (pivot < arr[j] && j > 0) {
                j--;
            }
            while (pivot > arr[i] && i < arr.length - 1) {
                i++;
            }
            if (i <= j) {
                swap(arr, i++, j--);
            }
        }

        arr[start] = arr[j];
        arr[j] = pivot;
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}