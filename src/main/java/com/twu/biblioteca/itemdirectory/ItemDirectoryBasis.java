package com.twu.biblioteca.itemdirectory;

import com.twu.biblioteca.items.Item;
import com.twu.biblioteca.user.User;
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

    protected String checkoutItem(Item i, User user) {
        Optional<Item> checkedOutItem = getItem(i);
        return (checkedOutItem.isPresent()) ? checkedOutItem.get().checkOut(user) : ITEM_NOT_EXIST;
    }

    protected String returnItemBack(Item i, User user) {
        Optional<Item> returnedItem = getItem(i);
        return (returnedItem.isPresent()) ? returnedItem.get().returnBackToLibrary(user) : ITEM_NOT_EXIST;
    }

    private Optional<Item> getItem(Item i) {
        return allItems.stream()
                .filter(item -> item.isEqualTo(i))
                .findFirst();
    }

    protected void printMessage(String message) {
        if (message != null) {
            System.out.println(message);
        }
    }
}
