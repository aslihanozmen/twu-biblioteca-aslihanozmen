package com.twu.biblioteca.menuselections;

import com.twu.biblioteca.user.UserAdministration;

public class LogoutSelection extends MenuItemBasis implements MenuItem {

    private UserAdministration userAdministration;

    public LogoutSelection(int id, String selectionDesc, UserAdministration userAdministration) {
        super(id, selectionDesc);
        this.userAdministration = userAdministration;
    }

    @Override
    public void execute() {
        userAdministration.logoutUser();
    }
}