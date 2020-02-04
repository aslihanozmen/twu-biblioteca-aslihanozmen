package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static java.util.OptionalDouble.empty;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class LibraryFactoryTest {

    @Test
    public void buildLibrary() {
        Library library = LibraryFactory.buildLibrary();
        assertThat(library.getBooks(), CoreMatchers.is(not(empty())));
    }
}