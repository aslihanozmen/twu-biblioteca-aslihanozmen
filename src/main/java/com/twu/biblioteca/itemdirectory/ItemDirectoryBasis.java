package com.twu.biblioteca.itemdirectory;

import com.twu.biblioteca.items.Item;
import de.vandermeer.asciitable.AsciiTable;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ItemDirectoryBasis implements ItemDirectory {

    private List<Item> allItems;

    public ItemDirectoryBasis(List<Item> allItems) {
        this.allItems = allItems;
    }

    @Override
    public void printAllItems() {
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        allItems.forEach(item -> {
            if(!item.isCheckedOut()) {
                item.printItem(asciiTable);
            }
        });
        String render = asciiTable.render();
        System.out.println(render);

    }

    protected String checkoutItem(Item i) {
        AtomicReference<String> status = new AtomicReference<>();
        allItems.forEach(item -> {
            if(item.isEqualTo(i)) {
                status.set(item.checkOut());
            }
        });
        return status.get();
    }
}
