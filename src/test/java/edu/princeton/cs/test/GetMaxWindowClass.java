package edu.princeton.cs.test;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;

public class GetMaxWindowClass implements StackAndQueueCallMethod {
    /*** self practice function **/
    //get max value collection steam from big array with window move
    private int[] getMaxWindow(int[] arr, int w){
        assert arr.length >= w && w > 0;
        int arrLength= arr.length;
        int[] res = new int[arrLength - w + 1];
        Deque<Integer> qMax = new LinkedList<Integer>();//Double ended queue
        int index = 0;
        do{
            getMaxWindow_dealQMax(qMax,arr,w,index++);
        }
        while(index < w - 1);
        for (; index < arrLength; index++) {
            getMaxWindow_dealQMax(qMax,arr,w,index);
            res[index - w + 1] = arr[qMax.getFirst()];//query first element,max value
        }
        return res;
    }
    //deal qMax structure with element
    private void getMaxWindow_dealQMax(Deque<Integer> qMax, int[] arr, int w, int index){
        int element = arr[index];
        do{
            if(qMax.isEmpty()){
                qMax.addLast(index);
                break;
            }
            else{
                if(element < arr[qMax.getLast()]){
                    qMax.addLast(index);
                    if(qMax.getFirst() == index - w) qMax.pollFirst();
                    break;
                }
                else {
                    qMax.pollLast();
                }
            }
        }

        while (true);
    }

    @Override
    public void callStackAndQueueAlgoMethod() {
        getMaxWindowTest();
    }

    /**** unit test below ****/
    @Test(groups = "StackAndQueue")
    public void getMaxWindowTest(){
        TestUtil.printIntArray(getMaxWindow(new int[]{4,3,5,4,6,3,6,7},2));
    }
}
