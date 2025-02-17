package tow_pointer.sum_array_11728;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        int[] arr2 = new int[m];
        int[] sumArr = new int[n+m];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(sumArr);

        for(int a : sumArr){
            System.out.print(a+" ");
        }
    }

    static int[] calc(int[] arr1, int[] arr2,int[] sumArr){
        int n = arr1.length;
        int m = arr2.length;
        int count = n+m;



        for (int i = 0; i < n; i++) {
            sumArr[i] = arr1[i];
        }
        for (int i = 0; i < m; i++) {
            sumArr[i+n] = arr2[i];
        }



        return sumArr;
    }
}
