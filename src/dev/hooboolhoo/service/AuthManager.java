package dev.hooboolhoo.service;

import dev.hooboolhoo.model.User;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthManager {
    UserListController userListController;

    private CurrentUser currentUser;
    private boolean isSignIn = false;

    private static final Scanner sc = new Scanner(System.in);
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\." +
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                    "A-Z]{2,7}$";

    public AuthManager(UserListController userListController, CurrentUser currentUser) {
        this.userListController = userListController;
        this.currentUser = currentUser;
    }

    public boolean getIsSignIn() {
        return isSignIn;
    }

    public void signUp() {
        while (true) {
            System.out.print("사용하실 아이디를 입력해주세요. (이메일) : ");
            String id = sc.nextLine();

            int validationCode = checkValidation(id);
            // 이미 회원가입한 경우 or 이메일 형식이 유효하지 않은 경우
            if (validationCode == 1) { // 이메일 형식이 유효하지 않은 경우
                System.out.println("다시 입력해주세요.");
            }
            else if (validationCode == 2) { // 이미 회원가입한 이메일일 경우
                int choice;

                while (true) {
                    System.out.println("1. 새로운 아이디로 회원가입 하기 2. 기존 아이디로 로그인 하기");
                    System.out.print("입력: ");

                    choice = sc.nextInt();
                    sc.nextLine();

                    if (choice != 1 && choice != 2) {
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    } else {
                        break;
                    }
                }

                if (choice == 2) {
                    break;
                }
            }
            else { // 유효한 아이디일 경우
                System.out.print("사용하실 비밀번호를 입력해주세요: ");
                String password = sc.nextLine();

                System.out.print("사용하실 닉네임을 입력해주세요: ");
                String nickname = sc.nextLine();

                // User List에 추가하기
                User newUser = new User(id, password, nickname);
                userListController.addUser(newUser);
                System.out.println("회원가입이 완료되었습니다.");
                break;
            }
        }
    }

    public Boolean signIn() {
        while(true) {
        System.out.print("아이디: ");
        String id = sc.nextLine();

        List<User> userList = userListController.getUserList();
        boolean isIdExist = false;
        String password = "";
        String nickname = "";

        for (User user: userList) {
            if (id.equals(user.getId())) {
                isIdExist = true;
                password = user.getPassword();
                nickname = user.getNickname();
                currentUser.setUser(user);
                break;
            }
        }

            if (isIdExist) {
                while (true) {
                    System.out.print("비밀번호: ");
                    String inputPassword = sc.nextLine();

                    if (password.equals(inputPassword)) {
                        System.out.printf("안녕하세요, %s 님!\n", nickname);
                        isSignIn = true;
                        break;
                    } else {
                        System.out.println("비밀번호를 다시 입력해주세요.");
                    }
                }

                if (isSignIn)
                    break;
            }
            else {
                System.out.println("아이디가 존재하지 않습니다. 다시 입력해주세요.");
            }
        }

        return isSignIn;
    }

    private int checkValidation(String id) {
        boolean isAlreadySignUp = false;
        List <User> userList = userListController.getUserList();

        for (User user : userList) {
            if (user.getId().equals(id)) {
                isAlreadySignUp = true;
                break;
            }
        }

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(id);

        if (isAlreadySignUp) { // 이미 회원가입 된 이메일일 경우
            System.out.println("이미 가입된 이메일 입니다.");
            return 2;
        } else if (!matcher.matches()) { // 이메일 형식이 아닐 경우
            System.out.println("잘못된 이메일 형식입니다.");
            return 1;
        } else {
            return 0;
        }
    }
}
