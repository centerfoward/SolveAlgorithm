package ChangeChr_2744;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String temp = sc.next();
        StringBuilder ans = new StringBuilder();

        /*
        * 아스키 코드의 개념을 알면 간단하게 풀 수 있는 문제
        * 글자를 charAt()로 하나씩 검사하는데 이 때 문자가
        * 소문자인지 대문자인지에 따라 계산해서 변환
        * 주의할 점은 계산할 때 char로 캐스팅 안하면 숫자 값이 나옴.
        * */

        for (int i = 0; i < temp.length(); i++) {

            if('A' <= temp.charAt(i) && temp.charAt(i) <= 'Z'){ // 대문자일 때,
                ans.append((char)(temp.charAt(i) - 'A' + 'a'));
            }else if('a' <= temp.charAt(i) && temp.charAt(i) <= 'z'){ // 소문자일 때,
                ans.append((char)(temp.charAt(i) - 'a' + 'A'));
            }
        }

        System.out.print(ans);
    }

}
