package test.java;

import main.java.mathoperation.FrequencyModus;
import main.java.mathoperation.Mean;
import main.java.mathoperation.Median;
import main.java.readwrite.ReadWrite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.resources.Resources;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathTest {
    @Test
    @DisplayName("Positive Case - Mean")
    void MeanPositive() throws FileNotFoundException {
        Mean mean = new Mean();
        Double meanResult = mean.meanResult();

        Double total = 1647.0;
        Double size = 198.0;
        Double hasil = total/size;
        assertEquals(hasil, meanResult);

    }
    @Test
    @DisplayName("Positive Case - Median")
    void medianPositive() throws FileNotFoundException {
        Median median = new Median();
        Integer medianItem = median.MedianResult();

        List<Integer> rf = ReadWrite.readFile(Resources.path);
        rf = rf.stream().sorted().collect(Collectors.toList());
        Integer medianResult = 99;

        assertEquals(rf.get(medianResult), medianItem);
    }

    @Test
    @DisplayName("Positive Test - Modus")
    void modusPositive() throws FileNotFoundException {
        FrequencyModus fm = new FrequencyModus();
        Integer modusItem = 7;

        assertEquals(fm.modusResult(), modusItem);
    }

}
