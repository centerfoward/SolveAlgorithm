package tow_pointer.palindrome_17609;

import java.util.Scanner;

public class Main {
    /*
    * 일반적인 회문 문제에서 "유사 회문"을 찾아야 하는 문제.
    * 이를 해결하기 위해 회문을 구하는 개념을 응용한다.
    *
    * 우선 문제를 전체적으로 파악해보면 내가 해야할 일은 다음과 같다.
    * 1. 회문 검사
    * 2. 유사회문 검사
    * 3. 두 가지 검사가 모두 false라면 회문이 아님
    * 이 세가지를 코드로 구현해야한다.
    * 다음은 이 문제를 풀어나가는 과정이다.
    *
    * 일반적인 회문 문제였다면 받은 문자열을 반으로 쪼개서
    * l,r 포인터를 인덱스 제일 첫 번째, 제일 마지막번째로 두고
    * 한칸씩 땡기면서 마주보는 단계까지 요소가 같다면 회문으로 판단하였다.
    *
    * 하지만 이 문제에서는 앞서 기술한거처럼 "유사 회문"을 찾아야한다.
    *
    * summuus라는 문자열이 주어졌을 때, 여기서 0,1 번 인덱스에 위치한 "s,u"와
    * 5,6 번 인덱스에 위치한 "u,s"만 두고 봤을 때는 회문이다.
    * 하지만 2,3,4번에 위치한 "m,m,u" 때문에 회문이 아니다. 이 때 문제에서
    * "한 문자"만 삭제하면 회문이 되는 것을 유사회문이라고 정의내렸으므로
    * "m,m,u" 각각을 한 번씩 빼서 문자열을 나열해보면 여기서 "u"만 뺀다면
    * 회문이 되는 "유사회문"이 된다.
    *
    * 투포인터를 사용하는것을 가정했을 때 l과 r이 맨 처음 회문 검사를 진행하면
    * l,r이 움직이면서 회문인 곳들을 지나쳐나갈텐데 이 때 처음으로 문자가 달라지는 지점에서
    * 유사회문 검사를 진행한다. l의 위치가 삭제되거나 r의 위치가 삭제된다면 회문일 것인가를
    * 판단해야 하기에 회문 검사 함수를 하나 만들고 이 안에서 일반적인 회문 검사처럼 진행한다.
    *
    * 정리하면 summuus라는 문자열에서 l과 r포인터는 각각 인덱스 첫 번째, 마지막 번째에 위치한 상태로
    * 시작하고 위치가 점점 중앙으로 모이면서 문자열을 비교하다가 틀린 지점이 나타난다면 그 위치 기준 l+1, r-1의 위치에서부터
    * 회문 검사를 진행하여 만약 둘 중 하나라도 true를 반환한다면 "유사회문" 이다.
    *
    * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 문자열의 개수

        while(t-- > 0){
            int l = 0;
            int ans = 0;
            char[] arr = sc.next().toCharArray(); // 문자열 입력받기
            int r = arr.length-1;
            // 그 자체로 회문이면 0
            // 유사회문(한 글자를 삭제하면 회문)이라면 1
            // 둘 모두 아니면 2
            while(l <= r){
                if(arr[l] != arr[r]){
                    // 회문이 아니라면,
                    if(isPalindrome(arr,l+1,r) || isPalindrome(arr,l,r-1)){
                        ans = 1;
                    }else{
                        ans = 2;
                    }
                    break;
                }
                l++;
                r--;
            }
            System.out.println(ans);
        }


    }

    static boolean isPalindrome(char[] arr, int l, int r){
        while(l <= r){
            if(arr[l] != arr[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
