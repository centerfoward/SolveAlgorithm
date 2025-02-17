package data_structure.section_sum5_11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 배열 n의 수
        int m = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 수
        // 주어진 배열
        int[][] arr = new int[n + 1][n + 1];

        // 주어진 범위를 담은 배열
        int[][] targetArr = new int[m][4];

        // 합배열
        int[][] sumArr = new int[n + 1][n + 1];

        // 배열 입력
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 합 배열 구하기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                /*
                 * i : sumArr[i-1][j] + arr[i][j]
                 * j : sumArr[i][j-1] + arr[i][j]
                 * 라는 기존식을 통해 i와 j의 구간 합을 구할 수 있다.
                 * 이를 이용해 다음과 같은 식이 도출된다.
                 * A : 구하려는 2차원 배열 인덱스에 해당하는 값
                 * D : 구간합으로 구해진 배열 인덱스
                 * D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1 ] + A[i][j]
                 * D[i][j-1] : A[i][j]기준 왼쪽 값
                 * D[i-1][j] : A[i][j]기준 위 값
                 * D[i-1][j-1] : A[i][j]기준 왼쪽 상단 값
                 * */

                sumArr[i][j] = sumArr[i][j - 1] + sumArr[i - 1][j] - sumArr[i - 1][j - 1] + arr[i][j]; // [i][j-1] ~ [i][j]까지의 합 배열을 구함
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            //앞서 구한 구간합을 통해 답을 도출한다.


            int result = sumArr[x2][y2] - sumArr[x1 - 1][y2] - sumArr[x2][y1 - 1] + sumArr[x1 - 1][y1 - 1];
            System.out.println(result);
        }
    }
}
