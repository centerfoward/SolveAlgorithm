package binary_search.numeric_arr_14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken()); // 집합 arr에 포함되어 있는 문자열
        int m = Integer.parseInt(st.nextToken()); // 검사해야 할 문자열 개수
        String[] arr = new String[n]; // 집합 배열
        int count = 0; // 정답 변수

        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine(); // arr입력받기
        }

        // 이분 탐색을 위한 정렬
        // String은 사전순으로 정렬됌
        Arrays.sort(arr);


        // m에 해당하는 값을 입력받을 때마다 탐색
        while(m-- > 0){
            String compareString = br.readLine();
            if(calc(arr,compareString)){
                count++;
            }
        }
        System.out.println(count);

    }

    // 이분 탐색 함수
    public static boolean calc(String[] arr, String compareString){

        // 이분 탐색을 위한 left, right 포인터 선언
        int l = 0;
        int r = arr.length -1;

        // l이 r보다 크다면 탐색이 다 끝난것이므로
        // 종료 조건으로 l <= r
        while(l <= r){
            int m = (l + r) / 2; // 탐색 범위의 중간에 해당하는 값 집어넣기
            /*
            * compareTo 함수는 문자열을 사전순으로 비교
            * 만약 찾으려는 값이 기준 값보다 사전순으로 순위가 낮으면 음수를 반환하고
            * 같다면 0,
            * 사전순 순위가 높다면 양수를 반환
            * 이를 이용해서 if-else 문을 구현
            * */
            int compareResult = arr[m].compareTo(compareString);

            // m이 찾으려는 문자열보다 사전순으로 낮다면
            // l의 위치를 m+1 위치로 옮김
            if(compareResult < 0){
                l = m + 1;
            }
            // m이 찾으려는 문자열보다 사전순으로 높다면
            // r의 값을 m - 1 위치로 옮김
            else if(compareResult > 0){
                r = m - 1;
            }else
            // 찾으면 true 반환
            {
                return true;
            }
        }

        // 없다면 false 반환
        return false;
    }
}
