package lab_army;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Mercenary> mercenaries = new ArrayList<>();

        mercenaries.add(new Mercenary("Artem", 33, SpecializationEnum.COMANDOR, 1000));
        mercenaries.add(new Mercenary("Kate", 30, SpecializationEnum.SNAIPER, 324));
        mercenaries.add(new Mercenary("Denis", 12, SpecializationEnum.CANONEER, 12345));
        mercenaries.add(new Mercenary("Egor", 10, SpecializationEnum.CANONEER, 6574));
        mercenaries.add(new Mercenary("Olga", 59, SpecializationEnum.CANONEER, 778798));
        mercenaries.add(new Mercenary("Ilya", 1, SpecializationEnum.DRIVER, 10));


        System.out.println("\nОтсортированные наемники, за исключением командира, с уменьшенной на тысячу зарплатой.\n");

        List<Mercenary> sortedList = mercenaries
                .stream()
                .filter(m -> !m.getSpecialization().equals(SpecializationEnum.COMANDOR))
                .map(m -> new Mercenary(m.getName(),
                        m.getAge(),
                        m.getSpecialization(),
                        m.getSalary() - 1000))
                .sorted(Comparator.comparing(Mercenary::getName))
                .collect(Collectors.toList());

        int countOfList = sortedList.size();
        int count = 0;
        while (count != countOfList) {
            System.out.println(sortedList.get(count));
            count++;
        }


        System.out.println("\nСписок наемников-персон \n");


        Map<String, Person> listOfPersons = mercenaries.stream()
                .collect(Collectors.toMap(Mercenary::getName, mercenary -> new Person(mercenary.getName(),
                        (mercenary.getAge()))));
        listOfPersons.forEach((name, person) -> System.out.println(person.getFirstName()));

        System.out.println("\nГруппировка наемников по величине зарплат\n");

        Map<String, List<Mercenary>> salaryGroups = mercenaries.stream()
                .collect(Collectors.groupingBy(mercenary -> {
                    double salary = mercenary.getSalary();
                    if (salary <= 1000) {
                        return "от 1 до 1000";
                    } else if (salary <= 10000) {
                        return "от 1000 до 10000";
                    } else if (salary > 17000) {
                        return "больше 17000";
                    } else {
                        return "Без Группы";
                    }
                }));

        salaryGroups.forEach((range, mercenaryList) -> {
            System.out.print("Зарплата " + range + ":");
            mercenaryList.forEach(System.out::println);
        });
    }
}