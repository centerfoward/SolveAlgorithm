package line_10431;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt(); // 테스트 케이스 수

        while (p-- > 0){ // 테스트 케이스 수 만큼 반복
            int t = sc.nextInt(); // 테스트 케이스 번호
            int[] arr = new int[20];
            for (int i = 0; i < 20; i++) {
                arr[i] = sc.nextInt(); // 테스트 케이스 데이터 입력 받기
            }
            int cnt = 0; // 수가 물러난 횟수, 답
            int[] sorted = new int[20];
            for(int i = 0; i< 20; i++){
                // 줄 서있는 학생 중에 자신보다 큰 학생 찾기
                // 찾지 못했다면 줄의 가장 뒤에 선다.
                boolean find = false; // 나보다 키카 큰 학생을 찾음을 나타나내는 변수
                for (int j = 0; j < i; j++) {
                    if(sorted[j] > arr[i]) {
                        // 찾았으면, 그 학생의 앞에 선다
                        // 그 학생과 그 뒤의 학생이 모두 한칸씩 물러난다
                        find = true; // 찾았으므로 true로 변경
                        for (int k = i - 1; k >= j; k--) { // 현재 찾은 학생의 위치는 k=j, 찾은 위치의 뒤 학생들의 범위는 k < i-1
                            sorted[k + 1] = sorted[k]; // 배열을 0~부터 순회하면서 앞으로 값을 땡기면 논리적인 오류가 발생하므로
                            cnt++;                     // 뒤에서부터 거꾸로 순회하면서 정렬한다.
                        }
                        sorted[j] = arr[i]; // 정렬 후 내 값은 i에 위치.
                        break;
                    }
                }
                if(!find) sorted[i] = arr[i]; // 나보다 큰 학생을 찾지 못했으므로 i 위치로 배정
            }
            System.out.println(t+" " + cnt);
        }
    }
}
