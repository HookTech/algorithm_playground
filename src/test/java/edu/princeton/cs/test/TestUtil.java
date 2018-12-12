package edu.princeton.cs.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Random;
import java.util.Stack;

import static java.lang.System.out;
import static ps.philo.playground.CommonStructure.*;

public class TestUtil {
    private static char separator = ',';
    private static Random random = new Random(7);

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

    public static <T> void printT(T num){
        printString(String.valueOf(num));
    }

    public static <K,V> void printMap(Map<K,V> map){
        try {
            printString(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(map));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private static String recursionString(Stack<Integer> sk){
        if(sk.empty()) {return "";}
        else {
            StringBuffer buffer = new StringBuffer();
            buffer.append(TestUtil.separator).append(sk.pop().toString());
            buffer.insert(0,recursionString(sk));
            return buffer.toString();
        }
    }

    public static void printStackReversly(Stack<Integer> sk){
        Stack<Integer> skclone = new Stack<>();
        Object[] array = new Object[sk.size()];sk.copyInto(array);
        for(Object cln : array){  skclone.push(((Integer) cln));  }
        String stackStr = recursionString(skclone);
        TestUtil.printString(stackStr.substring(stackStr.indexOf(TestUtil.separator) + 1));
    }

    public static int generateRandomInteger(){
        return random.nextInt(3);
    }

    public static void assertEqualAndPrintToInfo(Object actual,Object expected){
        Assert.assertEquals(actual,expected);
        printString("result is '" + expected.toString() + "'");
    }

    public static <T> ListNode<T> generateListFromSeries(T... items){
        if(items.length ==0){return null;}
        ListNode<T> cur = new ListNode<>(items[0]), head = cur;
        for (int i = 1; i < items.length; i++) {
            cur.next = new ListNode<>(items[i]);
            cur = cur.next;
        }
        return head;
    }

    public static <T> ListNode<T> generateCircleListFromSeries(T... items){
        if(items.length ==0){return null;}
        ListNode<T> cur = new ListNode<>(items[0]), head = cur;
        for (int i = 1; i < items.length; i++) {
            cur.next = new ListNode<>(items[i]);
            cur = cur.next;
        }
        cur.next = head;
        return head;
    }

    public static <T> void assertList(ListNode<T> list, T... items) throws Exception {
        if(list == null || items.length ==0){throw new Exception("list must not be null OR items must have value!");}
        int i = 0;
        while (list != null && i < items.length){
            Assert.assertEquals(list.value, (items[i]));
            list = list.next; i++;
        }
        Assert.assertTrue(i == items.length);
    }

    public static <T> void printList(ListNode<T> head){
        if(head == null) return;
        StringBuilder sb = new StringBuilder();
        while (null != head){
            sb.append(head.value).append(separator);
            head = head.next;
        }
        printString(sb.deleteCharAt(sb.length() - 1).toString());
    }

    public static void printTree(Tree<String> treeRoot){
        printString(treeRoot.toString());
    }

    @Test
    public void generateListFromSeriesTest(){
        printList(generateListFromSeries(5,4,6,2,3,7));
        printList(generateListFromSeries());
    }

    @Test
    public void assertListTestYes() throws Exception {
        assertList(generateListFromSeries(4,5,6),4,5,6);
    }
}
