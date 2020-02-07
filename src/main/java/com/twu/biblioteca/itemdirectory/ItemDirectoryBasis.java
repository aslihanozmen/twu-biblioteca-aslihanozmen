package com.twu.biblioteca.itemdirectory;

import com.twu.biblioteca.items.Item;
import de.vandermeer.asciitable.AsciiTable;

import java.util.List;
import java.util.Optional;

public abstract class ItemDirectoryBasis implements ItemDirectory {

    private static final String ITEM_NOT_EXIST = "That item does not exist.";

    private List<Item> allItems;

    public ItemDirectoryBasis(List<Item> allItems) {
        this.allItems = allItems;
    }

    @Override
    public void printAllItems() {
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        allItems.forEach(item -> {
            if (!item.isCheckedOut()) {
                item.printItem(asciiTable);
            }
        });
        String render = asciiTable.render();
        System.out.println(render);

    }

    protected String checkoutItem(Item i) {
        Optional<Item> checkedOutItem = allItems.stream()
                .filter(item -> item.isEqualTo(i))
                .findFirst();
        return (checkedOutItem.isPresent()) ? checkedOutItem.get().checkOut() : ITEM_NOT_EXIST;
    }

    protected void returnItemBack(Item i) {
        allItems.forEach(item -> {
            if (item.isEqualTo(i)) {
                item.returnBackToLibrary();
            }
        });
    }
}
