package jdk8.apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by zj on 2020-05-20
 */
public class AppleDemo {
    public static void main(String[] args) {
        List<Apple> inventory =  new ArrayList<>();
        inventory.add(new Apple("red",150));
        inventory.add(new Apple("green",80));
        inventory.add(new Apple("blue",60));
        inventory.add(new Apple("black",120));
        Stream<Apple> appleStream = inventory.stream().filter((Apple a) -> a.getWeight() < 90);

        appleStream.forEach(apple -> {
            System.out.println(apple.getWeight());
        });

        List<Apple> color = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));

        List<Apple> weight = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> list = new ArrayList<>();
        for (Apple apple : inventory) {
            if(p.test(apple)){
                list.add(apple);
            }
        }
        return list;
    }


}
