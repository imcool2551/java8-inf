package hello.java8.functionalinterface;

import java.util.function.*;

public class FunctionalInterface {

    public static void main(String[] args) {
        // 1. Function
        Function<Integer, Integer> plus10 = i -> i + 10;
        Function<Integer, Integer> multiply2 = i -> i * 2;

        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2);
        System.out.println(multiply2AndPlus10.apply(2));
        System.out.println(plus10AndMultiply2.apply(2));

        // 2. Consumer
        Consumer<Integer> printInteger = System.out::println;
        printInteger.accept(2);

        // 3. Supplier
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        // 4. Predicate
        Predicate<String> startsWithA = (s) -> s.startsWith("A");
        Predicate<Integer> isOdd = (n) -> n % 2 == 1;
        System.out.println(startsWithA.test("ABCD"));
        System.out.println(isOdd.test(5));

        // 5. UnaryOperator
        UnaryOperator<Integer> plus1 = i -> i + 1;
    }
}
