package tow_pointer.sum_of_number_2018;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
         * 투 포인터는 두 개의 인덱스 포인터를 움직이면서 값을 찾는 알고리즘이다.
         * 구간합 ==  answer
         * 구간합과 정답이 같다면 값을 찾은것이고 이 떄 endP를 이동하고
         * 구간합에 endP를 더한다.
         *
         * 구간합 > answer
         * 구간합이 정답보다 크다면 당연히 범위를 줄여야 answer에 가까워지기에
         * startP를 한 칸 이동하고 구간합에서 startP를 뺀다.
         *
         * 구간합 < answer
         * 구간합이 정답보다 작다면 당연히 범위를 넓혀야 answer에 가까워지기에
         * endP를 한 칸 이동하고 구간합에 endP를 더한다.
         *
         * 위 공식은 구간합을 하는 원소의 나열이 오름차순으로 정렬되어있음을 가정으로 한다.
         * */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 1;
        int starP = 1;
        int endP = 1;
        int sum = 1;

        while (endP != n) { // endP가 n에 도달할때까지,
            if (sum == n) { // sum이 n과 같다면 구간 합을 찾은것이므로 count++
                count++;
                endP++; // endP 이동
                sum = sum + endP; // sum에 endP 합
            } else if (sum > n) { // sum이 n보다 작다면,
                sum = sum - starP; // startP에 있는 값을 뺌
                starP++; // startP 이동
            } else {
                endP++; // sum이 n보다 크다면 endP 이동
                sum = sum + endP; // sum에 endP 합
            }
        }
        System.out.println(count);
    }
}
