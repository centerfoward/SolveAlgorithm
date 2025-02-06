package translate_11005;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        String ans = "";
        while(n > 0){
            int digit = n % b;
            if(digit < 10) ans += digit;
            else ans += ((char)('A' + digit - 10));
            n /= b;
        }
        for (int i = ans.length() - 1; i >= 0;  i--) {
            System.out.print(ans.charAt(i));
        }
        System.out.println();
    }
}
