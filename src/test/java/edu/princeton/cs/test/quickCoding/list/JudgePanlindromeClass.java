package edu.princeton.cs.test.quickCoding.list;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.test.ListPCallMethod;
import edu.princeton.cs.test.TestUtil;
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
    private boolean selfIsPalindrome1(Node<Integer> node){
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

    //time:O(N),space:O(1); cpu's cost replace space cost
    private boolean selfIsPalindrome2(Node<Integer> node){
        Node<Integer> right = node;
        Node<Integer> left = node;
        while (node.next != null && right.next != null && right.next.next != null){
            node = node.next;
            right = right.next.next;
        }
        if(right.next == null){//node is the mid
            right = reverseLinkList(node);
            Node<Integer> leftHead = left;
            Node<Integer> rightHead = right;
            while (left != null && right != null){
                if(left.value != right.value) {
                    reverseLinkList(rightHead);
                    node = leftHead;
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            reverseLinkList(rightHead);
            node = leftHead;
            return true;
        }
        else {//null node is the mid
            right = reverseLinkList(node.next);
            node.next = null;
            Node<Integer> leftHead = left;
            Node<Integer> rightHead = right;
            while (left != null && right != null){
                if(left.value != right.value) {
                    node.next = reverseLinkList(rightHead);
                    node = leftHead;
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            node.next = reverseLinkList(rightHead);
            node = leftHead;
            return true;
        }
    }

    private boolean officialIsPalindrome(Node<Integer> head){
        if(head == null || head.next == null){return  true;}
        Node<Integer> n1 = head;
        Node<Integer> n2 = head;
        while (n2.next != null && n2.next.next != null){//search for middle node
            n1 = n1.next;//mid
            n2 = n2.next.next;//tail
        }
        n2 = n1.next;//n2 -> first node on right part
        n1.next = null;//mid.next -> null
        Node<Integer> n3 = null;
        while (n2 != null){//reverse right part
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null){
            if(n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    private Node<Integer> reverseLinkList(Node<Integer> head){
        if(head == null) {return null;}
        Node<Integer> curr = head;
        Node<Integer> prev = null;
        Node<Integer> fur = curr.next;
        while (fur != null){
            curr.next = prev;
            prev = curr;
            curr = fur;
            fur = fur.next;
        }
        curr.next = prev;
        return curr;
    }

    @Override
    public void callListPCallAlgoMethod() {
        TestUtil.printString("++++++++++++++++ judgePalindromeTest ++++++++++++++++");
        prepareTestData();
        judgePalindromeTest();
    }

    @Test(groups = ListPCallMethod.testBaseName)
    public void judgePalindromeTest(){
        TestUtil.printString("palindrome list for test is:");
        TestUtil.printList(palindromeNode);
        TestUtil.assertEqualAndPrintToInfo(officialIsPalindrome(palindromeNode),true);
        TestUtil.printString("after judge, the list is not be changed");
        TestUtil.printList(palindromeNode);

        TestUtil.printString("non-Palindrome list for test is:");
        TestUtil.printList(nonePalindromeNode);
        TestUtil.assertEqualAndPrintToInfo(officialIsPalindrome(nonePalindromeNode),false);
        TestUtil.printString("after judge, the list is not be changed");
        TestUtil.printList(nonePalindromeNode);
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
