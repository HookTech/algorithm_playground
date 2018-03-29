package edu.princeton.cs.test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Stack;

public class GetAndRemoveLastElementClass implements StackAndQueueCallMethod {
    /*** self practice function **/
    private void selfReverseStack(Stack<Integer> sk){}

    /***standard resolve***/
    @Override
    public void callStackAndQueueAlgoMethod() {
        getAndRemoveLastElementTest();
    }

    @Test(groups = "StackAndQueue")
    public void getAndRemoveLastElementTest(){
        TestUtil.printString("Before reverse, stack is:");
        TestUtil.printStackReversly(sk);
        TestUtil.printString("Reverse stack ... ");
        selfReverseStack(sk);
        TestUtil.printString("After reverse, stack is");
        TestUtil.printStackReversly(sk);
    }

    @BeforeMethod(groups = "StackAndQueue")
    public void prepareTestData(){
        sk = new Stack<>();
        for(int i = 0; i < 9; i++) {
          sk.push(i);
        }
    }

    private Stack<Integer> sk;

}
