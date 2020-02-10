package com.twu.biblioteca.itemdirectory;

import com.twu.biblioteca.user.User;

public interface ItemDirectory {
    void printAllItems();

    void checkOut(User user);

    void returnBack(User user);
}
