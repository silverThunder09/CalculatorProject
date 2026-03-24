public enum Operator {
    Add ('+'),
    Minus ('-'),
    Multiply ('*'),
    Divide ('/');


    private final char symbol;

    Operator(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static Operator fromSymbol(char symbol) {
        for(Operator op : values()) {
            if(op.getSymbol() == symbol){
                return op;
            }
        }
        return null;
    }
}

