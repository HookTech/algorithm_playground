package edu.princeton.cs.test;

import org.testng.annotations.Test;

/**
 * 数组的值记录了从下标位置向右跳跃到另一个位置的范围
 * 给定数组，返回从第0个位置跳到最后一位需要的最小步数
 *
 * @author philo
 * @create 2018-03-30 2:35 PM
 **/
public class JumpGameClass implements RecursionAndDinamicCallMethod{

    /*** self practice function **/
    private int jump(int[] arr){
        return minStep(arr,0,arr.length - 1);
    }

    private int minStep(int[] arr,int s,int e){
        if(s >= e) return 0;
        int maxNum = Integer.MAX_VALUE;
        int range = arr[s] <= 0 ? -1 : arr[s];
        if(-1 == range) return maxNum;
        int min = maxNum;int tmp = 0;
        for(int i = 1; i <= range; i++) {
          tmp = minStep(arr,s+i,e);
          min = tmp < min ? tmp : min;
        }
        return min == maxNum ? maxNum : min + 1;
    }

    /***standard resolve***/
    @Override
    public void callRecursionAndDinamicAlgoMethod() {
        jumpGame();
    }

    @Test(groups = "RecursionAndDinamic")
    public void jumpGame(){
        int[] jumpArray = new int[]{3,-1,5,3,0,2,1,1};
        TestUtil.printString("jump arr is:");
        TestUtil.printIntArray(jumpArray);
        TestUtil.printString("jump min step is:" + jump(jumpArray));
    }
}
