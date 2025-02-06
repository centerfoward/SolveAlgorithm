package eureka_10448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] inputArr = getTriangleNumber();
        int count = TriangleNumberCount(inputArr);

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            System.out.println(getEurekaNumber(inputArr, k,count));
        }
    }

    static int[] getTriangleNumber() {
        int[] arr = new int[50];
        for (int i = 1; ; i++) {
            if (i * (i + 1) / 2 >= 1000)
                break;
            arr[i] = i * (i + 1) / 2;
        }
        return arr;
    }

    static int TriangleNumberCount(int[] arr){
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == 0){
                break;
            }
            count++;
        }
        return count;
    }

    static int getEurekaNumber(int[] arr, int value,int count) {
        int isEureka = 0;
        for (int i = 1; i < count; i++) {
            for (int j = 1; j < count; j++) {
                for (int k = 1; k < count; k++) {
                    if (arr[i] + arr[j] + arr[k] == value) {
                        isEureka = 1;
                        break;
                    }
                }
                if (isEureka == 1) break;
            }
            if (isEureka == 1) break;
        }

        return isEureka;
    }
}
