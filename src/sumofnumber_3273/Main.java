package sumofnumber_3273;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //br 정의


        int i = 0;
        int count = Integer.parseInt(br.readLine()); // 수열 크기 입력받기
        int[] arr = new int[count]; // 입력받을 수열을 담을 배열 초기화
        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine()," "); // 공백 기준으로 문자 입력받기
        int x = Integer.parseInt(br.readLine()); // 조건식 결과값 x 입력받기

        while (st.hasMoreTokens()){ // 공백을 기준으로 받은 수열 값들 배열에 넣기
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }


        /*
        * 이런 문제는 반복문 2개로 순환하는게 일반적인데 시간제한, 메모리 제한으로
        * 문제에서 주어진 수열 개수 범위인 100000을 반복문 2개인 시간복잡도로 계산하면
        * n^2, 즉 10000000000이라는 큰 수로 시간제한, 메모리 제한에 걸리기에
        * boolean형 배열을 사용해서 반복문 하나를 줄인다.
        * 줄이는 원리는 먼저 주어진 수열 개수 범위 크기 + 1 의 크기의 boolean 배열을 선언해서
        * boolean 배열의 요소 중 앞서 입력받은 수열 값에 해당하는 순서의 요소값을 true로 변환한다.
        * */
        boolean[] arr2 = new boolean[1000001];
        for (int j = 0; j < count; j++) {
            arr2[arr[j]] = true;
        }

        /*
        * 그 후 (x-1)/2 만큼 반복문을 돌리는데 이유는 다음과 같다.
        * boolean형 배열에는 모든 요소값이 있는데
        * 예를 들어 x가 3이고 배열에 1,2라는 요소가 들어있을 때
        * (1,2), (2,1)과 같이 짝이 중복된다. 이 중복되는 값을
        * 없애기 위해 /2 연산을 진행하고 x-1을 하는 이유는
        * 만약 x의 값이 짝수라면 같은 boolean형 배열 탐색 도중
        * 원소값이 같은, 즉 위치가 같은 값을 탐색해서 1,2,3,4라는 요소 중
        * (2,2)라는 중복되는 요소의 값을 찾을 수 있기 때문에 -1을 진행해서
        * x의 값을 홀수로 바꿔준다.
        * */
        for (int j = 0; j <= (x-1)/2; j++) {
            if(j <= 100000 && x - j <= 100000 ){
                // boolean 배열의 원소를 탐색하면서
                // j값과 x-j(x가 되기 위한 j의 짝)값이 존재한다면
                // ans에 1을 더하고 없다면 0을 더한다.
                ans += (arr2[j] && arr2[x-j]) ? 1 : 0 ;
            }
        }
        System.out.println(ans);
    }
}
