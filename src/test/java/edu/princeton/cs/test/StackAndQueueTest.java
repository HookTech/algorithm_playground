package edu.princeton.cs.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StackAndQueueTest extends BaseObjectTest{
    @Test(groups = "StackAndQueue")
    public void getMaxWindowTest(){
        printIntArray(self.getMaxWindow(new int[]{2,3,4,5},2));
    }

    /**** algorithm's function below & test above ****/
    private int[] getMaxWindow(int[] arr, int w){
        return new int[0];
    }

    /**** init below ****/
    private StackAndQueueTest self = null;

    @BeforeMethod(groups = "StackAndQueue")
    public void initInstance(){
        self = new StackAndQueueTest();
    }
}
