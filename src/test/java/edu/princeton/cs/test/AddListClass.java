package edu.princeton.cs.test;

import org.testng.annotations.Test;
import static edu.princeton.cs.test.CommonStructure.Node;

/**
 * two list standing for int value add together
 *
 * @author philo
 * @create 2018-03-27 9:26 AM
 **/
public class AddListClass implements ListPCallMethod{

    /*** self practice function **/
    private Node<Integer> addLists(Node<Integer> head1, Node<Integer> head2){

        return new Node<>();
    }

    @Override
    public void callListPCallAlgoMethod() {
        addListTest();
    }

    @Test(groups = "ListPTest")
    public void addListTest(){
        TestUtil.printString("addlist");
    }
}
