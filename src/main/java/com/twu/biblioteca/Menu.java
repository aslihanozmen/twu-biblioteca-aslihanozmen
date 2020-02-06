package com.twu.biblioteca;

import com.twu.biblioteca.commandline.ScannerWrapper;
import com.twu.biblioteca.menuselections.MenuItem;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    private static final String INVALID_OPTION_MESSAGE = "Please select a valid option!";
    private static final String NUMBER_ERROR_OPTION_MESSAGE = "Option should be number!";
    private static final String ENTER_OPTION_MESSAGE = "Enter choice: \n";
    private List<MenuItem> menuItemList;

    public Menu(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void showOptions(PrintStream printStream) {
        menuItemList.forEach(menuItem -> printStream.println(menuItem.getId() + "-" + menuItem.getDesc()));
    }

    public void runMenuItem() {
        String choice = ScannerWrapper.askUserForInput(ENTER_OPTION_MESSAGE);
        int chosen = isValidUserInput(choice);
        if (chosen != -1) {
            menuItemList.forEach(menuItem -> {
                if (chosen == menuItem.getId()) {
                    menuItem.execute();
                }
            });
        }
    }

    private int isValidUserInput(String input) {
        try {
            int inputInt = Integer.parseInt(input);
            if (isValidOption(inputInt)) return inputInt;
        } catch (NumberFormatException e) {
            printErrorMessage(NUMBER_ERROR_OPTION_MESSAGE);
        }
        return -1;
    }

    private boolean isValidOption(int inputInt) {
        if (populateOptionIds().contains(inputInt)) {
            return true;
        } else {
            printErrorMessage(INVALID_OPTION_MESSAGE);
        }
        return false;
    }

    private void printErrorMessage(String optionMessage) {
        System.err.println(optionMessage);
    }

    private List<Integer> populateOptionIds() {
        List<Integer> selectionIds = new ArrayList<>();
        menuItemList.forEach(menuItem -> selectionIds.add(menuItem.getId()));
        return selectionIds;
    }
}
