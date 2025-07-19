package calculator.Level_2;

public class CircleCalculator extends Calculator {

    public double calculateCircleArea(double radius) {
        if (radius < 0) throw new IllegalArgumentException("반지름은 0 이상이어야 합니다.");

        double area = PI * radius * radius;
        circleAreas.add(area);
        return area;
    }
}
