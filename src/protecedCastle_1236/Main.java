package protecedCastle_1236;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.next()); // 행
        int m = Integer.parseInt(sc.next()); // 열

        char[][] arr = new char[n][m];


        for (int i = 0; i < n; i++) { // 배열 입력받기
            arr[i] = sc.next().toCharArray();
        }

        int colCount = 0;
        int rowCount = 0;

        for (int row = 0; row < n; row++) { //row 파악하기
            boolean exist = false;
            for (int col = 0; col < m; col++)
                if(arr[row][col] == 'X'){
                    exist = true;
                    break;
                }
            if(exist) rowCount++;
        }

        for (int col = 0; col < m; col++) { //col 파악하기
            boolean exist = false;
            for (int row = 0; row < n; row++)
                if(arr[row][col] == 'X'){
                    exist = true;
                    break;
                }
            if(exist) colCount++;
        }

        // 순회하면서 x가 배치된 값을 전체 행열의 수에서 빼면 배치되지 않은 부분이 나옴
        int needRowCount = n - rowCount;
        int needColCount = m - colCount;

        /*
        * 각 행열을 순회해서 행열당 필요한 숫자에서 가장 큰 값이 문제에서 요구하는 답이다
        * */
        System.out.println(Math.max(needRowCount,needColCount));

    }
}
