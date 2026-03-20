import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");

                int num1 = sc.nextInt();

                System.out.print("두 번째 숫자를 입력하세요: ");

                int num2 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");

                char operator = sc.next().charAt(0);

                int result = 0;
                boolean isValid = true;

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
                            System.out.println("나눗셈 연산에서 두번째 정수에 0이 입력될 수 없습니다.");
                            isValid = false;
                        } else {
                            result = num1 / num2;
                        }
                        break;

                    default:
                        System.out.println("잘못된 사칙연산 기호 입니다.");
                        isValid = false;
                }

                if (isValid) {
                    System.out.println("결과: " + result);
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
