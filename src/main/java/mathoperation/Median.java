package main.java.mathoperation;

import main.java.readwrite.ReadWrite;
import test.resources.Resources;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class Median {


    List<Integer> rf = ReadWrite.readFile(Resources.path);

    Integer size = rf.size();

    public Median() throws FileNotFoundException {
    }

    public Integer MedianResult(){
        //Fitur Java 8 Stream dan Lambda
        rf = rf.stream().sorted().collect(Collectors.toList());
        Integer result = 0;
        if(size % 2 == 1){
            result = (size+1) /2;
        }else{
            result = ((size / 2) + ((size / 2) + 1)) / 2 ;
        }

        return rf.get(result - 1 );
    }
}
