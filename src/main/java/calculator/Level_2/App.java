package calculator.Level_2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 자식 클래스 인스턴스 생성
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        CircleCalculator circleCalculator = new CircleCalculator();

        while (true) {
            System.out.print("사칙연산(1) 또는 원의 넓이 계산(2)을 선택하세요 (1/2): ");
            String mode = sc.next();

            if (mode.equals("1")) {
                // 사칙연산 모드
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = sc.nextInt();
                System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
                char operator = sc.next().charAt(0);

                try {
                    double result = arithmeticCalculator.calculate(num1, num2, operator);
                    System.out.println("결과: " + result);
                } catch (IllegalArgumentException e) {
                    System.out.println("오류: " + e.getMessage());
                    continue;
                }

            } else if (mode.equals("2")) {
                // 원의 넓이 계산 모드
                System.out.print("반지름을 입력하세요: ");
                double radius = sc.nextDouble();

                try {
                    double area = circleCalculator.calculateCircleArea(radius);
                    System.out.println("원의 넓이: " + area);
                } catch (IllegalArgumentException e) {
                    System.out.println("오류: " + e.getMessage());
                    continue;
                }
            } else {
                System.out.println("잘못된 입력입니다. 1 또는 2를 입력해주세요.");
                continue;
            }

            // 삭제 여부
            System.out.print("가장 오래된 결과를 삭제하시겠습니까? (remove 입력 시 삭제): ");
            String remove = sc.next();
            if (remove.equalsIgnoreCase("remove")) {
                arithmeticCalculator.removeResult();
            }

            // 조회 여부
            System.out.print("저장된 결과를 조회하시겠습니까? (inquiry 입력 시 조회): ");
            String inquiry = sc.next();
            if (inquiry.equalsIgnoreCase("inquiry")) {
                arithmeticCalculator.inquiryResults();
            }

            // 종료 여부
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String exit = sc.next();
            if (exit.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            System.out.println(); // 가독성을 위한 공백
        }

        sc.close();
    }
}
