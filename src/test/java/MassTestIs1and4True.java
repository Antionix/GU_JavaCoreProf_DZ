import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MassTestIs1and4True {
    private Integer[] intArray;
    //    private boolean is1and4;
    private Tools tools;

    public MassTestIs1and4True(Integer[] intArray) {
        this.intArray = intArray;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{4, 1, 1, 4, 4, 1, 1, 1, 4, 1}},
                {new Integer[]{4, 4, 4, 4, 4, 1, 1, 4, 4, 4}},
                {new Integer[]{1, 1, 4, 1, 1, 1, 4, 4, 4, 1, 4, 4, 1}},
//                {1, 1, 3, 1, 6, 1, 5, 1, 4},
//                {1, 2, 4, 1, 5, 1, 4},
//                {1, 1, 1, 1, 1, 1, 1, 1},
//                {4, 4, 4, 4, 4, 4}
                {new Integer[]{4, 4, 1, 1, 1, 1, 1, 1, 4, 1}}
        });
    }

    @Before
    public void beforeClass() throws Exception {
        tools = new Tools();
    }

    @Test
    public void massTestIsContentArray1and4() {
        Assert.assertTrue(tools.isContentArray1and4(intArray));
    }
}
