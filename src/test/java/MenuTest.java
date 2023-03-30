package test.java;

import main.java.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuTest {
    Menu menu = new Menu();

    public MenuTest() throws FileNotFoundException {
    }

    @Test
    @DisplayName("Negative Test - Menu Null")
    void negativeTestNullMenu(){
        //Java 8 Lambda
        Exception e = assertThrows(InputMismatchException.class, () ->{

        });
        assertEquals("awa", e.getMessage());
    }
}
