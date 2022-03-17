package hello.java8.functionalinterface;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReference {

    public static void main(String[] args) {

        // 1. 스태틱 메서드 레퍼런스
        UnaryOperator<String> sayHi = Greeting::hi;
        sayHi.apply("keesun");

        // 2. 인스턴스 메서드 레퍼런스
        Greeting greeting = new Greeting();
        UnaryOperator<String> sayHello = greeting::hello;
        sayHello.apply("keesun");

        // 3. 생성자 레퍼런스
        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting greeting2 = newGreeting.get();

        // 4. 생성자 레퍼런스(2)
        Function<String, Greeting> newGreeting2 = Greeting::new;
        Greeting keesun = newGreeting2.apply("keesun");
        System.out.println(keesun.getName());

        // 5. 임의 객체의 메서드 레퍼런스
        String[] names = {"keesun", "whiteship", "toby"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
