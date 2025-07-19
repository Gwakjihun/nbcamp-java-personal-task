package calculator.Level_2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("사칙연산 또는 원의 넓이 계산 중 무엇을 하시겠습니까? (calc 또는 circle 입력): ");
            String mode = sc.next();

            if (mode.equalsIgnoreCase("calc")) {
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

                System.out.print("사칙연산의 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                try {
                    int result = calculator.calculate(num1, num2, operator);
                    System.out.println("결과: " + result);
                } catch (IllegalArgumentException e) {
                    System.out.println("오류: " + e.getMessage());
                    continue;
                }

                System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제): ");
                String removeInput = sc.next();
                if (removeInput.equalsIgnoreCase("remove")) {
                    calculator.removeResult();
                }

                System.out.print("저장된 연산 결과를 조회하시겠습니까? (inquiry 입력 시 조회): ");
                String inquiryInput = sc.next();
                if (inquiryInput.equalsIgnoreCase("inquiry")) {
                    calculator.inquiryResults();
                }

            } else if (mode.equalsIgnoreCase("circle")) {
                System.out.print("원의 반지름을 입력하세요: ");
                double radius = sc.nextDouble();

                try {
                    double area = calculator.calculateCircleArea(radius);
                    System.out.println("원의 넓이: " + area);
                    calculator.inquiryCircleAreas(); // 결과 바로 조회
                } catch (IllegalArgumentException e) {
                    System.out.println("오류: " + e.getMessage());
                    continue;
                }
            } else {
                System.out.println("지원하지 않는 명령입니다. calc 또는 circle 중 하나를 입력하세요.");
                continue;
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String answer = sc.next();
            if (answer.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            System.out.println(); // 가독성 위한 공백
        }

        sc.close();
    }
}
