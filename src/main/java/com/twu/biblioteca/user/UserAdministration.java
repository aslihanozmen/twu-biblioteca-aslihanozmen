package com.twu.biblioteca.user;

import com.twu.biblioteca.commandline.ScannerWrapper;

import java.util.List;
import java.util.Optional;

public class UserAdministration {

    private static final String AUTHORIZED_MESSAGE = "You are already authorized and logged in to the system.";
    private static final String LIBRARY_NUMBER_MESSAGE = "Enter your library number: ";
    private static final String PSSWD_MESSAGE = "Enter your password: ";
    private static final String NOT_AUTHORIZED_MESSAGE = "You are not authorized.";
    private static final String SUCCESS_AUTHORIZED_MESSAGE = "You are authorized and successfully logged in.";
    private static final String NO_LOG_IN_MSG = "You are not logged in.";
    private static final String SUCCESS_LOG_OUT_MSG = "You are now logged out.";

    private List<User> listOfUsers;
    private User presentUser;

    public UserAdministration(List<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public User getPresentUser() {
        return presentUser;
    }

    public boolean isUserLoggedIn() {
        return presentUser != null;
    }

    public void authorizeUser() {

        if (isUserLoggedIn()) {
            System.out.println(AUTHORIZED_MESSAGE);
            return;
        }
        presentUser = getUser(ScannerWrapper.askUserForInput(LIBRARY_NUMBER_MESSAGE), ScannerWrapper.askUserForInput(PSSWD_MESSAGE));
        printAuthorizationMessage();
    }

    private void printAuthorizationMessage() {
        if ((!isUserLoggedIn())) {
            System.err.println(NOT_AUTHORIZED_MESSAGE);
        } else {
            System.out.println(SUCCESS_AUTHORIZED_MESSAGE);
        }
    }

    private User getUser(String libNu, String psswd) {

        Optional<User> validUser = listOfUsers.stream()
                .filter(user -> isValidUser(user, libNu, psswd))
                .findFirst();

        return validUser.orElse(null);
    }

    private boolean isValidUser(User user, String libNu, String psswd) {
        return user.getLibNu().equals(libNu) && user.getPassword().equals(psswd);
    }

    public void logoutUser() {
        if (!isUserLoggedIn()) {
            System.out.println(NO_LOG_IN_MSG);
            return;
        }
        presentUser = null;
        System.out.println(SUCCESS_LOG_OUT_MSG);
    }
}
