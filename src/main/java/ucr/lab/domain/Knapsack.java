package ucr.lab.domain;

import ucr.lab.utility.util;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Knapsack {
    private double maxWeight;
    private double actualWeight;
    private List<Item> kpItems;

    //Asumiendo que el stock de los items siempre es 1
    public List<Item> fillBackpack(Item[] items){
        util.bubbleSort(items, Comparator.comparingDouble(Item::getValueWeightRatio));
        //System.out.println(java.util.Arrays.toString(items));
        for (Item item : items) {
            if (actualWeight + item.getWeight() <= maxWeight){
                kpItems.add(item);
                actualWeight += item.getWeight();
            }
        }
        return kpItems;
    }

    //Permitiendo valores mayores a 1 en stock
    public List<Item> fillBackpack(List<Item> items){
        util.bubbleSort(items, Comparator.comparingDouble(Item::getValueWeightRatio));
        int count; int iStock; double iWeight;
        for (Item item : items) {
            iStock = item.getStock(); iWeight = item.getWeight(); count=0;
            while (iStock > 0 && actualWeight + iWeight <= maxWeight) {
                iStock--;
                actualWeight += iWeight;
                count++;
            }
            if (count > 0)
                kpItems.add(new Item(item.getName(), item.getValue(), iWeight, count));
        }
        return kpItems;
    }

    public Knapsack(double maxWeight) {
        this.maxWeight = maxWeight;
        this.actualWeight = 0;
        kpItems = new ArrayList<Item>();
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(double actualWeight) {
        this.actualWeight = actualWeight;
    }

    public List<Item> getKpItems() {
        return kpItems;
    }

    public void setKpItems(List<Item> kpItems) {
        this.kpItems = kpItems;
    }

    @Override
    public String toString() {
        String result = "KNAPSACK PROBLEM"
                + "\n______________________________________________________________"
                + "\nMax Weight:" + maxWeight
                + "\nItem List Added:"
                + "\n\t\t\t Name\t\t\t\tValue \t\t Weight\t\t\tStock";
        int i = 1; double totalWeight = 0; double totalValue = 0;
        for (Item item : kpItems) {
            if(item==null)
                break;
            totalWeight += (item.getWeight()*item.getStock());
            totalValue += (item.getValue()*item.getStock());
            result += "\n(" + (i++) + ")" + item;
        }
        result += "\n______________________________________________________________"
                + "\nTOTALS:\t\t\t\t\t\t\t$" + util.format(totalValue)
                + "\t\t\t" + util.format(totalWeight);

        return result;
    }
}
