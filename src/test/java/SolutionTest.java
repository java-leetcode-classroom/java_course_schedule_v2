import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    final private  Solution sol = new Solution();
    @Test
    void findOrderExample1() {
        assertArrayEquals(
                new int[]{0,1},
                sol.findOrder(2, new int[][]{
                        {1,0}
                })
        );
    }
    @Test
    void findOrderExample2() {
        assertArrayEquals(
                new int[]{0,1,2,3},
                sol.findOrder(4, new int[][]{
                        {1,0},{2,0}, {3,1},{3,2}
                })
        );
    }
    @Test
    void findOrderExample3() {
        assertArrayEquals(
                new int[]{0},
                sol.findOrder(1, new int[][]{

                })
        );
    }
    @Test
    void findOrderExample4() {
        assertArrayEquals(
                new int[]{},
                sol.findOrder(2, new int[][]{
                        {1,0},{0,1}
                })
        );
    }
}