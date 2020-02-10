package com.twu.biblioteca.menuselections;

import com.twu.biblioteca.itemdirectory.ItemDirectory;
import com.twu.biblioteca.user.UserAdministration;

public class CheckOutSelection extends MenuItemBasis implements MenuItem {

    private ItemDirectory itemDirectory;
    private UserAdministration userAdministration;

    public CheckOutSelection(int id, String selectionDesc, ItemDirectory itemDirectory, UserAdministration userAdministration) {
        super(id, selectionDesc);
        this.itemDirectory = itemDirectory;
        this.userAdministration = userAdministration;
    }

    @Override
    public void execute() {
        //TODO fix it later
        if (!userAdministration.isUserLoggedIn()) {
            userAdministration.authorizeUser();
        }

        if (userAdministration.getPresentUser() != null) {
            itemDirectory.checkOut(userAdministration.getPresentUser());
        }
    }

}
