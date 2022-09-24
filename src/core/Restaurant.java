package core;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;

    public List<Branch> getBranches() {
        return branches;
    }

    private List<Branch> branches;
    public static Restaurant instance = null;

    public Restaurant(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }


    public void addItem(String branchName, int menu, String section, String itemName, int price) {
        Branch branch = findOrCreateBranch(branchName);
        branch.addItem(menu, section, itemName, price);
    }

    public void addTable(String branchName, int tableId) {
        Branch branch = findOrCreateBranch(branchName);
        branch.addTable(tableId);
    }

    public Branch findOrCreateBranch(String branchName) {
        for (Branch branch: branches) {
            if (branch.getBranchName().equals(branchName)) {
                return branch;
            }
        }
        Branch newBranch = new Branch(branchName);
        branches.add(newBranch);
        return newBranch;
    }


    public Menu getMenu(String branchName, int menu) {
        for (Branch branch: branches) {
            if (branch.getBranchName().equals(branchName)) {
                return branch.getMenu(menu);
            }
        }
        return null;
    }

    public List<Table> getFreeTables(String branchName) {
        for (Branch branch: branches) {
            if (branch.getBranchName().equals(branchName)) {
                return branch.getFreeTables();
            }
        }
        return null;
    }

    public static Restaurant getInstance() {
        if (instance == null) {
            synchronized (Restaurant.class) {
                if (instance == null) {
                    instance = new Restaurant("Pizza hut");
                }
            }
        }
        return instance;
    }
}
