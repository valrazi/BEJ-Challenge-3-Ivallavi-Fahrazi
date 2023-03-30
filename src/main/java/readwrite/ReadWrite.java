package main.java.readwrite;

import com.sun.jdi.request.InvalidRequestStateException;
import main.java.mathoperation.FrequencyModus;
import main.java.mathoperation.Mean;
import main.java.mathoperation.Median;
import main.resources.Resources;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface ReadWrite {
    /*
        Implementasi fitur java 8: Static Method dalam Interface
    */
    static List<Integer> readFile(String path) throws FileNotFoundException{
        if(path == null){
            throw new FileNotFoundException("File not found");
        }
        String tempLine = "";
        List<String> tempArr = new ArrayList<>();
        List<Integer> tempArrInt = new ArrayList<>();
        try{
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while ((tempLine = br.readLine()) != null){
                char[] tempChar = tempLine.toCharArray();
                for (int i = 0; i < tempChar.length; i++) {
                    if(Character.isDigit(tempChar[i])){
                        if(tempChar[i] == '1' && tempChar[i + 1] == '0'){
                            tempArrInt.add(10);
                            i++;
                        }else{
                            tempArrInt.add(Character.getNumericValue(tempChar[i]));
                        }
                    }
                }
            }

        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        Collections.sort(tempArr);
        return tempArrInt;
    };

    static void writeFile(String path, Integer option) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        Mean mean = new Mean();
        Median median = new Median();
        FrequencyModus freqModus = new FrequencyModus();
        if(path == null){
            throw new FileNotFoundException("File directory not specified");
        }
        if(option == null){
            throw new InvalidRequestStateException("Options can't be null");
        }
        try{
            File file = new File(path);
            if(file.createNewFile()){
                System.out.println("New File Created");
            }
            FileWriter writer = new FileWriter(file);
            BufferedWriter bwr = new BufferedWriter(writer);
            switch (option){
                case 1:
                    sb.append(String.format("%s | %s\n", "Nilai", "Frekuensi"));
                    freqModus.frequencyResult().forEach((key, value) ->{
                        sb.append(String.format("%d %8d\n", key, value));
                    });
                    bwr.append(sb);
                    bwr.close();
                    sb.setLength(0);
                    System.out.println("Success write file!");
                    System.out.println("File Location: " + Resources.pathWriteModus);
                    break;
                case 2:
                    sb.append("Berikut Hasil Pengolahan Nilai\n\nBerikut hasil sebaran data nilai\n");
                    sb.append(String.format("Mean : %.2f\n", mean.meanResult()));
                    sb.append(String.format("Median: %d\n", median.MedianResult()));
                    sb.append(String.format("Modus: %d\n", freqModus.modusResult()));
                    bwr.append(sb);
                    bwr.close();
                    sb.setLength(0);
                    System.out.println("Success write file!");
                    System.out.println("File Location: " + Resources.pathWrite);
                    break;
            }


        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
