/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.yura.domination.engine;

import junit.framework.TestCase;

/**
 *
 * @author Jason
 */
public class ColorUtilTest extends TestCase {
    
    public ColorUtilTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testAdd() {
        int tmp = 0xFF05F5FF; //Baby Blue
        ColorUtil.add(tmp, "baby blue");
        
        assertEquals(ColorUtil.getStringForColor(tmp),"baby blue");
        assert(ColorUtil.getColor("baby blue") == tmp);
    }

    public void testGetStringForColor() {
        int tmp = 0xFF05F5FF; //Baby Blue
        int tmp2 = 0xFFFFAAFF; //Cloud Pink
        ColorUtil.add(tmp, "baby blue");
        
        assertEquals(ColorUtil.getStringForColor(tmp),"baby blue");
        ColorUtil.add(tmp2, "cloud pink");
        assertEquals(ColorUtil.getStringForColor(tmp),"baby blue");
        assertEquals(ColorUtil.getStringForColor(tmp2),"cloud pink");
        tmp = 0x00000000;
        ColorUtil.add(tmp, "baby blue");
        assertEquals(ColorUtil.getStringForColor(tmp), "baby blue");
    }

    public void testGetColor() {
        int tmp = 0xFF05F5FF; //Baby Blue
        int tmp2 = 0xFFFFAAFF; //Cloud Pink
        ColorUtil.add(tmp, "baby blue");
        
        assert(ColorUtil.getColor("baby blue") == tmp);
        ColorUtil.add(tmp2, "cloud pink");
        assert(ColorUtil.getColor("baby blue") == tmp);
        assert(ColorUtil.getColor("cloud pink") == tmp2);
        tmp = 0x00000000;
        ColorUtil.add(tmp, "baby blue");
        assert(ColorUtil.getColor("baby blue") == tmp);
    }

    /*
        Get the color of text that should be overlayed ontop of the color
    */
    public void testGetTextColorFor() {
        int tmp = 0xFFFF0000; //Baby Blue
        int tmp2 = 0xFF00FF00; //Cloud Pink
        int tmp6 = 0xFFFFFF00;
        int tmp3 = 0xFF970000; //Cloud Pink
        int tmp4 = 0xFF009700; //Cloud Pink
        int tmp5 = 0xFF979700;
        int tmp7 = 0xFF0000FF;
        assert(ColorUtil.getTextColorFor(tmp) == ColorUtil.BLACK );
        assert(ColorUtil.getTextColorFor(tmp2) == ColorUtil.BLACK );
        assert(ColorUtil.getTextColorFor(tmp3) == ColorUtil.WHITE );
        assert(ColorUtil.getTextColorFor(tmp4) == ColorUtil.WHITE );
        assert(ColorUtil.getTextColorFor(tmp5) == ColorUtil.BLACK );
        assert(ColorUtil.getTextColorFor(tmp6) == ColorUtil.BLACK );
        assert(ColorUtil.getTextColorFor(tmp7) == ColorUtil.WHITE );
    }

    public void testGetRed() {
        int color = 0xFF110000;
        int expected = 0x00000011;
        assert(ColorUtil.getRed(color) == expected);
    }

    public void testGetGreen() {
        int color = 0xFF001100;
        int expected = 0x00000011;
        assert(ColorUtil.getGreen(color) == expected);
    }

    public void testGetBlue() {
        int color = 0xFF000011;
        int expected = 0x00000011;
        assert(ColorUtil.getBlue(color) == expected);
    }

    public void testGetAlpha() {
        int color = 0xFF000011;
        int expected = 0x000000FF;
        assert(ColorUtil.getAlpha(color) == expected);
    }

    public void testGetHexForColor() {
        int color = 0xFF000011;
        String expected = "#FF000011";
        assertEquals(ColorUtil.getHexForColor(color), expected);
    }
    
}
