package core;

public class Item {

    String branchName;
    String sectionName;
    int menu;
    String itemName;
    int price;

    public Item(String branchName, int menu, String sectionName, String itemName, int price) {
        this.branchName = branchName;
        this.sectionName = sectionName;
        this.menu = menu;
        this.itemName =  itemName;
        this.price =  price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
               "itemName='" + itemName + '\'' +
               ", price=" + price +
               '}';
    }

}
