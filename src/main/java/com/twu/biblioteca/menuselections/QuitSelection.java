package com.twu.biblioteca.menuselections;

public class QuitSelection extends MenuItemBasis implements MenuItem {

    private static final String EXIT_MESSAGE = "You are exiting from the application...";

    public QuitSelection(int id, String selectionDesc) {
        super(id, selectionDesc);
    }

    @Override
    public void execute() {
        System.out.println(EXIT_MESSAGE);
        System.exit(0);
    }
}
