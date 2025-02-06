package sort.sort_word_1181;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        * 문제에서 주어진 N의 범위는 1 <= N <= 20,000이고
        * 구현한 로직의 시간복잡도를 계산하면 O(N)이 나온다.
        * 정리하자면 최악의 시간 복잡도는 20,000이 나옴
        * */


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n]; // 입력받을 배열 선언
        List<String> arr2 = new ArrayList<>(); // 중복 제거한 요소 담을 배열 선언

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next(); // 요소 입력
        }
        // 단어 길이 오름차순 정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                /*
                * return 값
                * 음수 : o1이 o2보다 먼저
                * 양수 : o2가 o1보다 먼저
                * 0 : 그대로 진행
                * */

                // o2를 앞으로 땡김
                if(o1.length() > o2.length()){
                    return 1;
                }else if(o1.length() < o2.length()){ // o1을 앞으로 땡김
                    return -1;
                }else{
                    /*
                    * 문자 길이가 같은건 알파벳 순으로 정렬
                    * compareTo 반환값
                    * 0 : 기준값과 비교 대상이 동일한 경우
                    * 음수 : 기준 값이 비교대상 보다 작은 경우
                    * 양수 : 기준 값이 비교대상 보다 큰 경우
                    * */
                    return o1.compareTo(o2);
                }
            }
        });

        // ArrayList.contains() 사용해서
        // arr2 배열에 없는 요소라면, 즉 중복 제거해서 요소 삽입
        for(String i : arr){
            if(!arr2.contains(i)){
                arr2.add(i);
            }
        }
        for (int i = 0; i < arr2.size(); i++) {
            System.out.println(arr2.get(i));
        }
    }
}
