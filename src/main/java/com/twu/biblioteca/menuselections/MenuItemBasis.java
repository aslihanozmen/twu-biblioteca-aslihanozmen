package com.twu.biblioteca.menuselections;

public abstract class MenuItemBasis implements MenuItem {

    //TODO use enum
    private int id;
    private String selectionDesc;

    public MenuItemBasis(int id, String selectionDesc) {
        this.id = id;
        this.selectionDesc = selectionDesc;
    }

    @Override
    public String getDesc() {
        return selectionDesc;
    }

    @Override
    public int getId() {
        return id;
    }
}
