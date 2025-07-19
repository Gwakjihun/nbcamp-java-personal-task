package calculator.Level_2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    // final: 변하지 않는 상수, static: 클래스 레벨에서 공유됨
    protected static final double PI = 3.141592;

    // 결과 저장용 필드
    protected List<Double> results;
    protected List<Double> circleAreas;

    // 생성자
    public Calculator() {
        results = new ArrayList<>();
        circleAreas = new ArrayList<>();
    }

    // Getter/Setter for results
    public List<Double> getResults() {
        return results;
    }

    public void setResults(List<Double> results) {
        this.results = results;
    }

    public void removeResult() {
        if (!results.isEmpty()) results.remove(0);
    }

    public void inquiryResults() {
        if (results.isEmpty()) {
            System.out.println("저장된 연산 결과가 없습니다.");
        } else {
            for (double r : results) {
                System.out.println(r);
            }
        }
    }

    // Getter/Setter for circleAreas
    public List<Double> getCircleAreas() {
        return circleAreas;
    }

    public void setCircleAreas(List<Double> circleAreas) {
        this.circleAreas = circleAreas;
    }

    public void inquiryCircleAreas() {
        if (circleAreas.isEmpty()) {
            System.out.println("저장된 원의 넓이 결과가 없습니다.");
        } else {
            for (double area : circleAreas) {
                System.out.println(area);
            }
        }
    }
}
