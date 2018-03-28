package edu.princeton.cs.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Stack;

import static edu.princeton.cs.test.CommonStructure.Node;

/**
 * two list standing for int value add together
 *
 * @author philo
 * @create 2018-03-27 9:26 AM
 **/
public class AddListClass implements ListPCallMethod{

    Node<Integer> head1,head2;

    /*** self practice function **/
    private Node<Integer> selfAddLists(Node<Integer> head1, Node<Integer> head2){
        if(head1 == null || head2 == null) return null;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> ss = new Stack<>();
        Node<Integer> pointer1 = head1;
        Node<Integer> pointer2 = head2;
        while (null != pointer1){
            if(pointer1.value > 9 || pointer1.value < 0) return null;
            s1.push(pointer1.value);
            pointer1 = pointer1.next;
        }
        while (null != pointer2){
            if(pointer2.value > 9 || pointer2.value < 0) return null;
            s2.push(pointer2.value);
            pointer2 = pointer2.next;
        }
        Node<Integer> resHead = null;//final result head
        int ca = 0;//next time, default zero
        while (true){
            if(s1.empty() && s2.empty()) {break;}
            int v1 = s1.empty() ? 0 : s1.pop();
            int v2 = s2.empty() ? 0 : s2.pop();
            if(v1 + v2 + ca >= 10){
                ss.push(v1 + v2 + ca - 10);
                ca = 1;
            }
            else{
                ss.push(v1 + v2 + ca);
                ca = 0;
            }
        }
        resHead = new Node<Integer>((1 == ca) ? 1 : ss.pop());
        Node<Integer> cur = resHead;
        while (null != cur && !ss.empty()){
            cur.next = new Node<Integer>(ss.pop());
            cur = cur.next;
        }
        return resHead;
    }
    /*** official resolve **/
    private Node<Integer> officialAddLists(Node<Integer> head1, Node<Integer> head2){

        return new Node<>(0);
    }

    @Override
    public void callListPCallAlgoMethod() {
        addListTest();
    }

    @Test(groups = "ListPTest")
    public void addListTest(){
        TestUtil.printString("List1");
        TestUtil.printList(head1);
        TestUtil.printString("List2");
        TestUtil.printList(head2);
        TestUtil.printString("list1 + list2 bring out result");
        TestUtil.printList(selfAddLists(head1,head2));
    }

    @BeforeMethod(groups = "ListPTest")
    public void prepareTestData(){
        head1 = new Node<>(1);
        head2 = new Node<>(2);
        Node<Integer> bodyNext1 = head1;
        Node<Integer> bodyNext2 = head2;
        for(int i = 2; i < 9; i++,bodyNext1 = bodyNext1.next){
            bodyNext1.next = new Node<>(i);
        }
        for(int i = 3; i < 10; i++,bodyNext2 = bodyNext2.next){
            bodyNext2.next = new Node<>(i);
        }
    }
}
