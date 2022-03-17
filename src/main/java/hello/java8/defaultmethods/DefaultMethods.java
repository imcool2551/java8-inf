package hello.java8.defaultmethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class DefaultMethods {

    public static void main(String[] args) {

        // 0. prepare data
        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");

        // 1. forEach
        names.forEach(System.out::println);

        // 2. spliterator
        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println)) ;
        System.out.println("=============");
        while (spliterator1.tryAdvance(System.out::println)) ;

        // 3. stream
        names.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .collect(Collectors.toList());

        // 4. removeIf
        names.removeIf(s -> s.startsWith("k"));
        names.forEach(System.out::println);


    }
}
