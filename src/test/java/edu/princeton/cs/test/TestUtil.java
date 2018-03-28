package edu.princeton.cs.test;

import static java.lang.System.out;
import static edu.princeton.cs.test.CommonStructure.Node;

public class TestUtil {
    private static char separator = ',';
    public static void printIntArray(int[] array){
        StringBuffer buffer = new StringBuffer();

        for(int element : array){
            buffer.append(element).append(separator);
        }
        printString(buffer.deleteCharAt(buffer.length() - 1).toString());
    }

    public static void printString(String ss){
        out.println(ss);
    }

    public static void printBoolean(boolean bool){
        out.println(bool);
    }

    public static <T> void printList(Node<T> head){
        StringBuilder sb = new StringBuilder();
        while (null != head){
            sb.append(head.value).append(separator);
            head = head.next;
        }
        printString(sb.deleteCharAt(sb.length() - 1).toString());
    }
}
