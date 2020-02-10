package com.twu.biblioteca.itemdirectory;

import com.twu.biblioteca.items.Item;

import java.util.List;

public class MovieDirectory extends ItemDirectoryBasis implements ItemDirectory {

    public MovieDirectory(List<Item> allItems) {
        super(allItems);
    }


    @Override
    public void checkOut() {
        // will be implemented later
    }

    @Override
    public void returnBack() {
        // will be implemented later
    }
}
