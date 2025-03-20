package ucr.lab.domain;

import org.junit.jupiter.api.Test;
import ucr.lab.utility.util;

import java.util.ArrayList;
import java.util.List;

class KnapsackTest {
    Knapsack kp1;
    Knapsack kp2;
    Item[] listItems1;
    List<Item> listItems2;

    public KnapsackTest() {
        this.kp1 = new Knapsack(14.5);
        this.kp2 = new Knapsack(10);

        this.listItems1 = new Item[]{
                new Item("Smart TV 65 pulg 4k", 1000, 20, 1),
                new Item("PS5", 600, 2, 1),
                new Item("Libro Java", 20, 1, 1),
                new Item("Samsung Galaxy", 700, 0.5, 1),
                new Item("Huawei", 400, 0.5, 1),
                new Item("Libro C++", 25, 0.5, 1),
                new Item("Xbox One", 500, 2.2, 1),
                new Item("Drone", 500, 3, 1),
                new Item("Proyector", 200, 3, 1),
                new Item("LapTop", 800, 3, 1),
                new Item("Impresora 3D", 800, 4, 1),
                new Item("iPhone", 800, 0.5, 1)
        };

        this.listItems2 = new ArrayList<Item>();
        listItems2.add(new Item("Washing Machine", 800, 60, 4));
        listItems2.add(new Item("Hair Dryer", 50, 1, 9));
        listItems2.add(new Item("Mini Refrigerator", 400, 20, 2));
        listItems2.add(new Item("Toaster", 60, 2, 5));
        listItems2.add(new Item("Microwave", 150, 12, 8));
        listItems2.add(new Item("Blender", 70, 3, 10));
        listItems2.add(new Item("Electric Kettle", 40, 2, 20));
        listItems2.add(new Item("Coffee Maker", 100, 4, 8));
    }

    @Test
    void test1() {
        System.out.println(show(listItems1));
        kp1.fillBackpack(listItems1);
        System.out.println("\n" + kp1.toString());
    }

    @Test
    void test2() {
        System.out.println(show(listItems2));
        kp2.fillBackpack(listItems2);
        System.out.println("\n" + kp2.toString());

        System.out.println("\n" + util.randomDouble(10,15.1));
        System.out.println("\n" + util.randomDouble(10,15.1));
        System.out.println("\n" + util.randomDouble(10,15.1));
    }

    private String show (List<Item> items) {
        String result = "Item List\n";
        result += "\t\t\tName\t\t\tValue\t\t\tWeight\t\t\tStock";
        for (Item item : items) {
            result += "\n" + item.toString();
        }
        return result;
    }

    private String show (Item[] items) {
        String result = "\t\t\t\t\t\tItem List\n";
        result += "\t\t\tName\t\t\tValue\t\t\tWeight\t\t\tStock";
        for (Item item : items) {
            result += "\n" + item.toString();
        }
        return result;
    }
}