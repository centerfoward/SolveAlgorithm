package solvedac.pocketmon_1620;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 포켓몬의 개수
        int m = sc.nextInt(); // 문제의 개수

        // 문제에서 주어지는 조건은 1<= n,m <= 100,000이다.
        // 만약 map을 하나로 만든다면 Key에 해당하는 값은
        // 메서드로 한 번에 호출(O(1))이 가능하지만,
        // Value로 찾아야하는 부분에서는 전체 Map을 순회(O(n))하면서
        // 찾아야 하기 때문에 시간 초과가 발생한다.
        // 이를 해결하기 위해 다음과 같이
        // 입력을 <숫자,이름>,<이름,숫자>로 나눠서
        // 순회를 하지 않고 한 번에 호출(O(1))로 시간을 줄여서
        // 문제를 해결했다.

        Map<String,String> arr = new HashMap();
        Map<String,String> arr2 = new HashMap();

        // key : 문자
        // value : 숫자
        for (int i = 1; i < n+1; i++) {
            String inputData = sc.next();
            arr.put(inputData, String.valueOf(i));
            arr2.put(String.valueOf(i),inputData);
        }

        while(m-- > 0){
            String input = sc.next();
            // 입력받은 첫 글자가 알파벳이라면 당연히 알파벳이기에 이를 이용해서
            // 입력받은 값이 숫자인지 알파벳인지 구분한다.
            if(('a' <= input.charAt(0) && input.charAt(0) <= 'z') || ('A' <= input.charAt(0) && input.charAt(0) <= 'Z')){
                System.out.println(arr.get(input));
            }else{
                // 입력받은 값이 숫자라면
                // map과 value가 들어감
                System.out.println(arr2.get(input));
            }

        }
    }
}
