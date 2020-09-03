package utils;

import com.company.Infrastructure.utils.StringUtils;
import org.junit.Assert;
import org.junit.Test;


public class StringUtilsTests {

    @Test
    public void testAlpha(){

        String result = StringUtils.getRandom(StringUtils.StringType.ALPHA, 10);
        System.out.println(result);
        Assert.assertEquals("Incorrect String Type", true, result.matches("[a-zA-Z]+"));
        Assert.assertEquals("Incorrect length",10, result.length());
    }

    @Test
    public void testNumeric(){

        String result = StringUtils.getRandom(StringUtils.StringType.NUMERIC, 10);
        System.out.println(result);
        Assert.assertEquals("Icorrect String Type", true, result.matches("[0-9]+"));
        Assert.assertEquals("Incorrect length", 10, result.length());
    }

    @Test
    public void testAlphaNumeric(){

        String result = StringUtils.getRandom(StringUtils.StringType.ALPHANUMERIC, 10);
        System.out.println(result);
        Assert.assertEquals("Incorrect String Type", true, result.matches("[a-zA-Z0-9]+"));
    }

}
