package calculator.Level_2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator arithmeticCalc = new ArithmeticCalculator();
        CircleCalculator circleCalc = new CircleCalculator();

        while (true) {
            System.out.print("명령어 입력 (arithmetic / circle): ");
            String command = sc.next();

            if (command.equalsIgnoreCase("arithmetic")) {

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

                System.out.print("사칙연산 기호 입력 (+, -, *, /): ");
                char operator = sc.next().charAt(0);

                try {
                    double result = arithmeticCalc.calculate(num1, num2, operator);
                    System.out.println("결과: " + result);
                } catch (IllegalArgumentException e) {
                    System.out.println("오류: " + e.getMessage());
                    continue;
                }

                System.out.print("remove 입력 시 가장 오래된 연산 결과 삭제: ");
                String remove = sc.next();
                if (remove.equalsIgnoreCase("remove")) {
                    arithmeticCalc.removeResult();
                }

                System.out.print("inquiry 입력 시 저장된 연산 결과 조회: ");
                String inquiry = sc.next();
                if (inquiry.equalsIgnoreCase("inquiry")) {
                    arithmeticCalc.inquiryResults();
                }

            } else if (command.equalsIgnoreCase("circle")) {

                System.out.print("반지름을 입력하세요: ");
                double radius = sc.nextDouble();

                try {
                    double area = circleCalc.calculateCircleArea(radius);
                    System.out.println("원의 넓이: " + area);
                } catch (IllegalArgumentException e) {
                    System.out.println("오류: " + e.getMessage());
                    continue;
                }

                System.out.print("inquiry 입력 시 저장된 원의 넓이 결과 조회: ");
                String inquiry = sc.next();
                if (inquiry.equalsIgnoreCase("inquiry")) {
                    circleCalc.inquiryCircleAreas();
                }

            } else {
                System.out.println("올바르지 않은 명령입니다.");
                continue;
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String exit = sc.next();
            if (exit.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
            System.out.println(); // 공백
        }

        sc.close();
    }
}
