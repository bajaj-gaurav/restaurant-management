package core;

import java.util.List;

public class Customer {

    Restaurant restaurant;

    public Customer(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void getMenu(String branchName, int menuId) {
        Menu menu = this.restaurant.getMenu(branchName, menuId);
        for (Section section: menu.getSections()) {
            for (Item item: section.getItems()) {
                System.out.println(item);
            }
        }
    }

    public List<Table> getFreeTables(String branchName) {
        List<Table> tables = this.restaurant.getFreeTables(branchName);
//        for (Table table : tables) {
//            System.out.println(table);
//        }
        return tables;
    }

    public Order createOrder(String branchName) {
        Branch branch = getBranch(branchName);
        Order order = new Order(this.restaurant, branch, getFreeTables(branchName).get(0));
        return order;
    }

    private Branch getBranch(String branchName) {
        for (Branch branch: restaurant.getBranches()) {
            if (branch.getBranchName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

    public int payBill(Order order) {
        int total = order.payBill();
        return total;
    }


}
