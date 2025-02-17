package tow_pointer.dna_password_12891;

import java.util.Scanner;

class Main {
    static int baseToIndex(char alp) {
        if (alp == 'A') return 0;
        else if (alp == 'C') return 1;
        else if (alp == 'G') return 2;
        else if (alp == 'T') return 3;
        return -1;
    }

    // 현재 부분문자열에 들어가 있는 카운트가 minimumBaseCount보다 작은지 확인하는 함수
    static boolean isValidSequence(int[] baseCount, int[] minimumBaseCount) {
        for (int i = 0; i < baseCount.length; i++)
            if (baseCount[i] < minimumBaseCount[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt(); // 문자열 길이
        int P = sc.nextInt(); // 부분문자열 길이

        char[] sequence = sc.next().toCharArray(); // 임의의 문자열

        int[] minimumBaseCount = new int[4]; // A,C,G,T 카운트 담을 배열

        for (int i = 0; i < 4; i++){
            minimumBaseCount[i] = sc.nextInt();
        }

        int[] currentBaseCount = new int[4];

        /*
        * 입력받은 임의의 문자열을 P까지 순회하면서
        * 순회하는 요소가 A,C,G,T에 해당하는 문자라면
        * 각각 0,1,2,3 index에 ++ 연산
        * */
        for (int i = 0; i < P; i++){
            currentBaseCount[baseToIndex(sequence[i])]++;
        }


        // int ans = isValidSequence(currentBaseCount, minimumBaseCount) ? 1 : 0;
        int ans = 0;
        // 모든 경우의 수 탐색
        for (int i = 1; i <= S - P; i++) {
            // 이번 윈도우의 끝 값을 추가
            currentBaseCount[baseToIndex(sequence[i - 1])]--;

            // 이번 윈도우의 첫 값을 제거
            currentBaseCount[baseToIndex(sequence[i + P - 1])]++;
            // 현재 count가 minimumBaseCount를 만족한다면,
            if (isValidSequence(currentBaseCount, minimumBaseCount)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
