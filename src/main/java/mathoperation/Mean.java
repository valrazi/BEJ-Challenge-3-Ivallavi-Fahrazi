package main.java.mathoperation;

import main.java.readwrite.ReadWrite;
import test.resources.Resources;

import java.io.FileNotFoundException;
import java.util.List;

public class Mean {

    List<Integer> rf = ReadWrite.readFile(Resources.path);
    Double size = (double) rf.size();
    Double sum = (double) 0;

    public Mean() throws FileNotFoundException {
    }
    public Double meanResult(){
        //Fitur Java 8 Stream dan Lambda
        rf.stream().forEach(i ->{
            sum += i;
        });
        Double result = (sum /size);
        return result;
    }


}
