package tow_pointer.pick_number_2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    * 문제에서 요구하는 수열 요소간 - 연산을 통해 m에 가장 가깝게 근접하는 쌍을 찾으려면
    * 반복문을 오지게 돌리는 방법이 있지만 이는 시간복잡도가 n^3까지 갈 수 있으므로
    * 애초에 시간초과로 통과하지 못한다.
    * 이를 해결하기 위해 two Pointer 개념을 사용.
    * 문제에서 요구하는 답을 구하기위해 경우의 수를 다 따져보면,
    * 12345로 이루어진 수열이 있다고 가정했을 때
    * 1 -2 , 1 - 3, 1 - 4 .... (i - j)까지의 경우의 수를 의미,
    * i를 기준으로 j 값이 증가하면 할수록 i-j가 값이 증가하는
    * 연관관계를 알 수 있다.
    * 이를 이용해 만약 i-j를 연산했을 때 (i-j) <= m 이라면 문제에서
    * 요구하는 답의 조건에 해당하는 것이므로 j값이 남아 있더라도
    * 더이상 반복하지 않고 다음 i로 이동한다.
    * 이분탐색과 다르게 반으로 쪼개서 값을 찾는것이 아닌 탐색을 하다가
    * 조건에 맞으면 다음 탐색을 진행한다고 생각하자.
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 수열 개수
        int m = Integer.parseInt(st.nextToken()); // 기준 수

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); // 정렬

        System.out.println(calc(m,arr,n));


    }


    static int calc(int m, int[] arr,int n){
        int ansDiff = arr[n-1] - arr[0]; // 정답 변수 , 초기값 그냥 설정함
        int pairIndex = 0; // arr[] 순회하기 위한 인덱스 변수
        for (int i = 0; i < n; i++) { // n을 하나씩 순회

            // arr[i] - arr[pairIndex]가 m보다 작은경우까지
            // pairIndex가  arr의 유효한 인덱스까지 이동할 수 있게 조건 걸기
            while(arr[pairIndex] - arr[i] < m && pairIndex < n -1){
                pairIndex++;
            }
            // 답에 근접한 값을 diff에 할당
            int diff = arr[pairIndex] - arr[i];

            // diff가 m보다 크거나 같은지 확인한 후,
            // 기존에 있던 ansDiff값과 비교 후 작은 값을 ansDiff에 할당
            if(diff >= m){
                ansDiff = Math.min(ansDiff,diff);
            }
        }
        return ansDiff;
    }
}
