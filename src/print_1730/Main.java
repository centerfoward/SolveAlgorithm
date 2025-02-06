package print_1730;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
        * 빈 명령어가 들어올 수 있기 때문에
        * nextLine()으로 개행문자 처리 & 명령어 받는 곳에도 nextLine()하기
        * */
        int arrCase = sc.nextInt();
        sc.nextLine();
        char[] commandArr = sc.nextLine().toCharArray();
        char[][] arr = initArr(arrCase);


        // 명령어가 없다면 배열 출력하고 프로그램 종료
        if(commandArr.length == 0){
            printArr(arr);
            return;
        }

        // 명령어 개수
        int commandCount = commandArr.length;

        // 실행한 명령어 개수 담을 변수
        int i = 0;

        // 현재 위치의 행열 지정할 변수
        int currentRow = 0;
        int currentCol = 0;

        // 명령어 개수대로 while문 반복
        while (commandCount > 0) {
            // 명령어 순서대로 switch문 실행
            switch (commandArr[i]) {
                case 'D':
                    if (arr.length > currentRow + 1) { // 명령어의 결과가 배열의 크기를 넘지 않는다면 실행
                        // 현재 위치와 움직일 위치의 문자를 바꿔야 하기 때문에 현재 위치와 다음 위치에서 changeArrChar 호출
                        changeArrChar(currentRow, currentCol, arr, commandArr[i]);
                        currentRow++;
                        changeArrChar(currentRow, currentCol, arr, commandArr[i]);
                    }
                    // 명령어 실행이 끝났다면 명령어의 순서를 가르키는 i 변수에 ++ 연산
                    i++;
                    break;
                case 'R':
                    if (currentCol + 1 < arr.length) {
                        changeArrChar(currentRow, currentCol, arr, commandArr[i]);
                        currentCol++;
                        changeArrChar(currentRow, currentCol, arr, commandArr[i]);
                    }
                    i++;
                    break;
                case 'U':
                    if (currentRow - 1 >= 0) {
                        changeArrChar(currentRow, currentCol, arr, commandArr[i]);
                        currentRow--;
                        changeArrChar(currentRow, currentCol, arr, commandArr[i]);
                    }
                    i++;
                    break;
                case 'L':
                    if (currentCol - 1 >= 0) {
                        changeArrChar(currentRow, currentCol, arr, commandArr[i]);
                        currentCol--;
                        changeArrChar(currentRow, currentCol, arr, commandArr[i]);
                    }
                    i++;
                    break;
            }
            commandCount--;
        }
        printArr(arr);
    }

    // 배열 초기화 함수
    public static char[][] initArr(int length) {
        char[][] arr = new char[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                arr[i][j] = '.';
            }
        }
        return arr;
    }

    // 움직여야할 행,열, 흔적을 담은 배열, 명령어 받아서 처리하는 함수
    public static void changeArrChar(int row, int col, char[][] arr, char command) {

        // 움직일 행열의 크기가 배열의 범위를 벗어나면 함수 종료
        if (row > arr.length || col > arr.length) {
            return;
        }

        // 명령어에 따라 문자를 배열에 삽입
        if (arr[row][col] == (char) 46) { // .
            if (command == 'D' || command == 'U') {
                arr[row][col] = (char) 124; // |
            } else if (command == 'L' || command == 'R') {
                arr[row][col] = (char) 45; // -
            }
        } else if (arr[row][col] == (char) 45) { // -
            if (command == 'D' || command == 'U') {
                arr[row][col] = (char) 43; // +
            }
        } else if (arr[row][col] == (char) 124) { // |
            if (command == 'L' || command == 'R') {
                arr[row][col] = (char) 43; // +
            }
        }
    }

    // 배열 출력 함수
    public static void printArr(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
