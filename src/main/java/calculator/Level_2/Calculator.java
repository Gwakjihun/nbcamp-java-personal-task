package calculator.Level_2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    // 연산 결과를 저장하는 컬렉션 필드를 private로 캡슐화
    private List<Integer> results = new ArrayList<>();

    // 사칙연산 수행
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

    // Getter 메서드
    public  List<Integer> getResults() {
        return results;
    }

    // Setter 메서드
    public void setResults(List<Integer> newResults) {
        this.results = newResults;
    }

    // remove 기능
    public Integer removeResult() {
        if (!results.isEmpty()) {
            return results.remove(0);
        }
        return null;
    }
}

