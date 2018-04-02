package edu.princeton.cs.test;

import edu.princeton.cs.algs4.Stack;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static edu.princeton.cs.test.CommonStructure.Node;

/**
 * 判断一个链表是否是回文结构
 *
 * @author philo
 * @create 2018-04-02 9:33 AM
 **/
public class JudgePanlindromeClass implements ListPCallMethod {
    private Node<Integer> palindromeNode;
    private Node<Integer> nonePalindromeNode;

    /*** self practice function **/
    private boolean selfIsPalindrome(Node<Integer> node){
        Stack<Integer> mirrorSk = new Stack<>();
        Node<Integer> compareNode = node;
        while (node != null){
            mirrorSk.push(node.value);
            node = node.next;
        }
        while (compareNode != null){
            if(compareNode.value != mirrorSk.pop()) {return false;}
            compareNode = compareNode.next;
        }
        return true;
    }

    @Override
    public void callListPCallAlgoMethod() {
        prepareTestData();
        judgePalindromeTest();
    }

    @Test(groups = ListPCallMethod.testBaseName)
    public void judgePalindromeTest(){
        TestUtil.printString("palindrome list for test is:");
        TestUtil.printList(palindromeNode);
        TestUtil.assertEqualAndPrintToInfo(selfIsPalindrome(palindromeNode),true);

        TestUtil.printString("non-Palindrome list for test is:");
        TestUtil.printList(nonePalindromeNode);
        TestUtil.assertEqualAndPrintToInfo(selfIsPalindrome(nonePalindromeNode),false);
    }

    @BeforeMethod(groups = ListPCallMethod.testBaseName)
    public void prepareTestData(){
        palindromeNode = new Node<>(1);
        Node<Integer> fur = palindromeNode;
        palindromeNode.next = new Node<>(2);palindromeNode = palindromeNode.next;
        palindromeNode.next = new Node<>(3);palindromeNode = palindromeNode.next;
        palindromeNode.next = new Node<>(2);palindromeNode = palindromeNode.next;
        palindromeNode.next = new Node<>(1);
        palindromeNode = fur;

        nonePalindromeNode = new Node<>(1);
        fur = nonePalindromeNode;
        nonePalindromeNode.next = new Node<>(2);nonePalindromeNode = nonePalindromeNode.next;
        nonePalindromeNode.next = new Node<>(3);nonePalindromeNode = nonePalindromeNode.next;
        nonePalindromeNode.next = new Node<>(3);nonePalindromeNode = nonePalindromeNode.next;
        nonePalindromeNode.next = new Node<>(1);
        nonePalindromeNode = fur;
    }
}
