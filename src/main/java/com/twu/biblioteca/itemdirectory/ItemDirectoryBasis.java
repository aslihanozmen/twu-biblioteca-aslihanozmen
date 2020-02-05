package com.twu.biblioteca.itemdirectory;

import com.twu.biblioteca.items.Item;
import de.vandermeer.asciitable.AsciiTable;

import java.util.List;

public class ItemDirectoryBasis implements ItemDirectory {

    private List<Item> allItems;

    public ItemDirectoryBasis(List<Item> allItems) {
        this.allItems = allItems;
    }

    @Override
    public void printAllItems(){
        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        allItems.forEach(item -> item.printItem(asciiTable));
        String render = asciiTable.render();
        System.out.println(render);
    }
}
