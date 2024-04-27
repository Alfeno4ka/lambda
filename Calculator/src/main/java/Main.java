public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        //Код далее работать не будет, т.к. происходит деление на ноль (b = 1 - 1 = 0)
        //Способы решения ошибки: перед делением выполнять проверку на 0 в делителе и выкидывать исключение, если он равен 0
        int c = calc.devide.apply(a, b);
        calc.println.accept(c);
    }
}
