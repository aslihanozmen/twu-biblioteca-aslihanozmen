package com.twu.biblioteca.factory;

import com.twu.biblioteca.Menu;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static java.util.OptionalDouble.empty;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class MenuFactoryTest {

    @Test
    public void buildMenuList() {
        Menu menu = MenuFactory.buildMenuList();
        assertThat(menu.getMenuItemList(), CoreMatchers.is(not(empty())));

    }
}