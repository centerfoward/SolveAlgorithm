package Palindromes_11068;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while(testCase-- > 0) {
            int x = sc.nextInt();
            // 2~64 진법 변환하면서 회문 체크
            boolean ans = false;
            for (int i = 2; i <= 64; i++) {
                int[] baseDigit = convertBase(x, i);
                if (isPalindrome(baseDigit)) {
                    ans = true;
                    break;
                }
            }
            System.out.println(ans ? "1" : "0");
        }

    }

    public static int[] convertBase(int x, int base){
        // 받아온 테스트 케이스 x의 진법 변환 자리수를 구하기 위해
        // x값을 copyX에 담아서
        // copyX/=base 가 0이 될 때까지 while문을 반복하고
        // 이 때 len++;를 해서 x의 base진수 변환의 자릿 수를 구한다.
        int len = 0;
        int copyX = x;

        while(copyX > 0){
            copyX /= base;
            len++;
        }

        // 구한 자리 수를 가지고
        // 자리 수의 길이에 맞는 int[]를 만들어서
        // 진법 변환 후 반환
        int[] digit = new int[len];
        len = 0;
        while(x > 0){
            digit[len++] = x % base;
            x = x / base;
        }

        return digit;
    }

    public static boolean isPalindrome(int[] digit){
        // 배열을 반으로 잘라서 왼쪽 오른쪽을 비교
        for (int i = 0; i < digit.length / 2; i++) {
            if(digit[i] != digit[digit.length - i  - 1])
                // 만약 비교하면서 다른 자릿 수가 있으면 회문이 아닌걸로 판단하고 false를 반환
                return false;
        }
        return true;
    }
}
