package calculator.Level_2;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Calculator 인스턴스 생성
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            if (num1 < 0) {
                System.out.println("양의 정수(0 포함)을 입력해주세요.");
                continue;
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();
            if (num2 < 0) {
                System.out.println("양의 정수(0 포함)을 입력해주세요.");
                continue;
            }

            System.out.print("사칙연산의 기호를 입력하세요: "); // +, -, *, /
            char operator = sc.next().charAt(0);

            try {
                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage());
                continue;
            }

            // remove 기능
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String removeInput = sc.next();
            if (removeInput.equalsIgnoreCase("remove")) {
                Integer removed = calculator.removeResult();
                if (removed != null) {
                    System.out.println("삭제된 연산 결과: " + removed);
                } else {
                    System.out.println("삭제할 연산 결과가 없습니다.");
                }
            }

            // inquiry 기능
            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            String inquiryInput = sc.next();
            if (inquiryInput.equalsIgnoreCase("inquiry")) {
                calculator.inquiryResults(); // Calculator 내부 메서드 호출 (캡슐화 적용)
            }

            // exit 종료 기능
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)");
            String answer = sc.next();
            if (answer.equalsIgnoreCase("exit")) {   // 대소문자 구분없이 적용
                System.out.println("계산기를 종료하겠습니다.");
                break;
            }

            System.out.println(); // 가독성을 위한 공백
        }

        sc.close(); // 자원 반납
    }
}
