/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.yura.domination.engine.core;

import junit.framework.TestCase;

/**
 *
 * @author jk_cu
 */
public class StatTypeTest extends TestCase {
    
    public StatTypeTest(String testName) {
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

    public void testValues() {
        assert(StatType.values().length == 14);
    }

    public void testValueOf() {
        StatType v = StatType.valueOf("DICE");
        assertEquals(v, StatType.DICE);
    }

    public void testIsSummable() {
        StatType v = StatType.valueOf("DICE");
        assertEquals(v.isSummable(), false);
        StatType v2 = StatType.valueOf("ATTACKS");
        assertEquals(v2.isSummable(), true);
    }

    public void testGetName() {
        StatType v = StatType.valueOf("DICE");
        assertEquals(v.getName(), "dice");
    }

    public void testFromOrdinal() {
        assert(StatType.fromOrdinal(0) == StatType.COUNTRIES);
        assert(StatType.fromOrdinal(1) == StatType.ARMIES);
        assert(StatType.fromOrdinal(2) == StatType.KILLS);
        assert(StatType.fromOrdinal(3) == StatType.CASUALTIES);
        assert(StatType.fromOrdinal(4) == StatType.REINFORCEMENTS);
        assert(StatType.fromOrdinal(5) == StatType.CONTINENTS);
        assert(StatType.fromOrdinal(6) == StatType.CONNECTED_EMPIRE);
        assert(StatType.fromOrdinal(7) == StatType.ATTACKS);
        assert(StatType.fromOrdinal(8) == StatType.RETREATS);
        assert(StatType.fromOrdinal(9) == StatType.COUNTRIES_WON);
        assert(StatType.fromOrdinal(10) == StatType.COUNTRIES_LOST);
        assert(StatType.fromOrdinal(11) == StatType.ATTACKED);
        assert(StatType.fromOrdinal(12) == StatType.CARDS);
        assert(StatType.fromOrdinal(13) == StatType.DICE);
    }
    
}
