package com.twu.biblioteca;

import com.twu.biblioteca.commandline.Message;
import com.twu.biblioteca.factory.MenuFactory;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp.start();
    }

    private static void start() {

        Message.printMenu(System.out);
        Menu menu = MenuFactory.buildMenuList();
        menu.showOptions(System.out);
        menu.runMenuItem();
        }

    }
