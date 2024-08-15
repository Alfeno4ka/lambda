import java.util.function.*;

public class Calculator {
    public static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;

    BinaryOperator<Integer> divide = (x, y) -> {
        if(this.isZero.test(y)){
            //throw new RuntimeException("Нельзя делить на 0");
            throw new ArithmeticException("Нельзя дельть на 0");
        }
        return x / y;
        };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;
    Predicate<Integer> isZero = x -> x == 0;

    Consumer<Integer> println = System.out::println;
}
