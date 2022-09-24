package core;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    String branchName;
    String sectionName;
    int id;
    String itemName;
    int price;

    List<Section> sections = new ArrayList<>();

    public Menu(String branchName, int menu, String sectionName, String itemName, int price) {
        this.branchName = branchName;
        this.sectionName = sectionName;
        this.id = menu;
        this.itemName =  itemName;
        this.price =  price;
    }

    public List<Section> getSections() {
        return sections;
    }

    public int getId() {
        return id;
    }

    public void addItem(String branchName, int menu, String sectionName, String itemName, int price) {
        Section section = findOrCreateSection(branchName, menu, sectionName, itemName, price);
        section.addItem(branchName, menu, sectionName, itemName, price);
    }

    public Section findOrCreateSection(String branchName, int menu, String sectionName, String itemName, int price) {
        for (Section section: sections) {
            if (section.getSectionName().equals(sectionName)) {
                return section;
            }
        }
        Section newSection = new Section(branchName, menu, sectionName, itemName, price);
        sections.add(newSection);
        return newSection;
    }


}
