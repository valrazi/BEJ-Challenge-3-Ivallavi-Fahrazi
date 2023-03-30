package test.java;

import com.sun.jdi.request.InvalidRequestStateException;
import main.java.readwrite.ReadWrite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.resources.Resources;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WriteTest {

    public WriteTest() throws FileNotFoundException {
    }
    @Test
    @DisplayName("Negative Test - Write Method: File Null")
    void writeNegative(){
        Exception e = assertThrows(FileNotFoundException.class, () -> {
            ReadWrite.writeFile(null, 1);
        });
        assertEquals("File directory not specified", e.getMessage());
    }
    @Test
    @DisplayName("Negative Test - Write Method: Options null")
    void writeNegativeOptNull(){
        Exception e = assertThrows(InvalidRequestStateException.class, () -> {
            ReadWrite.writeFile(Resources.pathWriteModus, null);
        });
        assertEquals("Options can't be null", e.getMessage());
    }
}
