package io.legaldocml.unsafe;

import io.legaldocml.test.SonarJUnit4ClassRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.legaldocml.test.Tests.assertUtilClassIsWellDefined;

/**
 * Test the Dark Side of Java.
 */
@RunWith(SonarJUnit4ClassRunner.class)
public class UnsageStringTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        assertUtilClassIsWellDefined(UnsafeString.class);
    }

    @Test
    public void buildStringTest() {
        char[] helloWorld = "helloWorld".toCharArray();

        String val = UnsafeString.buildUnsafe(helloWorld);
        Assert.assertEquals("helloWorld", val);
    }

    @Test
    public void darkSideStringTest() {
        char[] helloWorld = "helloWorld".toCharArray();
        String val = UnsafeString.buildUnsafe(helloWorld);
        Assert.assertEquals("helloWorld", val);
        helloWorld[0] = 'H';
        Assert.assertEquals("HelloWorld", val);
    }

    @Test
    public void getCharsTest() {
        String helloWorld = "HelloWorld";
        char[] value = UnsafeString.getChars(helloWorld);
        Assert.assertArrayEquals("HelloWorld".toCharArray(), value);
        value[0] = 'P';
        Assert.assertEquals("PelloWorld", helloWorld);

    }
}
