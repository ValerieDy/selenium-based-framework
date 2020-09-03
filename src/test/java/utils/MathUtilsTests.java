package utils;

import com.company.Infrastructure.utils.MathUtils;
import org.junit.Assert;
import org.junit.Test;

public class MathUtilsTests {

    @Test
    public void testWithEqualLimits(){
        Assert.assertEquals(5, MathUtils.randomFromRange(5,5));

    }

    @Test
    public void testWithNegativeLimits(){
        Assert.assertTrue(MathUtils.randomFromRange(-5, 0) >= -5);
        Assert.assertTrue(MathUtils.randomFromRange(-5, 0) <= -5);
    }

    @Test
    public void testWithNormalLimits(){
        Assert.assertTrue(MathUtils.randomFromRange(0, 10) >= 0);
        Assert.assertTrue(MathUtils.randomFromRange(0,10) <= 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithSwappedLimits(){
        MathUtils.randomFromRange(5,0);
    }

}

