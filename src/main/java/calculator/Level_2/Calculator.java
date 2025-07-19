package calculator.Level_2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    // 연산 결과를 저장하는 컬렉션 필드를 private로 캡슐화
    private List<Integer> results;

    // 생성자에서 컬렉션 초기화
    public Calculator() {
        this.results = new ArrayList<>();
    }

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

    // remove 기능
    public Integer removeResult() {
        if (!results.isEmpty()) {
            return results.remove(0);
        }
        return null;
    }

    // inquiry 기능
    public void inquiryResults() {
        if (results.isEmpty()) {
            System.out.println("저장된 연산 결과가 없습니다.");
        } else {
            System.out.println("저장된 연산 결과 목록:");
            for (int result : results) {
                System.out.println(result);
            }
        }
    }
}

