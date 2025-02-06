package wordexam_1157;

import java.util.Scanner;

public class Main {
    /*
    * 대소문자로 구분되어지는 단어가 input으로 주어짐
    * output은 대문자이기에 처음 입력받을 떄 toUpperCase()로 바로 다 대문자로 바꿔서 번거로움을 없앰
    * 여기서 또 중요하게 봐야하는게 최댓값을 구하는건 간단하지만 "최대값이 두 개 이상이라면 ? 출력"이라는 조건이 있다.
    * 이를 처리하기 위해 최대값과 같은 값이 있다면 output을 담은 변수를 '?'로 바꾸는 작업도 필요.
    * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next().toUpperCase();
        int[] arr = new int[26];

        int maxCount = 0;
        char ans = '?';

        for (int i = 0; i < input.length(); i++) {
            arr[input.charAt(i)-'A']++;
        }

        for (int i = 0; i < arr.length; i++) {
            if(maxCount < arr[i]){
                maxCount = arr[i];
                ans = (char)('A' + i);
            } else if(maxCount == arr[i]){
                ans = '?';
            }
        }

        System.out.println(ans);


    }
}
