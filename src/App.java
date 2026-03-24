import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArithmeticCalculator calculator = new ArithmeticCalculator();

        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");

                int num1 = sc.nextInt();

                System.out.print("두 번째 숫자를 입력하세요: ");

                int num2 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");

                char operator = sc.next().charAt(0);

                int result = calculator.calculate(num1, num2, operator);

                if (calculator.getResults().size() > 0) { // 결과가 저장되었을 때만 출력
                    System.out.println("결과 : " + result);
                    System.out.println("저장된 결과 목록: " + calculator.getResults());
                }


            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                sc.nextLine();
                continue;
            }

            while (true) {
                System.out.print("더 계산하시겠습니까? (계속: y/Y, 첫 번째 결과 삭제 : remove , 종료: exit): ");
                String answer = sc.next();

                if (answer.equalsIgnoreCase("y")) {
                    break;
                }else if(answer.equals("remove")){
                    calculator.remove();
                    System.out.println("현재 결과 목록 : " + calculator.getResults());
                    break;
                } else if (answer.equalsIgnoreCase("exit")) {
                    calculator.setResults(new ArrayList<>());
                    System.out.println("결과 목록 초기화 : " + calculator.getResults());
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
