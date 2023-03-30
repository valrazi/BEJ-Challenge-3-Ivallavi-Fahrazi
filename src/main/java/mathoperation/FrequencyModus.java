package main.java.mathoperation;

import main.java.readwrite.ReadWrite;
import main.resources.Resources;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyModus {
    List<Integer> rf = ReadWrite.readFile(Resources.path);
    HashMap<Integer, Integer> mapFreq = new HashMap<Integer,Integer>();

    Integer maxValue;


    Integer freq = 0;

    public FrequencyModus() throws FileNotFoundException {
        //Fitur Java 8 Stream dan Lambda
        rf.stream().sorted().forEach(i ->{
            if (!mapFreq.containsKey(i)) {
                freq = 0;
                freq += 1;
                mapFreq.put(i, freq);
            }else{
                freq+= 1;
                mapFreq.put(i, freq);
            }
        });
       maxValue = Collections.max(mapFreq.entrySet(), Map.Entry.comparingByValue()).getKey();
       
    }

    public HashMap<Integer, Integer> frequencyResult(){
        return mapFreq;
    }

    public Integer modusResult(){
        return maxValue;
    }

}
