import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testTools {
    private Tools tools;

    @Before
    public void init() {
        tools = new Tools();
    }

    @Test
    public void testToolsGetArrayAfterLast4() {
        Assert.assertArrayEquals(new Integer[]{6, 5}, tools.getArrayAfterLast4(new Integer[]{1, 6, 3, 2, 4, 6, 5}));
    }

    @Test
    public void testIsContentArray1and4() {
        Assert.assertTrue(tools.isContentArray1and4(new Integer[]{1, 4, 1, 4, 1, 1, 4, 4, 1, 1}));
    }

    @Test(expected = RuntimeException.class)
    public void testToolsGetArrayAfterLast4Exception() {
        tools.getArrayAfterLast4(new Integer[]{1, 6, 3, 2, 6, 5});
    }
}
