package edu.princeton.cs.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 二维矩阵中最小的路径值，经典动态规划
 */
public class MatrixMinPathClass implements RecursionAndDinamicCallMethod {

    private Map<Coordinate, Integer> cachedMap = new HashMap<>();

    @Override
    public void callRecursionAndDinamicAlgoMethod() {
        TestUtil.printString("++++++++++++++++ getMatrixMinPathTest ++++++++++++++++");
        getMatrixMinPathTest();
    }

    @Test
    private void getMatrixMinPathTest() {
        Matrix testCase = Matrix.getInitMatrix();
        Assert.assertEquals(calulateMin(testCase, 0, 0), 1);
        Assert.assertEquals(calulateMin(testCase, 1, 0), 4);
        Assert.assertEquals(calulateMin(testCase, 0, 1), 9);
        Assert.assertEquals(calulateMin(testCase, 1, 1), 5);
        Assert.assertEquals(calulateMin(testCase, 2, 2), 11);
        Assert.assertEquals(calulateMin(testCase, 3, 3), 12);
        Assert.assertEquals(calulateMin(testCase, 1, 2), 5);
    }

    private int calulateMin(Matrix mux, int i, int j) {
        if (i < 0 || i > mux.cols() || j < 0 || j > mux.rows()) {
            return 0;
        }
        Coordinate cod = new Coordinate(i, j);
        if (cachedMap.containsKey(cod)) {
            return cachedMap.get(cod);
        }
        int choice1 = calulateMin(mux, i - 1, j );
        int choice2 = calulateMin(mux, i,  j - 1);
        int value = choose(choice1,choice2) + mux.getValue(i, j);
        cachedMap.put(cod, value);
        return value;
    }

    private int choose(int choice1, int choice2){
        if(choice1 == 0 && choice2 != 0){ return choice2;}
        else if(choice1 != 0 && choice2 == 0){return choice1;}
        else if(choice1 == 0 && choice2 == 0) {return 0;}
        else {
            return (choice1 < choice2 ? choice1 : choice2);
        }
    }

    private class Coordinate {
        int indexI;
        int indexJ;

        public Coordinate(int indexI, int indexJ) {
            this.indexI = indexI;
            this.indexJ = indexJ;
        }

        @Override
        public int hashCode() {
            return indexI * 100 + indexJ;
        }

        @Override
        public boolean equals(Object obj) {
            return this.indexI == ((Coordinate) obj).indexI
                    &&
                    this.indexJ == ((Coordinate) obj).indexJ;
        }
    }

    private static class Matrix {
        int[][] dp;

        public Matrix(int[][] init, int rows, int cols) {
            dp = init;
            rowNum = rows;
            colNum = cols;
        }

        int rowNum;
        int colNum;

        public int rows() {
            return this.rowNum;
        }

        public int cols() {
            return this.colNum;
        }

        public int getValue(int i, int j) {
            if (i < 0 || i > cols() || j < 0 || j > rows()) {
                return 0;
            }
            return dp[j][i];
        }

        public static Matrix getInitMatrix() {
            int[][] raw =
                    {
                            {1, 3, 5, 9},
                            {8, 1, 3, 4},
                            {5, 0, 6, 1},
                            {8, 8, 4, 0}
                    };
            return new Matrix(raw, 4, 4);
        }
    }
}
