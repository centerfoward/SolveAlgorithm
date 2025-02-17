package tow_pointer.joomong_1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
     * 2018번과 twoPointer 유형은 같지만 다르게 풀어야 하는 문제.
     * 합 배열은 필요없고 문제에서 제시한 "두 재료", 즉 두 원소의 합이
     * m이 되는 경우의 수를 체크하면된다.
     * 이 문제는 우선 입력받을 것들 다 입력받고
     * Arrays.Sort()를 사용해 입력받은 재료들의 번호를 정렬하고
     * two Pointer 개념을 사용한다.
     *
     * 포인터 각각을 startP, endP로 나누고 2018번과 다르게
     * startP는 0, endP는 n-1(배열의 크기)로 값을 지정하고
     * startP > endP의 조건이 맞을때까지 반복하면서 알고리즘을 돌린다.
     *
     * 두 원소, arr[startP],arr[endP]가 있다고 가정했을 때
     * arr[startP]+arr[endP] == m, count++;startP++;endP++;
     * arr[startP]+arr[endP] > m, startP++;
     * arr[startP]+arr[endP] < m, endP++;
     * 와 같이 계산하면 된다.
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 재료의 개수

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 갑옷을 만드는 데 필요한 수

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) { // 재료들의 번호 입력받기
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        int startP = 0;
        int endP = n - 1;

        while (startP < endP) {
            if (arr[endP] + arr[startP] == m) {
                count++;
                endP--;
                startP++;
            } else if (arr[endP] + arr[startP] < m) {
                startP++;
            } else {
                endP--;
            }
        }

        System.out.println(count);
    }
}
