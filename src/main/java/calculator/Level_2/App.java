package calculator.Level_2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator ac = new ArithmeticCalculator();

        while (true) {
            System.out.print("첫 번째 숫자 입력: ");
            double num1 = sc.nextDouble();

            System.out.print("두 번째 숫자 입력: ");
            double num2 = sc.nextDouble();

            System.out.print("연산자 입력 (+, -, *, /): ");
            char op = sc.next().charAt(0);

            try {
                double result = ac.calculate(num1, num2, op);
                System.out.println("결과: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage());
                continue;
            }

            System.out.print("결과 조회하려면 inquiry, 삭제하려면 remove, 계속하려면 아무 키, 종료하려면 exit: ");
            String command = sc.next();
            if (command.equalsIgnoreCase("inquiry")) {
                ac.inquiryResults();
            } else if (command.equalsIgnoreCase("remove")) {
                ac.removeResult();
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("계산기 종료");
                break;
            }

            System.out.println();
        }

        sc.close();
    }
}
