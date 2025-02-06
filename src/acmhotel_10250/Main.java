package acmhotel_10250;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();


        while(testCase > 0){

            int h = sc.nextInt(); // 건물 높이(Row)
            int w = sc.nextInt(); // 건물 넓이(Column)
            int count = sc.nextInt(); // n번째 손님
            int temp = 0; // 손님 수 세기 위한 변수


            boolean[][] arr = new boolean[h+1][w+1];

            for (int i = 1; i < w+1; i++) {
                for (int j = 1; j < h+1; j++) {
                    if(!arr[j][i]){
                        //System.out.println((j*100)+(i));
                        arr[j][i] = true;
                        temp++;
                    }

                    if(temp == count){
                       System.out.println((j*100)+(i));
                        break;
                    }
                }
            }
            testCase--;
        }
    }
}
