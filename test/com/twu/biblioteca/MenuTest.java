package com.twu.biblioteca;

import com.twu.biblioteca.menuselections.MenuItem;
import com.twu.biblioteca.menuselections.PrintSelection;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.OptionalDouble.empty;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class MenuTest {

    private Menu menu;
    private MenuItem menuItem;

    private void setUp(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Before
    public void BeforeEach() {

        menuItem = mock(PrintSelection.class);
        when(menuItem.getDesc()).thenReturn("TestDesc");
        when(menuItem.getId()).thenReturn(1);

        List<MenuItem> menuItemList = new ArrayList<>();
        menuItemList.add(menuItem);

        menu = new Menu(menuItemList);
    }

    @Test
    public void shouldShowOptions() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        menu.showOptions(System.out);
        Assert.assertThat(outputContent.toString(), containsString("TestDesc"));
    }

    @Test
    public void shouldRunMenuItem() {
        setUp(String.valueOf(menuItem.getId()));
        menu.runMenuItem();
        verify(menuItem, times(1)).execute();
    }

    @Test
    public void shouldGetMenuItemList() {
        assertThat(menu.getMenuItemList(), CoreMatchers.is(not(empty())));
    }

    @Test
    public void shouldGetErrMessageIfOptionIsNotInteger() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outputContent));
        String input = "test";
        setUp(input);
        menu.runMenuItem();
        Assert.assertThat(outputContent.toString(), containsString("Option should be number!"));
    }

    @Test
    public void shouldGetErrMessageIfOptionIsNotValid() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outputContent));
        String input = "100";
        setUp(input);
        menu.runMenuItem();
        Assert.assertThat(outputContent.toString(), containsString("Please select a valid option!"));
    }
}