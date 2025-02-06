package WelcomeKit_30802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        int n; // 참가자 수
        ArrayList<Integer> arr = new ArrayList<>(6);
        int t; // 티셔츠 묶음 단위
        int p; // 펜 묶음 단위

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.read();

        for(int i = 0; i < 6; i++){ // 티셔츠 사이즈별 개수 주문 받기
            arr.add(br.read());
            arr.get(i);
        }

        t = br.read();
        p = br.read();
        System.out.println("n = " + n);
        System.out.println("t = " + t);
        System.out.println("p = " + p);



    }
}
