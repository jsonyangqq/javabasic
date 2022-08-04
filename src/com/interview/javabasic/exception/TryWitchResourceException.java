package com.interview.javabasic.exception;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author json.yang
 * @Description try-with-resources 和 multiple catch
 * @Date 2019-09-24
 */
public class TryWitchResourceException {



    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("");
             FileWriter fileWriter = new FileWriter("")) { // try-with-resources
            System.out.println("try");
        } catch (IOException | NullPointerException e) { // multiple catch
            System.out.println(e);
        }
    }

}