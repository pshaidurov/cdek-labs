package lab_8_col;

import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> persons = new HashMap<Integer, String>();
        persons.put(148259, "Василий Пупкин Молодец");
        persons.put(123456, "Николай Сергеевич Попов");
        persons.put(789123, "Никита Иванович Крылов");
        System.out.println(persons.get(148259));
        System.out.println();
        System.out.println(persons.keySet());
        System.out.println();
        System.out.println(persons.values());
        System.out.println();
        System.out.println(persons.replace(123456, "Уехал"));
        System.out.println();
        System.out.println(persons.remove(789123));
        System.out.println();
        System.out.println(persons.values());


    }
}