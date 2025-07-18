package calculator.Level_2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    // 연산 결과를 무한히 저장하는 컬렉션
    private List<Integer> results = new ArrayList<>();

    // 연산 결과 조회용 getter
    public  List<Integer> getResults() {
        return results;
    }

//      사칙연산 수행
//      @param num1 첫 번째 양의 정수 (0 포함)
//      @param num2 두 번째 양의 정수 (0 포함)
//      @param operator 사칙연산 기호 (+, -, *, /)
//      @return 계산 결과 값 (int)
//      @throws IllegalArgumentException 유효하지 않은 연산자나 0으로 나누는 경우

    public int calculate(int num1, int num2, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case  '-':
                result = num1 - num2;
                break;
            case  '*':
                result = num1 * num2;
                break;
            case   '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다."); // 자바에서 기본으로 제공되는 예외 클래스
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다. (+, -, *, / 만 허용)");
        }

        results.add(result); // 결과 저장
        return result;
    }
}

