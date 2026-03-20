import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Calculator calculator = new Calculator();

        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");

                int num1 = sc.nextInt();

                System.out.print("두 번째 숫자를 입력하세요: ");

                int num2 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");

                char operator = sc.next().charAt(0);

                int result = calculator.calculate(num1, num2, operator);

                if(calculator.results.size() > 0) { // 결과가 저장되었을 때만 출력
                    System.out.println("결과 : " + result);
                    System.out.println("저장된 결과 목록: " + calculator.results);
                }


            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                sc.nextLine();
                continue;
            }

            while (true) {
                System.out.print("더 계산하시겠습니까? (계속: y/Y, 종료: exit): ");
                String answer = sc.next();

                if (answer.equalsIgnoreCase("y")) {
                    break;
                } else if (answer.equalsIgnoreCase("exit")) {
                    System.out.println("계산기를 종료합니다.");
                    sc.close();
                    return;
                } else {
                    System.out.println("잘못된 입력입니다. y/Y 또는 exit만 입력해주세요.");
                }
            }

        }
    }
}
