package tow_pointer.junpyo_stone_15831;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    /*
    * 문제의 테스트 케이스인 n의 범위는
    * 1 <= n <= 300,000 이다. 시간제한은 1초로
    * n^2 이상의 시간복잡도를 가진 알고리즘을 짜면 안된다.
    *
    * 문제에서 주어진 조건은 다음과 같다.
    * 입력으로 들어오는 w,b의 값은 각각 흰돌, 검은돌을 뜻하고
    * 경로상에 흰 돌은 w값 이상이여야 하고 검은돌은 b이하여야 한다.
    *
    * bruteForce로 문제를 풀면 금방 해결할 수 있지만
    * 시간초과가 나므로 이를 투포인터로 해결한다.
    * */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 테스트케이스 개수
        int b = sc.nextInt(); // 검은돌
        int w = sc.nextInt(); // 하얀돌

        char[] arr = sc.next().toCharArray(); // 돌 배열

        int nextIndex = 0; // endP 변수
        int result = 0; // 정답 변수
        int tempB = 0; // 임시로 검은돌을 담을 변수
        int tempW = 0; // 임시로 하얀돌을 담을 변수

        // 테스트 케이스 개수인 n 만큼 반복
        // 여기서 n은 startP
        for (int i = 0; i < n; i++) {

            // nextIndex가 배열의 끝까지 닿을 때 까지,
            while(nextIndex < n){

                // 문제에서 주어진 검은돌의 개수를 다 채웠거나
                // 현재 가르키고 있는 인덱스의 값이 'B'라면
                // 더이상 확장이 불가능하므로 break;
                if(tempB == b && arr[nextIndex] == 'B'){
                    break;
                }

                // 검은돌 개수를 아직 다 채운게 아닌 경우
                // 다음 인덱스 번호에 해당하는 값이 흰돌인지 검은돌인지 확인 후
                // 그에 맞는 변수에 ++ 연산
                if(arr[nextIndex++] == 'W'){
                    tempW++;
                }else{
                    tempB++;
                }
            }

            // while문을 빠져나오고
            // 하얀돌이 문제에서 제시하는 조건에 부합한다면,
            // 정답 변수에 값 넣기
            // while문 안에서 이미 검은돌에 대한 정답 검사는
            // 이루어지기에 여기서는 하얀돌만 정답 검사 실행
            if(tempW >= w){
                result = Math.max(result,nextIndex - i);
            }

            // 현재 startP를 가르키고 있는 i가 다음 칸으로 이동해야 하기 때문에
            // i에 해당하는 값을 뺀다.
            if(arr[i] == 'W'){
                tempW--;
            }else{
                tempB--;
            }
        }

        System.out.println(result);
    }
}
