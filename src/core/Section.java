package core;

import java.util.ArrayList;


public class Section {

    private ArrayList<Item> items = new ArrayList<>();

    String branchName;
    String sectionName;
    int menu;
    String itemName;
    int price;

    public Section(String branchName, int menu, String sectionName, String itemName, int price) {
        this.branchName = branchName;
        this.sectionName = sectionName;
        this.menu = menu;
        this.itemName =  itemName;
        this.price =  price;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void addItem(String branchName, int menu, String sectionName, String itemName, int price) {
        findOrCreateItem(branchName, menu, sectionName, itemName, price);
    }

    public Item findOrCreateItem(String branchName, int menu, String sectionName, String itemName, int price) {
        for (Item item: items) {
            if(item.getItemName().equals(itemName)) {
                return item;
            }
        }
        Item newItem = new Item(branchName, menu, sectionName, itemName, price);
        items.add(newItem);
        return newItem;
    }


}
