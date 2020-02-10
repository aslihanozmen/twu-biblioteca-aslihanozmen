package com.twu.biblioteca.factory;

import com.twu.biblioteca.Menu;
import com.twu.biblioteca.menuselections.MenuItem;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static java.util.OptionalDouble.empty;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class MenuFactoryTest {

    private Menu menu;

    @Before
    public void beforeEach() {
        menu = MenuFactory.buildMenuList();
    }

    @Test
    public void shouldBuildMenuList() {
        assertThat(menu.getMenuItemList(), CoreMatchers.is(not(empty())));
    }

    @Test
    public void shouldMenuListHasReturnBackSelection() {
        assertThat(getMenuItem("Return a book"), CoreMatchers.is(not(empty())));
    }


    @Test
    public void shouldMenuListHasCheckOutSelectionOfBook() {
        assertThat(getMenuItem("Check out a book"), CoreMatchers.is(not(empty())));
    }

    @Test
    public void shouldMenuListHasCheckOutSelectionOfMovie() {
        assertThat(getMenuItem("Check out a movie"), CoreMatchers.is(not(empty())));
    }

    @Test
    public void shouldMenuListHasPrintSelectionForBooks() {
        assertThat(getMenuItem("Show All Books"), CoreMatchers.is(not(empty())));
    }

    @Test
    public void shouldMenuListHasPrintSelectionForMovies() {
        assertThat(getMenuItem("Show All Movies"), CoreMatchers.is(not(empty())));
    }

    @Test
    public void shouldMenuListHasQuitSelection() {
        assertThat(getMenuItem("Quit Application"), CoreMatchers.is(not(empty())));
    }

    private Optional<MenuItem> getMenuItem(String s) {
        return menu.getMenuItemList().stream()
                .filter(item -> item.getDesc().equals(s))
                .findFirst();
    }
}