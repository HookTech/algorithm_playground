package edu.princeton.cs.test;

import static java.lang.System.out;

public class TestUtil {
    protected static void printIntArray(int[] array){
        StringBuffer buffer = new StringBuffer();
        char separator = ',';
        for(int element : array){
            buffer.append(element).append(separator);
        }
        out.println(buffer.deleteCharAt(buffer.length() - 1));
    }

    protected static void printString(String ss){
        out.println(ss);
    }

    protected static void printBoolean(boolean bool){
        out.println(bool);
    }
}
