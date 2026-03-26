import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number>{

    private List<Double> results = new ArrayList<>();

    public double calculate(T num1,  T num2, char op) {
        double result = 0;
        boolean isValid = true;

        Operator operator = Operator.fromSymbol(op);

        if(operator == null){
            System.out.println("잘못된 연산 기호 입니다.");
            return result;
        }

        switch (operator) {
            case Add:
                result = num1.doubleValue() + num2.doubleValue();
                break;

            case Minus:
                result = num1.doubleValue() - num2.doubleValue();
                break;

            case Multiply:
                result = num1.doubleValue() * num2.doubleValue();
                break;

            case Divide:
                if (num2.doubleValue() == 0) {
                    System.out.println("나눗셈 연산에서 두번째 정수에 0이 입력될 수 없습니다.");
                    isValid = false;
                } else {
                    result = num1.doubleValue() / num2.doubleValue();
                }
                break;
        }


        if (isValid) {
            results.add(result);
        }

        return result;
    }

    public List<Double> getResults() {
        return results;
    }

    public void setResults(List<Double> results) {
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

