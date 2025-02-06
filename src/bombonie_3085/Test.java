package bombonie_3085;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[][] arr = init(n,sc);

        // 정답 변수
        int ans = 0;

        // 배열 순회
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //기준점 오른쪽을 바꿀 수 있다면,
                // j < n : j가 n보다 작아야지 유효한 값임
                // arr[i][j] != arr[i][j+1] : 기준점 오른쪽이 같은 색깔 사탕이 아니라면 바꿀 수 있음
                if(j + 1< n && arr[i][j] != arr[i][j+1]){
                    // 사탕 바꾸기
                    chaneCandy(arr,i,j,i,j+1);
                    // 행,열 기준 탐색하기
                    ans = Math.max(ans,Math.max(searchRow(arr),searchColumn(arr)));
                    // 사탕 위치 원복
                    chaneCandy(arr,i,j,i,j+1);
                }

                // 기준점 밑을 바꿀 수 있다면,
                // j < n : j가 n보다 작아야지 유효한 값임
                // arr[i][j] != arr[i+1][j] : 기준점 밑쪽이 같은 색깔 사탕이 아니라면 바꿀 수 있음
                if(i  + 1< n && arr[i][j] != arr[i+1][j]){
                    // 사탕 바꾸기
                    chaneCandy(arr,i,j,i+1,j);
                    // 행,열 기준 탐색하기
                    ans = Math.max(ans,Math.max(searchRow(arr),searchColumn(arr)));
                    // 사탕 위치 원복
                    chaneCandy(arr,i,j,i+1,j);

                }

                // 기준점 밑을 바꿀 수 있다면,
            }

        }
        System.out.println(ans);

    }

    // 배열 초기화
    public static char[][] init(int n, Scanner sc){
        char[][] arr = new char[n][n]; // 사탕을 담을 배열 선언
        for (int i = 0; i < n; i++) {
            /*
             * toCharArray() 메서드로 문자를 한 줄 씩 받아서
             * i행에 해당하는 위치에 넣음
             * */
            arr[i] = sc.next().toCharArray();
        }

        return arr;
    }

    public static void chaneCandy(char[][] arr, int r1, int c1, int r2, int c2){
        char temp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = temp;
    }

    public static int searchRow(char[][] arr){
        /*
        * ans : 순회 후 가장 긴 연속 숫자
        * temp : 순회하면서 임시로 연속 부분 담을 변수
        * temp를 기존에 for문 바깥에다가 int temp = 1; 이런식으로
        * 초기화 하고 진행했더니 이슈가 발생함.
        * 그 이유는 반복문 돌면서 temp를 안쪽 반복문이 끝나고 temp를 1로 초기화 해주지 않으면
        * 안쪽 반복문의 값이 그대로 남아서 바깥쪽 반복문 시작 지점에 temp = 1로 초기화 해주어야
        * 정상적인 값이 나오는걸 확인함.
        * */
        int ans = 0;
        int n = arr.length;
        int temp;

        for (int i = 0; i < n; i++) {
            temp = 1;
            for (int j = 1; j < n; j++) {
                if(arr[i][j] == arr[i][j-1]){
                    temp++;
                }else{
                    ans = Math.max(temp,ans);
                    temp = 1;
                }
            }
            ans = Math.max(temp,ans);
        }

        return ans;
    }

    public static int searchColumn(char[][] arr){
        int ans = 0;
        int n = arr.length;
        int temp;
        for (int i = 0; i < n; i++) {
            temp = 1;
            for (int j = 1; j < n; j++) {
                if(arr[j][i] == arr[j-1][i]){
                    temp++;
                }else{
                    ans = Math.max(temp,ans);
                    temp = 1;
                }
            }
            ans = Math.max(temp,ans);
        }

        return ans;
    }

}
