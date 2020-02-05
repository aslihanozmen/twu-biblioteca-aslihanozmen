package com.twu.biblioteca;

import com.twu.biblioteca.commandline.ScannerWrapper;
import com.twu.biblioteca.menuselections.MenuItem;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<MenuItem> menuItemList = new ArrayList<>();

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public void showOptions(PrintStream printStream) {
        menuItemList.forEach(menuItem -> printStream.println(menuItem.getId() + "-" + menuItem.getDesc()));
    }

    public void runMenuItem() {
        ScannerWrapper sw = new ScannerWrapper(System.in, System.out);
        int choice = sw.getInput(0, 2);
        menuItemList.forEach(menuItem -> {
            if(choice == menuItem.getId()) {
                menuItem.execute();
            }
        });
    }
}
