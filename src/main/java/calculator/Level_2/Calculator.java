package calculator.Level_2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    // 상수 PI는 변경되지 않으므로 static final 키워드를 사용하여 상수로 선언
    // static: 클래스 로딩 시 메모리에 고정되며 모든 인스턴스가 공유됨
    // final: 값 변경 불가 (상수로 사용)
    private static final double PI = 3.141592653589793;

    // 사칙연산 결과 저장 리스트 (캡슐화)
    private List<Integer> results;

    // 원의 넓이 결과 저장 리스트 (캡슐화)
    private List<Double> circleAreas;

    // 생성자에서 리스트 초기화
    public Calculator() {
        results = new ArrayList<>();
        circleAreas = new ArrayList<>();
    }

    // 사칙연산 메서드
    public int calculate(int num1, int num2, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }

        results.add(result); // 결과 저장
        return result;
    }

    // 원의 넓이 계산 메서드
    public double calculateCircleArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("반지름은 0 이상이어야 합니다.");
        }

        double area = PI * radius * radius;
        circleAreas.add(area); // 결과 저장
        return area;
    }

    // 사칙연산 결과 조회
    public void inquiryResults() {
        if (results.isEmpty()) {
            System.out.println("저장된 사칙연산 결과가 없습니다.");
        } else {
            System.out.println("저장된 사칙연산 결과 목록:");
            for (int r : results) {
                System.out.println(r);
            }
        }
    }

    // 원의 넓이 결과 조회
    public void inquiryCircleAreas() {
        if (circleAreas.isEmpty()) {
            System.out.println("저장된 원의 넓이 결과가 없습니다.");
        } else {
            System.out.println("저장된 원의 넓이 결과 목록:");
            for (double area : circleAreas) {
                System.out.println(area);
            }
        }
    }

    // 사칙연산 결과 삭제 (가장 먼저 저장된 것)
    public void removeResult() {
        if (!results.isEmpty()) {
            int removed = results.remove(0);
            System.out.println("삭제된 연산 결과: " + removed);
        } else {
            System.out.println("삭제할 연산 결과가 없습니다.");
        }
    }

    // Getter & Setter
    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }

    public List<Double> getCircleAreas() {
        return circleAreas;
    }

    public void setCircleAreas(List<Double> circleAreas) {
        this.circleAreas = circleAreas;
    }
}
