package dev.hooboolhoo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = -1;

        System.out.println("🐯🔥🐯호불호🐯🔥🐯");

        while(true) {
            System.out.println("0. 종료 1. 회원가입 2. 로그인");
            System.out.print("입력: ");
            input = sc.nextInt();

            switch (input) {
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                case 1:
                    System.out.println("[회원가입]");

                    break;
                case 2:
                    System.out.println("[로그인]");

                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    break;
            }
        }
    }
}
