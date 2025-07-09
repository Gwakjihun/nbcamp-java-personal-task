package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt(); // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt(); // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.

        System.out.print("사칙연산의 기호를 입력하세요: "); // +, -, *, /
        // String operator = sc.next();
        // -> 잘못된 코드는 아니지만 받는 값이 문자열이 아닌 문자 하나이기 때문에 char를 쓰는게 좀 더 적합하다.
        /* char(idx) : charAt 메서드는 매개변수로 char 타입으로 반환 하고자하는 문자열의 위치(index)를 받는다 */
        char operation = sc.next().charAt(0);

        System.out.println("operation = " + operation);

    }
}
