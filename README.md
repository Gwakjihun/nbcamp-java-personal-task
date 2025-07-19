# 🧮 진화하는 계산기 - Java OOP Calculator

## 📌 프로젝트 소개

이 프로젝트는 **객체 지향 프로그래밍(OOP)** 원칙에 따라 점진적으로 기능이 확장되는 **콘솔 기반 계산기 프로그램**입니다.  
사칙연산과 원의 넓이 계산, 연산 결과의 저장/조회/삭제 기능을 단계별로 구현하며,  
**캡슐화**, **상속**, **단일 책임 원칙(SRP)**, **확장 개방 원칙(OCP)** 등을 학습하고 적용하는 데 목적이 있습니다.

---

## 🛠️ 개발 환경

- Java 17
- IDE: IntelliJ IDEA 
- 입력: `Scanner`를 활용한 콘솔 입력
- 구조: Gradual OOP 기반 구조 설계

---

## 📁 프로젝트 구조
calculator/

├── App.java // 실행 및 사용자 입력 처리

├── Calculator.java // 공통 기능 (결과 저장, 조회, 삭제 등)

├── ArithmeticCalculator.java // 사칙연산 전용 클래스 (Calculator 상속)

├── CircleCalculator.java // 원의 넓이 계산 전용 클래스 (Calculator 상속)

├── operator/

│ ├── AddOperator.java // 덧셈 기능

│ ├── SubtractOperator.java // 뺄셈 기능

│ ├── MultiplyOperator.java // 곱셈 기능

│ └── DivideOperator.java // 나눗셈 기능


---

## ✅ 주요 기능 (단계별 구현)

### ✅ Level 1

- [x] 사용자로부터 두 정수와 연산자 입력
- [x] 사칙연산 결과 출력
- [x] 나눗셈 시 0으로 나누는 예외 처리

### ✅ Level 2

- [x] 연산 결과를 저장하는 컬렉션(List) 구현
- [x] `remove` 명령어로 가장 오래된 결과 삭제
- [x] `inquiry` 명령어로 결과 전체 조회
- [x] `exit` 명령어로 프로그램 종료
- [x] 캡슐화를 통한 필드 은닉 및 Getter/Setter 구현
- [x] `calculateCircleArea()` 메서드 구현 (원의 넓이 계산)
- [x] `static final` 키워드를 활용한 `PI` 상수 선언
- [x] 원의 넓이 결과 저장 기능 및 조회 메서드 구현

### ✅ Level 2-8: 클래스 구조 리팩토링

- [x] `ArithmeticCalculator`, `CircleCalculator` 클래스를 `Calculator`로부터 상속
- [x] 연산 결과 저장 필드 및 조회 기능 공유

### ✅ Level 2-9: 책임 분리 적용 (SRP)

- [x] `AddOperator`, `SubtractOperator`, `MultiplyOperator`, `DivideOperator` 클래스 구현
- [x] `ArithmeticCalculator`에서 각 연산 클래스를 활용하여 연산 수행

---

## 📦 클래스 책임 요약

| 클래스명                   | 역할 및 설명 |
|----------------------------|--------------|
| `Calculator`               | 공통 기능 (연산 결과 저장, 삭제, 조회 등) 담당 |
| `ArithmeticCalculator`     | 사칙연산을 수행하는 계산기 (상속 및 위임 구조) |
| `CircleCalculator`         | 원의 넓이를 계산하는 계산기 (PI 상수 사용) |
| `AddOperator`              | 덧셈 기능 클래스 |
| `SubtractOperator`         | 뺄셈 기능 클래스 |
| `MultiplyOperator`         | 곱셈 기능 클래스 |
| `DivideOperator`           | 나눗셈 기능 클래스 |
| `App`                      | 사용자 입력을 통해 기능을 제어하는 메인 클래스 |

---

## 🖥️ 실행 예시

계산기를 선택하세요 (1: 사칙연산, 2: 원의 넓이 계산): 1

첫 번째 숫자를 입력하세요: 12

두 번째 숫자를 입력하세요: 3

사칙연산 기호를 입력하세요 (+, -, *, /): /

결과: 4.0

더 계산하시겠습니까? (exit 입력 시 종료): inquiry

저장된 연산 결과 목록:
4.0

더 계산하시겠습니까? (exit 입력 시 종료): remove

삭제된 연산 결과: 4.0

더 계산하시겠습니까? (exit 입력 시 종료): exit


---

## 🔍 객체 지향 설계 적용 원칙

- **캡슐화(Encapsulation)**  
  연산 결과 컬렉션 필드는 `private` 또는 `protected`로 선언하고 Getter/Setter로 접근합니다.

- **상속(Inheritance)**  
  `Calculator` 클래스를 기반으로 `ArithmeticCalculator`와 `CircleCalculator`가 공통 로직을 재사용합니다.

- **단일 책임 원칙(SRP)**  
  사칙연산을 각각의 클래스로 분리하여 책임을 분리하였고, 각 클래스는 하나의 연산만 담당합니다.

- **확장 개방 원칙(OCP)**  
  연산자 클래스를 별도로 구현함으로써, 새로운 기능(예: 나머지 연산) 추가 시 기존 코드를 변경하지 않고 확장할 수 있도록 설계했습니다.

---

## 🧠 회고 (Review)

이번 과제를 통해 단순한 콘솔 프로그램에서도 객체 지향의 설계 원칙을 적용하는 훈련을 할 수 있었습니다.  
처음에는 모든 기능을 하나의 클래스에 구현했지만, 단계가 올라갈수록 각 클래스의 역할이 분리되며 코드가 훨씬 읽기 쉽고 유지보수가 편해졌습니다.

특히 `SRP`, `OCP`와 같은 원칙을 실제 코드 구조에 녹여내는 과정을 경험하면서 다음과 같은 것을 느꼈습니다:

- 단일 클래스가 너무 많은 책임을 가지면 테스트와 확장이 어려워진다.
- 연산 기능을 클래스로 분리하면 확장이 유연해지고 OOP의 강점을 체감할 수 있다.
- 처음부터 완벽한 구조를 설계하는 것은 어렵지만, 점진적으로 개선해가는 방식이 현실적이다.

**가장 인상 깊었던 점은 ‘OCP’를 구현하려다 전체 구조를 리팩토링하게 된 과정**이었고,  
그 과정에서 **다형성과 인터페이스의 필요성**을 자연스럽게 이해할 수 있었습니다.

---
