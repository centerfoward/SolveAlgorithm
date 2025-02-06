package binary_search.sum_of_three_number_2295;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * 문제에서 요구하는 세 수의 합이 X가 이루어지는건 다음과 같이 표현할 수 있다.
         * a + b + c = x
         * 만약 이 식대로 풀려하면 3중 for문을 돌려야할텐데 이렇게 되면
         * 시간 초과가 난다.
         * 따라서, 이 식을 좀 쪼개야하는데
         * a + b = x - c
         * 라는 식으로 쪼개질 수 있다.
         * 문제에서 주어지는 배열의 요소들 중 가장 큰 값인 x를
         * 탐색하기 위해 우선 a + b 의 모든 경우의 수를 담은 배열을 하나 만들고
         * 만든 배열을 처음에 주어진 숫자를 담은 배열과 비교하면서
         * 이분탐색을 통해 결과값이 true라면 x의 값을 답을 담은 변수에 할당한다.
         *
         * a + b, x - c 이중 반복문으로 나눠서 시간 복잡도는 O(n^2logn)이 된다.
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 숫자 합의 배열
        int[] sums = new int[n * (n + 1) / 2];
        int sumIndex = 0;

        // a + b 조합 구하는 반복문
        // 중복되는 수의 조합(ex, 1 + 2 & 2 + 1)을 없애기 위해
        // j = i부터 시작
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sums[sumIndex++] = arr[i] + arr[j];
            }
        }

        // 이분 탐색을 위한 정렬
        Arrays.sort(sums);

        int ans = -1; // 정답을 담을 변수

        // x-c 계산 반복문
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int target = arr[i] - arr[j]; // x - c
                if (calc(sums, target)) {
                    // 만약 x-c의 값이 합에 존재한다면,
                    // ans의 현재 값과 arr[i]를 비교해서 큰 쪽을 ans에 대입
                    // 여기서 i는 x
                    ans = Math.max(ans,arr[i]);
                }
            }
        }

        System.out.println(ans);
    }

    // 이분 탐색 함수
    public static Boolean calc(int[] arr, int compareValue) {

        // 이분 탐색을 위한 left, right 포인터 선언
        int l = 0;
        int r = arr.length - 1;

        // l이 r보다 크다면 탐색이 다 끝난것이므로
        // 종료 조건으로 l <= r
        while (l <= r) {
            int m = (l + r) / 2; // 탐색 범위의 중간에 해당하는 값 집어넣기

            // 비교하려는 값이 배열의 m위치에 해당하는 값보다 크다면,
            if (arr[m] < compareValue) {
                l = m + 1;
            }
            // 비교하려는 값이 배열의 m위치에 해당하는 값보다 작다면,
            else if (arr[m] > compareValue) {
                r = m - 1;
            } else {
                // 값 있으면 true 반환
                return true;
            }
        }
        // 없다면 false 반환
        return false;
    }
}
