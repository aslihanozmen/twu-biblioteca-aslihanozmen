//package com.twu.biblioteca;
//
//import com.twu.biblioteca.factory.MenuFactory;
//import org.hamcrest.CoreMatchers;
//import org.junit.Test;
//
//import static java.util.OptionalDouble.empty;
//import static org.hamcrest.CoreMatchers.not;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//public class BibliotecaMenuFactoryTest {
//
//    @Test
//    public void buildLibrary() {
//        BibliotecaLibrary bibliotecaLibrary = MenuFactory.buildLibrary();
//        assertThat(bibliotecaLibrary.getBooks(), CoreMatchers.is(not(empty())));
//    }
//}