package tow_pointer.part_sum_1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 부분합 구하기
        // 이 부분합의 인덱스 길이 구하기
        // 구한 길이 중 가장 짧은 것 구하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오른쪽 포인터

        // for문으로 돌리는 i 값이 startP이므로 따로 선언 안함
        int endP = 0;

        // 구간 합을 임시로 저장할 변수
        int sum = arr[0];

        // 정답을 담을 변수
        int ans = n + 1;

        // n번 반복
        for (int i = 0; i < n; i++) {
            // 구간 합이 s보다 작고 enp가 인덱스 범위를 안넘어갈때까지,
            while(sum < s && endP < n-1){
                sum += arr[++endP]; // 구간합 구하기
            }

            // while문을 벗어나서 임시로 구한 구간합이 s보다 크거나 같다면,
            // 정답 변수에 Math.min()를 사용해서 ans과 endP의 현재 위치, i의 현재 위치를 빼고 1을 추가하여 구간합의 구간을 구함
            if(sum >= s){
                ans = Math.min(ans,endP - i + 1);
            }

            // startP의 위치를 오른쪽으로 옮기기 위해 i위치에 해당하는 배열 값을 sum에서 제외
            sum -=arr[i];
        }

        // ans가 위 계산에서 갱신되지 않았다면 답을 못찾은것이므로
        if(ans > n){
            ans = 0;
        }
        System.out.println(ans);
    }
}
