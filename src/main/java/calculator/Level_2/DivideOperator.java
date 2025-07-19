package calculator.Level_2;

public class DivideOperator {
    public double operate(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    }
}
