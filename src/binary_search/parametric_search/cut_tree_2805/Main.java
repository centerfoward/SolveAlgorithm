package binary_search.parametric_search.cut_tree_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n  = Integer.parseInt(st.nextToken()); // 나무의 수
        int m = Integer.parseInt(st.nextToken()); // 나무의 길이

        int[] arr = new int[n]; // 나무의 높이 배열

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(calc(arr,m));

    }

    // 이분탐색 함수
    static int calc(int[] arr,int m){
        int l = 0;
        int r = 1000000000;
        int answer = 0;

        while(l <= r){
           int arrange = (l+r) / 2; // 탐색범위 반으로 쪼개기
            /*
            * 기존과 다르게 l을 조건이 true일 때 이동.
            * 나무의 크기가 자르려는 쪽의 크기보다 크다면 원하는 만큼 나무를 가져갈 수 없으므로
            * 위와 같이 설정함
            * */
           if(isOkay(arrange,arr,m)){
               l = arrange + 1;
               answer = arrange;
           }else{
               r = arrange - 1;
           }
        }
        return answer;
    }

    // 조건 함수
    static Boolean isOkay(int cutH,int[] arr,int M){
        long sum = 0; // input이 10억이므로 overFlow를 대비해서 int가 아닌 long으로
        for (int j : arr) { // 배열 순회
            if (j > cutH) { // 자르려는 크기보다 나무가 크다면,
                sum += j - cutH;
            }
        }
        return sum >= M;
    }
}
