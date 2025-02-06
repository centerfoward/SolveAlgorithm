package anugram_1919;

import java.util.Scanner;

public class Main {
    /*
    * 말장난이 좀 있는 문제지 실제로 구하는거는 두 단어를 비교해서
    * 애너그램으로 만드는 문제.
    * 두 문자를 알파벳 개수의 길이에 해당하는 int[] 배열에 값을 넣는데 이 때
    * 인덱스 순서와 알파벳 순서와 맞는 문자가 입력받았으면 해당하는 인덱스의 요소에 +1 을 한다
    * 그 후 알파벳 순서만큼 반복문을 돌려서 만들어진 배열들을 비교해서
    * 반복문 인수에 해당하는 인덱스에 값들을 -해서 결과값을 ans에 저장한다.
    * */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String temp1 = sc.next();
        String temp2 = sc.next();

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        int ans = 0;

        for (int i = 0; i < temp1.length(); i++) {
            arr1[temp1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < temp2.length(); i++) {
            arr2[temp2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            ans += Math.abs(arr1[i] - arr2[i]);
        }
        System.out.print(ans);
    }
}
