import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int arr[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gubun = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (gubun == 0) {
                union(a, b);
            } else {
                int findA = find(a);
                int findB = find(b);
                if (findA == findB) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA < findB) {
            arr[findB] = findA;
        } else {
            arr[findA] = findB;
        }
    }

    static int find(int node) {
        if (node != arr[node]) {
            int result = find(arr[node]);
            arr[node] = result;
        } else if (node == arr[node]) {
            return arr[node];
        }

        return arr[node];
    }
}