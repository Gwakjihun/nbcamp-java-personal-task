package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // 연산 결과를 무한히 저장할 있는 List 생성
        List<Integer> results = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        // 반복 횟수가 명확할 때 : for, 조건이 true일 때: while
        while (true) {

            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt(); // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            // 음수는 입력 불가
            if (num1 < 0) {
                System.out.println("양의 정수(0 포함)을 입력해주세요.");
                continue;
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt(); // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            // 음수는 입력 불가
            if (num2 < 0) {
                System.out.println("양의 정수(0 포함)을 입력해주세요.");
                continue;
            }

            System.out.print("사칙연산의 기호를 입력하세요: "); // +, -, *, /
            // String operator = sc.next();
            // -> 잘못된 코드는 아니지만 받는 값이 문자열이 아닌 문자 하나이기 때문에 char를 쓰는게 좀 더 적합하다.
            /* char(idx) : charAt 메서드는 매개변수로 char 타입으로 반환 하고자하는 문자열의 위치(index)를 받는다 */
            char operation = sc.next().charAt(0);

            int result = 0; // 연산 결과를 저장할 변수 선언 및 초기화
            boolean isError = false; // 오류 발생 여부 체크 (플래그 변수) → 처음에는 오류가 없다고 가정 (false)

            // 하나의 값에 대해 여러 case를 나누는 구조이기 때문에 if 보다는 switch를 사용함.(비교,논리면 if 사용)
            switch (operation) {
                case '+':
                    result = num1 + num2; // 덧셈
                    break;
                case '-':
                    result = num1 - num2; // 뺄셈
                    break;
                case '*':
                    result = num1 * num2; // 곱셈
                    break;
                case '/':
                    if (num2 == 0) {
                        // 나눗셈에서 분모가 0일 경우 오류 메시지 출력
                        System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                        isError = true;
                    } else {
                        result = num1 / num2; // 나눗셈 수행
                    }
                    break;
                default:
                    // 사칙연산 외의 기호가 입력된 경우
                    System.out.println("잘못된 연산자입니다. (+, -, *, / 중 하나를 입력하세요)");
                    isError = true;
            }

            // 오류가 없을 경우에만 결과 출력 (isError == false)
            if (!isError) {
                System.out.println("결과: " + result);
                // 리스트에 연산 결과 저장
                results.add(result);
            }

            // remove 입력 시 가장 먼저 저장된 연산 결과 삭제
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String removeInput = sc.next();
            if (removeInput.equalsIgnoreCase("remove")) {
                if (!results.isEmpty()) {
                    int removed = results.remove(0); // 가장 오래된 값 삭제
                    System.out.println("삭제된 연산 결과: " + removed);
                } else {
                    System.out.println("삭제할 연산 결과가 없습니다.");
                }
            }

            // inquiry 입력 여부 확인
            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            String inquiryInput = sc.next();

            if (inquiryInput.equalsIgnoreCase("inquiry")) {
                if (!results.isEmpty()) {
                    System.out.println("저장된 연산 결과 목록:");
                    for (int r : results) {
                        System.out.println(r);
                    }
                } else {
                    System.out.println("저장된 연산 결과가 없습니다.");
                }
            }

            // exit 입력 여부 확인
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)");
            String answer = sc.next();
            if (answer.equalsIgnoreCase("exit")) {   // 대소문자 구분없이 적용
                System.out.println("계산기를 종료하겠습니다.");
                break;
            }

            System.out.println(); // 가독성을 위한 공백
        }

        sc.close(); // 자원 반납
    }
}
