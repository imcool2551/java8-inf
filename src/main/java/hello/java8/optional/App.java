package hello.java8.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        System.out.println("1. isPresent() + get() --> 번거로움&비추천");
        if (optional.isPresent()) {
            OnlineClass onlineClass = optional.get();
            System.out.println(onlineClass.getTitle());
        }

        System.out.println("2. ifPresent()");
        optional.ifPresent(oc -> {
            System.out.println(oc.getTitle());
        });

        System.out.println("3. orElse() --> 무조건 생성하기 때문에 성능상 문제 가능성");
        OnlineClass onlineClass = optional.orElse(createNewJpaClass());
        System.out.println("onlineClass = " + onlineClass);

        System.out.println("4. orElseGet() --> Supplier 통해 lazy 하게 생성 가능");
        optional.orElseGet(() -> createNewJpaClass());
        optional.orElseGet(App::createNewJpaClass);

        System.out.println("5. orElseThrow()");
        optional.orElseThrow(IllegalStateException::new);

        System.out.println("6. filter()");
        Optional<OnlineClass> filtered =
                optional.filter(oc -> oc.getId() > 10);
        System.out.println(filtered.isEmpty());

        System.out.println("7. map(), flatMap()");
        Optional<Integer> id = optional.map(OnlineClass::getId);
        System.out.println(id.isPresent());

        Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);


    }

    private static OnlineClass createNewJpaClass() {
        System.out.println("creating new class");
        return new OnlineClass(10, "JPA", false);
    }
}
