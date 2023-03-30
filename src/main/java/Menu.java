package main.java;

import main.java.readwrite.ReadWrite;
import main.resources.Resources;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    public Integer Scan() throws FileNotFoundException {
        Integer options;
        try{
            options = sc.nextInt();
        }catch (InputMismatchException e){
            throw new InputMismatchException("Mismatch input (input number between 0-3)");
        }
        return options;
    }

    public Menu() throws FileNotFoundException {
        Boolean status = true;
        while (status){
            System.out.println("--------------------------------");
            System.out.println("Aplikasi Pengolah File");
            System.out.println("--------------------------------");
            System.out.println("Letakkan file csv dengan nama file_data sekolah di direktori " +
                    "berikut: " + Resources.path);
            System.out.println();
            System.out.println("pilih menu");
            System.out.println("1.Generate txt untuk menampilkan modus");
            System.out.println("2.Generate txt untuk menampilkan nilai rata-rata, median");
            System.out.println("3.Generate kedua file");
            System.out.println("0.Exit");
            Integer options = Scan();
            if(options == 0) break;
            switch (options){
                case 1 :
                    ReadWrite.writeFile(Resources.pathWriteModus, 1);
                    break;
                case 2 :
                    ReadWrite.writeFile(Resources.pathWrite, 2);
                    break;
                case 3:
                    ReadWrite.writeFile(Resources.pathWriteModus, 1);
                    ReadWrite.writeFile(Resources.pathWrite, 2);
                    break;
                default:
                    System.err.println("Invalid Number");
                    break;
            }

        }
    }
}
