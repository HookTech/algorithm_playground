package edu.princeton.cs.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author philo
 * @create 4/12/18 07:01
 **/
public class BitCaculateClass implements BitOperationCallMethod{

    int testA = 45;

    int testB = -12;

    private int div(int a, int b){return 0;}

    private int multi(int a, int b){return 0;}

    @Override
    public void callBitOperationAlgoMethod() {
        TestUtil.printString("++++++++++++++++ bitCalculateTest ++++++++++++++++");
        prepareTestData();
        bitCalculateTest();
    }

    @BeforeMethod(groups = BitOperationCallMethod.testBaseName)
    public void prepareTestData(){}

    @Test(groups = BitOperationCallMethod.testBaseName)
    public void bitCalculateTest(){}
}
