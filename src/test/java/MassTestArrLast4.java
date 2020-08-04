import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MassTestArrLast4 {
    private Integer[] inArr;
    private Integer[] outArr;
    private Tools tools;

    public MassTestArrLast4(Integer[] inArr, Integer[] outArr) {
        this.inArr = inArr;
        this.outArr = outArr;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][][] {
                {new Integer[]{0, 4, 4, 2, 6, 0, 9}, new Integer[]{2, 6, 0, 9}},
                {new Integer[]{6, 8, 6, 5, 4},new Integer[]{}},
//                {6, 6, 6, 1, 1, 7, 8, 3, 5, 8},
//                {2, 1, 0, 9},
//                {2, 1, 3, 2, 1, 1, 8},
                {new Integer[]{4, 4, 1, 1, 1, 1, 1, 1, 4, 1},new Integer[]{1}}
        });
    }

    @Before
    public void beforeClass() throws Exception {
        tools = new Tools();
    }

    @Test
    public void massTest() {
        Assert.assertArrayEquals(outArr, tools.getArrayAfterLast4(inArr));
    }
}
