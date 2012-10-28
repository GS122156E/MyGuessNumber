package com.shijian;

import org.junit.Test;
import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: STU
 * Date: 12-10-28
 * Time: 下午3:47
 * To change this template use File | Settings | File Templates.
 */
public class TestNumberCompare {

    MainNumberCompare mnc = new MainNumberCompare();

    @Test
    public void testCompareNumber()
    {
        mnc.setFourNumber("9012");
        String result = mnc.compareNumber("9012");
        assertEquals("4A0B",result);
    }

    @Test
    public void testRandomNumber()
    {
         String rnum = mnc.randomFourNumber();
        assertTrue(mnc.isNumber(rnum));
    }

    @Test
    public void testIsNumberTrue()
    {
        assertTrue(mnc.isNumber("9012"));
    }

    @Test
    public void testIsNumberFalse()
    {
        assertFalse(mnc.isNumber("9022"));
        assertFalse(mnc.isNumber("902q2"));
        assertFalse(mnc.isNumber("902q"));
    }

}
