package tow_pointer.cat_16472;

import java.util.Scanner;

public class Main {
    /*
    * 문제에서 주어지는 문자열 수
    * 1 <= n <= 100,000
    * 시간제한 : 1초
    * 최소 O(n)이 필요
    *
    *
    * 이 문제는 일반적인 투 포인터 문제에 포인터 범위에 해당하는 문자열이
    * "두 가지"의 문자로만 이루어져 있어야 해서 좀 까다로웠다.
    * 투 포인터로 범위를 순회하면서 문제에서 요구하는 "두 가지"의 문자로만
    * 이루어졌는지에 대한 검사를 진행하였다.
    * 순회하면서 범위에 있는 알파벳의 종류를 담을 배열인 alphabetFrequency과
    * 현재 알파벳 종류가 몇 개인지 확인하는 alphabetCount를 사용한다.
    * */

    // 순회하면서 몇 번째 알파벳이 몇 개 있는지 담을 배열
    static int[] alphabetFrequency = new int[26];

    // 현재 인덱스 범위에 해당하는 알파벳의 종류가 몇 가지인지 담을 변수
    static int alphabetCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = sc.next().toCharArray();

        int result = 0;
        int nextIndex = 0; // endP

        /*
        * for문을 입력받은 문자열의 길이만큼 반복하고
        * 그 안의 while()문의 조건식은 endP로 지정한 nextIndex가 현재 위치에서
        * 문자열의 길이만큼 반복되도록 설정한다.
        *
        * while문에 진입해서 현재 nextIndex가 가르키고 있는 문자를
        * alphabetFrequency에 등록하고 nextIndex+1를 진행한다.
        *
        * 만약 alphabetCount가 문제에서 주어진 n보다 크다면
        * 현재 nextIndex가 가르키고 있는 문자를 alphabetFrequency에서 제외하고
        * while문을 빠져나온다. (다음 사이클 이동은 startP를 한 칸 이동하는 것)
        *
        * 현재까지 유효한 범위의 nextIndex를 result에 담고(Math.max()로 기존 값과 비교 후 넣음)
        * i(startP)를 이동시키기 위해 현재 i가 가르키고 있는 부분의 알파벳을 alphabetFrequency에서 제외한다.
        *
        *
        * 이렇게되면 시간복잡도는 O(n)으로 시간초과가 나지 않는다.
        * */
        // i : startP
        for (int i = 0; i < arr.length; i++) {

            // 입력받은 문자열까지 반복
            while(nextIndex < arr.length){
                // 현재 nextIndex 알파벳 등록
                increaseAlphabet(arr[nextIndex++]);

                // 등록 후 문제에서 주어진 n의 범위에 해당하지 않은 알파벳 숫자를 가지고 있다면
                if(alphabetCount > n){
                    // 담았던 알파벳 빼고
                    decreaseAlphabet(arr[--nextIndex]);
                    // while문 탈출
                    break;
                }
            }
            result = Math.max(result,nextIndex - i);

            //i를 이동하기 위해 현재 i번째 알파벳 빼기
            decreaseAlphabet(arr[i]);
        }

        System.out.println(result);
    }

    // 알파벳 증가
    static void increaseAlphabet(char alp){

        // 입력받은 alp가 현재 카운트에 포함되어 있지 않다면 카운트 올리기
        if(alphabetFrequency[alp - 'a']++ == 0){
            alphabetCount++;
        }
    }

    // 입력받은 alp가 현재 카운트에 포함되어 있다면 카운트 내리기
    static void decreaseAlphabet(char alp){
        if(--alphabetFrequency[alp - 'a'] == 0){
            alphabetCount--;
        }
    }
}
