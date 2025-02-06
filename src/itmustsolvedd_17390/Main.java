package itmustsolvedd_17390;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
     * 1. 비내림차순 정렬
     * 원소가 감소하지 않은(같거나 증가하는) 순서를 말함
     *
     *
     *
     * 2. 수열합
     * L에서부터 R의 범위까지 반복해서 합을 구함
     *
     * */

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken()); // 수열 A의 길이
        int q = Integer.parseInt(st.nextToken()); // 질문의 개수
        int[] arr = new int[n + 1]; // 입력받을 배열
        int[] sum = new int[n + 1]; // 누적합을 받을 배열
        int recurSum = 0;

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 비내림차순 정렬
        // DualPivotQuicksort
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        // 누적합 계산
        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i-1] + arr[i];
        }

        while (q > 0) {
             st = new StringTokenizer(br.readLine()," ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if(l - 1 < 0){
                sb.append(arr[r]-arr[l]).append("\n");
            }else {
                sb.append(arr[r]-arr[l-1]).append("\n");
            }
            q--;
        }
        System.out.println(sb);
    }
}

