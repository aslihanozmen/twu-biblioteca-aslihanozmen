package com.twu.biblioteca.menuselections;

import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserAdministration;

public class InfoSelection extends MenuItemBasis implements MenuItem {

    private UserAdministration userAdministration;

    public InfoSelection(int id, String selectionDesc, UserAdministration userAdministration) {
        super(id, selectionDesc);
        this.userAdministration = userAdministration;
    }


    @Override
    public void execute() {
        User user = userAdministration.getUserIfAuthorized();
        if (user != null) {
            user.printInfo();
        }
    }
}
