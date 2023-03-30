package test.java;


import main.java.readwrite.ReadWrite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.resources.Resources;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReadTest {
    Resources rsc = new Resources();
    @Test
    @DisplayName("Negative Test - Read Method")
    void readNegative() {
        Exception e  = assertThrows(FileNotFoundException.class, () -> {
            ReadWrite.readFile(null);
        });
        assertEquals("File not found", e.getMessage());
    }

    @Test
    @DisplayName("Positive Test - Read Method")
    void readPositive() throws FileNotFoundException {
        List<Integer> result = ReadWrite.readFile(rsc.path);
        assertEquals(198, result.size());
    }


}
