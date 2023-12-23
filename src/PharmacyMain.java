import java.util.*;

public class PharmacyMain {
    public static void main(String[] args) {

        Component pineceline = new Component("Pineceline", "10mg", 100);
        Component salt = new Component("Salt", "20gr", 10);
        Component sugar = new Component("Sugar", "87gr", 80);

        // 1. Создайте несколько экземпляров Pharmacy(или IterablePharmacy),
        // причем, чтобы среди них было хотя бы два экземпляра
        // с полностью идентичными значениями полей.

        Pharmacy pharmacy1 = new Pharmacy();
        pharmacy1.addComponents(sugar, pineceline);

        Pharmacy pharmacy2 = new Pharmacy();
        pharmacy2.addComponents(sugar, pineceline); // состав повторяет pharmacy1

        Pharmacy pharmacy3 = new Pharmacy();
        pharmacy3.addComponents(salt, pineceline);

        Pharmacy pharmacy4 = new Pharmacy();
        pharmacy4.addComponents(sugar, salt, pineceline);

        // 2. Сделать так, чтобы после выполнения кода ниже, в сете result были только уникальные объекты.
        // Set<Pharmacy> result = new HashSet<>(множество из нескольких лекарств);
        // System.out.println(result.size()); // тут вывод должен быть равен количеству УНИКАЛЬНЫХ экземпляров Pharmacy!

        Set<Pharmacy> result = new HashSet<>();
        result.add(pharmacy1);
        result.add(pharmacy2); // совпадает с pharmacy1
        result.add(pharmacy3);
        result.add(pharmacy4);

        System.out.println(result.size()); // выведет 3, т.е. 1 и 2 равны друг другу

        // 3. Добавить интерфейс Copmparable<Pharmacy> к классу Pharmacy. Переопределить метод compareTo()
        // подсказка: можно добавить, а можно не добавлять в класс поля;

        List<Pharmacy> list = new ArrayList<>();
        list.add(pharmacy2);
        list.add(pharmacy3);
        list.add(pharmacy4);

        System.out.println(pharmacy2.getSumPower()); // 180 sugar, pineceline
        System.out.println(pharmacy3.getSumPower()); // 110 salt, pineceline
        System.out.println(pharmacy4.getSumPower()); // 190 sugar, salt, pineceline

        Collections.sort(list); // сортировка по силе лекарства

        for (Pharmacy p : list){
            System.out.println(p);
            System.out.println(p.getSumPower());
        }

        // Вывод:
        // 110
        // 180
        // 190
    }

}
