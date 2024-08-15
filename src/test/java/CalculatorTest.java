import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {
    Calculator calc = Calculator.instance.get();
    @MethodSource
    @ParameterizedTest
    public void testPlus(int x, int y, int expected){
        //act
        int result = calc.plus.apply(x,y);
        //assert
        Assertions.assertEquals(expected, result);
    }

    public Stream<Arguments> testPlus(){
        return Stream.of(
                Arguments.of(1,1,2),
                Arguments.of(3,0,3),
                Arguments.of(0,0,0),
                Arguments.of(0,3,3),
                Arguments.of(-3,0,-3),
                Arguments.of(-3,-0,-3),
                Arguments.of(3, -0, 3),
                Arguments.of(1, -1, 0)
        );
    }

    @MethodSource
    @ParameterizedTest
    public void testMinus(int x, int y, int expected){
        //act
        int result = calc.minus.apply(x,y);
        //assert
        Assertions.assertEquals(expected, result);
    }

    public Stream<Arguments> testMinus(){
        return Stream.of(
                Arguments.of(1,1,0),
                Arguments.of(3,0,3),
                Arguments.of(0,0,0),
                Arguments.of(0,3,-3),
                Arguments.of(-3,0,-3),
                Arguments.of(-3,-0,-3),
                Arguments.of(3, -0, 3),
                Arguments.of(1, -1, 2)
        );
    }

    @MethodSource
    @ParameterizedTest
    public void testDivide(int x, int y, int expected){
        //act
        int result = calc.divide.apply(x,y);
        //assert
        Assertions.assertEquals(expected, result);
    }

    public Stream<Arguments> testDivide(){
        return Stream.of(
                Arguments.of(2,1,2),
                Arguments.of(5,2,2),
                Arguments.of(1,1,1),
                Arguments.of(0,3,0),
                Arguments.of(1,-1,-1),
                Arguments.of(-1,-1,1),
                Arguments.of(-1,1,-1)
        );
    }

    @Test
    public void testDivideByZero(){
        assertThrows(ArithmeticException.class, () -> calc.divide.apply(10, 0), "Деление на ноль должно вызвать ArithmeticException");
    }
}
