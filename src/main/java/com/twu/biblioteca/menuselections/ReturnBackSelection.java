package com.twu.biblioteca.menuselections;

import com.twu.biblioteca.itemdirectory.ItemDirectory;

public class ReturnBackSelection extends MenuItemBasis implements MenuItem {

    private ItemDirectory itemDirectory;

    public ReturnBackSelection(int id, String selectionDesc, ItemDirectory itemDirectory) {
        super(id, selectionDesc);
        this.itemDirectory = itemDirectory;
    }

    @Override
    public void execute() {
        itemDirectory.returnBack();
    }
}
