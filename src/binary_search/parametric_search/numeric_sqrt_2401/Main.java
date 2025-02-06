package binary_search.parametric_search.numeric_sqrt_2401;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    // 0 <= n < 2^63 이니까 long으로 처리
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(binarySearch(n));
    }

    // 이진 탐색 함수
    public static long binarySearch(long n){

        // 찾으려는 값이 0 이라면 0 반환
        if(n == 0) return 0;

        long sqrt = -1; // 정답을 담을 변수 -1로 초기화
        long l = 1; // left pointer 1
        // right pointer을 문제에서 제공하는
        // n의 범위인 2^63의 범위의 반인 2^32로 지정
        long r = 1L << 32;

        while(l <= r){
            long m = (r+l) / 2;
            if (m >= (n - 1) / m + 1) { // m이 n보다 크다면,
                r = m - 1;
                sqrt = m;
            }else{ // m이 n보다 작다면,
                l = m + 1;
            }
        }
        return sqrt;
    }
}
