import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Integer> results = new ArrayList<>();

    public int calculate(int num1, int num2, char operator) {
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
            results.add(result);
        }

        return result;
    }

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }

    public void remove() {
        if(!results.isEmpty()){
            System.out.println("가장 먼저 저장된 결과 : " + results.get(0) + "를 삭제하였습니다");
            results.remove(0);
        } else {
            System.out.println("저장된 결과가 없습니다");
        }
    }
}

