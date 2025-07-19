package calculator.Level_2;

public class ArithmeticCalculator extends Calculator {

    public double calculate(int num1, int num2, char operator) {
        double result;

        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if (num2 == 0) throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                result = (double) num1 / num2;
                break;
            default: throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }

        results.add(result);
        return result;
    }
}
