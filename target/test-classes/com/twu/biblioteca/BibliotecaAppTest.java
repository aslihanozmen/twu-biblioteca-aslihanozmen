//package com.twu.biblioteca;
//
//import com.twu.biblioteca.commandline.ScannerWrapper;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import static com.twu.biblioteca.BibliotecaApp.getInput;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.core.StringContains.containsString;
//import static org.mockito.Matchers.anyString;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
//public class BibliotecaAppTest {
//
////    private  ByteArrayOutputStream outputContent;
////
////
////    @Before
////    public void setUp() {
////        outputContent = new ByteArrayOutputStream();
////        System.setOut(new PrintStream(outputContent));
////        BibliotecaApp.main(new String[]{});
////    }
////
////
////    @Test
////    public void shouldPrintWelcomeMessage() {
////        Assert.assertThat(outputContent.toString(), containsString("Welcome"));
////    }
////
////    @Test
////    public void shouldPrintTheActions() {
////        Assert.assertThat(outputContent.toString(), containsString("List"));
////    }
////
////    @Test
////    public void shouldAskUserInput() {
////        Assert.assertThat(outputContent.toString(), containsString("Enter Choice"));
////    }
//
//
//    @Test
//    public void shouldGetInput() {
//        ScannerWrapper scannerWrapper = mock(ScannerWrapper.class);
//        when(scannerWrapper.askUserForInput(anyString())).thenReturn("1");
//        Assert.assertThat(getInput(scannerWrapper,0,2), equalTo(1));
//
//    }
//
//    @Test
//    public void shouldStartApp() {
//        ScannerWrapper scannerWrapper = mock(ScannerWrapper.class);
//        when(scannerWrapper.askUserForInput("Enter Choice: \n")).thenReturn("1");
//        Assert.assertThat(getInput(scannerWrapper,0,2), equalTo(1));
//
//    }
//}
