import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Pharmacy implements Iterator<Component>, Comparable<Pharmacy> {
    private int index;
    private final List<Component> components;
    public Pharmacy() {
        this.index = 0;
        this.components = new ArrayList<>();
    }

    public void addComponents(Component ... components){
        if (components.length == 0) System.out.println("Вы ничего не добавили!");
        else Collections.addAll(this.components, components);

    }

    @Override
    public boolean hasNext() {
        return index < components.size();
    }

    @Override
    public Component next() {
        return components.get(index++);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pharmacy pharmacy = (Pharmacy) o;

        if (index != pharmacy.index) return false;
        return components.equals(pharmacy.components);
    }

    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + components.hashCode();
        return result;
    }

    @Override
    public int compareTo(@NotNull Pharmacy o) {
        if(this.getSumPower() > o.getSumPower()) return 1;
        if(this.getSumPower() < o.getSumPower()) return -1;
        return 0;
    }

    public int getSumPower(){
        int result = 0;
        for (Component c : this.components){
            result = result + c.getPower();
        }
        return result;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "index=" + index +
                ", components=" + components +
                '}';
    }
}
