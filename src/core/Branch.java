package core;

import java.util.ArrayList;
import java.util.List;

public class Branch {

    private String branchName;
    private List<Menu> menus = new ArrayList<>();
    // this is to make order faster
    private List<Item> items = new ArrayList<>();
    private List<Table> tables = new ArrayList<>();

    public Branch(String branchName) {
        this.branchName = branchName;
    }


    public List<Item> getItems() {
        return items;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public String getBranchName() {
        return branchName;
    }

    public void addItem(int menuId, String sectionName, String itemName, int price) {
        Menu menu = findOrCreateMenu(branchName, menuId, sectionName, itemName, price);
        menu.addItem(branchName, menuId, sectionName, itemName, price);

        // this is to make sure when order item we don't have to traverse through menu and section hierarchy
        items.add(new Item(branchName, menuId, sectionName, itemName, price));
    }

    public Menu findOrCreateMenu(String branchName, int menuId, String sectionName, String itemName, int price) {
        for (Menu menu: menus) {
            if (menu.getId() == menuId) {
                return menu;
            }
        }
        Menu newMenu = new Menu(branchName, menuId, sectionName, itemName, price);
        menus.add(newMenu);
        return newMenu;
    }

    public Menu getMenu(int menuId) {
        for (Menu menu: menus) {
            if (menu.getId() == menuId) {
                return menu;
            }
        }
        return null;
    }

    public void addTable(int tableId) {
        tables.add(new Table(tableId, true));
    }

    public List<Table> getFreeTables() {
        List<Table> outputList = new ArrayList<>();
        for (Table table: tables) {
            if (table.isFree) {
                outputList.add(table);
            }
        }
        return outputList;
    }
}
