package edu.princeton.cs.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * test for recusion funtion and dinamic programming
 *
 * @author philo
 * @create 2018-03-30 2:17 PM
 **/
public class RecursionAndDinamicTest extends BaseObjectTest<RecursionAndDinamicCallMethod>{

    @BeforeMethod(groups = "RecursionAndDinamic")
    public void initInstance(){super.initTestTasks(RecursionAndDinamicCallMethod.class);}

    @Test(groups = "RecursionAndDinamic")
    @Override
    protected void groupTest() {
        for(RecursionAndDinamicCallMethod task : testTasks){
            task.callRecursionAndDinamicAlgoMethod();
        }
    }
}
