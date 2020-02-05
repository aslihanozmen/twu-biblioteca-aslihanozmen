package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static java.util.OptionalDouble.empty;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class BibliotecaLibraryFactoryTest {

    @Test
    public void buildLibrary() {
        BibliotecaLibrary bibliotecaLibrary = LibraryFactory.buildLibrary();
        assertThat(bibliotecaLibrary.getBooks(), CoreMatchers.is(not(empty())));
    }
}