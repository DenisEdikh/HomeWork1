package ru.aston;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(20);
        list.add(10);
        list.add(5);
        list.add(40);
        list.add(25);
        list.add(30);
        list.add(30);
        list.add(15);

        Algorithms.quickSort(list, Integer::compareTo);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        CustomArrayList<User> users = new CustomArrayList<>();
        users.add(new User("AAA", 20));
        users.add(new User("CCC", 30));
        users.add(new User("FFF", 50));
        users.add(new User("BBB", 60));
        users.add(new User("DDD", 70));

        Algorithms.quickSort(users);
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }
}