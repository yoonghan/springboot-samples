package com.walcron.sample.util;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;


/**
 * JUnit testing are to assert that basic function are correctly returned. I.e. Sum of all value / 2 = half
 * @author hayoong
 *
 */
public class MyGuideUtilTest {
    @Test
    public void oneEqualsTwoTest() {
        assertNotEquals(1, 2);
    }
}
