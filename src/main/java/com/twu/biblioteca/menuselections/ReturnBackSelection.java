package com.twu.biblioteca.menuselections;

import com.twu.biblioteca.itemdirectory.ItemDirectory;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserAdministration;

public class ReturnBackSelection extends MenuItemBasis implements MenuItem {

    private ItemDirectory itemDirectory;
    private UserAdministration userAdministration;

    public ReturnBackSelection(int id, String selectionDesc, ItemDirectory itemDirectory, UserAdministration userAdministration) {
        super(id, selectionDesc);
        this.itemDirectory = itemDirectory;
        this.userAdministration = userAdministration;
    }

    @Override
    public void execute() {
        User user = userAdministration.getUserIfAuthorized();
        if (user != null) {
            itemDirectory.returnBack(user);
        }
    }

}
