package NM_15651;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        calc(arr,n,m,0);
        System.out.println(sb);


    }

    static void calc(int[] arr, int n, int m,int pointer){
        if(pointer == m+1){
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        }else{
            for (int i = 1; i < n+1; i++) {
                arr[i] = i;
                calc(arr,n,m,pointer++);
                arr[i] = 0;
            }

        }
    }

}
