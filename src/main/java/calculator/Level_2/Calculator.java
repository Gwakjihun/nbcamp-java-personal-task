package calculator.Level_2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    protected static final double PI = 3.141592;

    protected final List<Double> results;       // 사칙연산 결과 저장
    protected final List<Double> circleAreas;   // 원의 넓이 결과 저장

    public Calculator() {
        this.results = new ArrayList<>();
        this.circleAreas = new ArrayList<>();
    }

    public List<Double> getResults() {
        return results;
    }

    public List<Double> getCircleAreas() {
        return circleAreas;
    }

    public void addResult(double result) {
        results.add(result);
    }

    public void addCircleArea(double area) {
        circleAreas.add(area);
    }

    public void removeResult() {
        if (!results.isEmpty()) {
            double removed = results.remove(0);
            System.out.println("삭제된 연산 결과: " + removed);
        } else {
            System.out.println("삭제할 연산 결과가 없습니다.");
        }
    }

    public void inquiryResults() {
        if (results.isEmpty()) {
            System.out.println("저장된 연산 결과가 없습니다.");
        } else {
            System.out.println("저장된 연산 결과 목록:");
            for (double r : results) {
                System.out.println(r);
            }
        }
    }

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
}
