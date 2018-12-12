package ps.philo.playground.test;

import edu.princeton.cs.test.TestUtil;
import org.testng.annotations.Test;
import ps.philo.playground.CommonStructure;
import ps.philo.playground.OptimalBinarySearchTree;

/**
 * philo
 * # 12/8/18
 */
public class OptimalBinarySearchTreeTest {
    @Test
    public void ptimalBinarySearchTreeTest(){
        OptimalBinarySearchTree testTree = new OptimalBinarySearchTree(5);
        float[] p = new float[]{Float.MAX_VALUE,0.15F,0.10F,0.05F,0.10F,0.20F};
        float[] q = new float[]{0.05F,0.10F,0.05F,0.05F,0.05F,0.10F};
        TestUtil.printTree(new CommonStructure.Tree<String>(testTree.optimalBST(p,q,5).constructOptimalBST(),Integer.MAX_VALUE));
    }
}
