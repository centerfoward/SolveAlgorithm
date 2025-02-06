package generic_queries_16713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 수열 길이
        int q = Integer.parseInt(st.nextToken()); // 쿼리 길이

        int[] arr = new int[n + 1]; // 누적 XOR 계산 수열 배열
        int[] result = new int[n]; // XOR 연산 후 배열
        int value = 0;

        st = new StringTokenizer(br.readLine(), " ");

        // 쿼리 입력
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 누적 XOR 계산
        // i를 2부터 시작하는 이유는 arr[1]은 자신의 값이므로 건너뛰고 시작
        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i - 1] ^ arr[i];
        }

        // 누적 합 계산한 배열에서 값들을 XOR 연산
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            value ^= arr[r] ^ arr[l-1];

        }
       System.out.println(value);
    }


}
