package sort.sort_by_age_10814;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        * 1 < n < 100,000
        * 1 <= age <= 200
        * name.length <= 100
        * name은 알파벳 대소문자로만 이루어짐
        *
        * 문제에서 나이만 비교하면 된다는 조건을 달았기에 나이만 비교해서 정렬
        * */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] arr = new Student[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Student(
                    sc.nextInt(),
                    sc.nextLine()
            );
        }

        Arrays.sort(arr, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.age > o2.age){ // o2를 앞으로 땡김
                    return 1;
                }else if(o1.age < o2.age){ // o1을 앞으로 땡김
                    return -1;
                }else{ // 그대로
                    return 0;
                }
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i].age+arr[i].name);
        }

    }
}

// 학생 데이터 클래스 선언
class Student {
    int age;
    String name;

    Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

/*
이런식으로 데이터 클래스에 Comparator를 impl 해서 직접 compare를 구현하는 방법도 있음
여러번 compare를 하는거라면 이 방법 사용 추천
*/
//class Student implements Comparator<Student> {
//    int age;
//    String name;
//
//    Student(int age, String name) {
//        this.age = age;
//        this.name = name;
//    }
//
//
//    @Override
//    public int compare(Student o1, Student o2) {
//        return o1.age - o2.age; // 오름차순 정렬
//    }
//}



