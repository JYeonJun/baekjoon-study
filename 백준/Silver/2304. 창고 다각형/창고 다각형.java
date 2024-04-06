import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), maxHeight = Integer.MIN_VALUE, maxIndex = 0;
        Pilla[] pillas = new Pilla[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int inputL = Integer.parseInt(st.nextToken());
            int inputH = Integer.parseInt(st.nextToken());
            pillas[i] = new Pilla(inputL, inputH);
            if (inputH > maxHeight) {
                maxHeight = inputH;
            }
        }

        Arrays.sort(pillas);
        for (int i = 0; i < pillas.length; i++) {
            if (pillas[i].H == maxHeight) {
                maxIndex = i;
                break;
            }
        }

        int sum = 0, startL = pillas[0].L, height = pillas[0].H;
        for (int i = 1; i <= maxIndex; i++) {
            Pilla current = pillas[i];
            int currentL = current.L;
            int currentH = current.H;

            if (currentH >= height) {
                sum += (currentL - startL) * height;
                startL = currentL;
                height = currentH;
            }
        }

        startL = pillas[N - 1].L + 1;
        height = pillas[N - 1].H;
        for (int i = N - 2; i >= maxIndex; i--) {
            Pilla current = pillas[i];
            int currentL = current.L;
            int currentH = current.H;

            if (currentH >= height) {
                int width = startL - currentL - 1;
                sum += width * height;
                startL = currentL + 1;
                height = currentH;
            }
        }

        sum += maxHeight * 1;

        System.out.println(sum);
    }

    private static class Pilla implements Comparable<Pilla> {
        private int L, H;

        public Pilla(int l, int h) {
            L = l;
            H = h;
        }

        @Override
        public int compareTo(Pilla pilla) {
            return this.L - pilla.L;
        }
    }
}