package com.twu.biblioteca.itemdirectory;

import com.twu.biblioteca.items.Item;

import java.util.List;

public class BookDirectory extends ItemDirectoryBasis implements ItemDirectory {

    public BookDirectory(List<Item> allItems) {
        super(allItems);
    }
}
