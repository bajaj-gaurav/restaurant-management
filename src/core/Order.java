package core;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private  Restaurant restaurant;
    private  Branch branchName;
    private List<Item> meal;
    private Table table;

    public Table getTable() {
        return table;
    }

    public Order(Restaurant restaurant, Branch branchName, Table table) {
        meal = new ArrayList<>();
        this.restaurant = restaurant;
        this.branchName = branchName;
        this.table = table;
        table.setFree(false);
    }

//    public void addItemstoMeal(String itemName) {
//        meal.add(findItem(itemName));
//    }

//    public Item findItem(String itemName) {
//        for (Branch branch: restaurant.getBranches()) {
//            for (Menu menu: branch.getMenus()) {
//                for (Section section1: menu.getSections()){
//                    for (Item item: section1.getItems()) {
//                        if (item.itemName.equals(itemName)){
//                            return item;
//                        }
//                    }
//                }
//            }
//        }
//        return null;
//    }

    public void addItemstoMeal(String itemName) {
        for (Item item : branchName.getItems()) {
            if (item.getItemName().equals(itemName)) {
                meal.add(item);
            }
        }
    }

    public int payBill() {
        int total = 0;
        for (Item item: meal) {
            total += item.getPrice();
        }

        this.table.isFree = true;
        return total;
    }
}
