package bombonie_3085;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j + 1 < n && map[i][j] != map[i][j+1]){
                    swapCandy(map,i,j,i,j+1);
                    ans = Math.max(ans,Math.max(maxColumn(map),maxRow(map)));
                    swapCandy(map,i,j,i,j+1);
                }

                if(i + 1 < n  && map[i][j] != map[i+1][j]){
                    swapCandy(map,i,j,i+1,j);
                    ans = Math.max(ans,Math.max(maxColumn(map),maxRow(map)));
                    swapCandy(map,i,j,i+1,j);
                }
            }
        }

        System.out.println(ans);
    }

    public static void swapCandy(char[][] map, int r1, int c1, int r2, int c2){
        char temp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = temp;
    }

    public static int maxRow(char[][] map){
        int n = map.length;
        int maxRow = 0;

        for (int i = 0; i < n; i++) {
            int len = 1;
            for (int j = 1; j < n; j++) {
                if(map[i][j] == map[i][j-1]) len++;
                else{
                    maxRow = Math.max(maxRow,len);
                    len = 1;
                }
            }
            maxRow = Math.max(maxRow,len);
        }
        return maxRow;
    }

    public static int maxColumn(char[][] map){
        int n = map.length;
        int maxRow = 0;

        for (int i = 0; i < n; i++) {
            int len = 1;
            for (int j = 1; j < n; j++) {
                if(map[j][i] == map[j-1][i]) len++;
                else{
                    maxRow = Math.max(maxRow,len);
                    len = 1;
                }
            }
            maxRow = Math.max(maxRow,len);
        }
        return maxRow;
    }

}
