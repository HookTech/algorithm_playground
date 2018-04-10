package edu.princeton.cs.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author philo
 * @create 4/2/18 21:08
 **/
public class FindOneInKArrayClass implements BitOperationCallMethod {

    private int[] arr;

    private int k;

    private int selfOnceNum(int[] arr,int k){
        return 1;
    }

    private int officialOnceNum(int[] arr, int k){return 0;}

    @Override
    public void callBitOperationAlgoMethod() {
        TestUtil.printString("++++++++++++++++ findOneInKArrayTest ++++++++++++++++");
        prepareTestData();
        findOneInKArrayTest();
    }

    @Test(groups = BitOperationCallMethod.testBaseName)
    public void findOneInKArrayTest(){
        TestUtil.printString("The kth num is "+ k +" and the arr is:");
        TestUtil.printIntArray(arr);
        TestUtil.assertEqualAndPrintToInfo(selfOnceNum(arr,k),1);
    }

    @BeforeMethod(groups = BitOperationCallMethod.testBaseName)
    public void prepareTestData(){
        arr = new int[]{4,4,1,4,4,2,3,2,3,2,3,2,3};
        k = 4;
    }
}
