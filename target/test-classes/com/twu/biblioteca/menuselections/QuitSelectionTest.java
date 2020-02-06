package com.twu.biblioteca.menuselections;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitSelectionTest {

    private QuitSelection quitSelection;

    @Rule
    public final ExpectedSystemExit expectedSystemExit = ExpectedSystemExit.none();

    @Before
    public void beforeEach() {
        quitSelection = new QuitSelection(0, "testQuit");
    }

    @Test
    public void shouldExitFromApp() {
        expectedSystemExit.expectSystemExitWithStatus(0);
        quitSelection.execute();

    }

    @Test
    public void shouldGetDescQuitSelection() {
        Assert.assertThat(quitSelection.getDesc(), CoreMatchers.is("testQuit"));
    }

    @Test
    public void shouldGetIdQuitSelection() {
        Assert.assertThat(quitSelection.getId(), CoreMatchers.is(0));
    }
}