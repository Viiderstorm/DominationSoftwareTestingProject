/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.yura.domination.engine.core;

import junit.framework.TestCase;
import net.yura.domination.engine.ColorUtil;

/**
 *
 * @author Jason
 */
public class CardTest extends TestCase {
    
    public CardTest(String testName) {
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

    public void testGetName() {
        Continent c1 = new Continent("1", "Europe", 3, ColorUtil.BLACK);
        Country cn1 = new Country(ColorUtil.BLACK, "cn1", "Germany", c1, 1, 1);
        Card c = new Card(Card.CAVALRY, cn1 );
        assertEquals(c.getName(),Card.CAVALRY);
    }

    public void testSetName() {
        Continent c1 = new Continent("1", "Europe", 3, ColorUtil.BLACK);
        Country cn1 = new Country(ColorUtil.BLACK, "cn1", "Germany", c1, 1, 1);
        Card c = new Card(Card.CAVALRY, cn1 );
        assertEquals(c.getName(),Card.CAVALRY);
        c.setName(Card.INFANTRY);
        assertEquals(c.getName(), Card.INFANTRY);
        c.setName(Card.CANNON);
        assertEquals(c.getName(), Card.CANNON);
        c.setName(Card.WILDCARD);
        assertEquals(c.getName(), Card.WILDCARD);
        try{
            c.setName("Kill all players");   
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e){
            
        }
    }

    public void testGetCountry() {
        Continent c1 = new Continent("1", "Europe", 3, ColorUtil.BLACK);
        Country cn1 = new Country(ColorUtil.BLACK, "cn1", "Germany", c1, 1, 1);
        Card c = new Card("Cavalry", cn1 );
        assert(c.getCountry().equals(cn1));
    }

    public void testSetCountry() {
        Continent c1 = new Continent("1", "Europe", 3, ColorUtil.BLACK);
        Country cn1 = new Country(ColorUtil.BLACK, "cn1", "Germany", c1, 1, 1);
        Country cn2 = new Country(ColorUtil.PINK, "cn2", "France", c1, 1, 2);
        Card c = new Card("Cavalry", cn1 );
        assert(c.getCountry().equals(cn1));
        c.setCountry(cn2);
        assert(c.getCountry().equals(cn2));
    }

    public void testToString() {
        Continent c1 = new Continent("1", "Europe", 3, ColorUtil.BLACK);
        Country cn1 = new Country(ColorUtil.BLACK, "cn1", "Germany", c1, 1, 1);
        Country cn2 = new Country(ColorUtil.PINK, "cn2", "France", c1, 1, 2);
        Card c = new Card("Cavalry", cn1 );
        assertEquals(c.toString(),"Cavalry - " + cn1);
        c.setCountry(cn2);
        assertEquals(c.toString(),"Cavalry - " + cn2);
        c.setCountry(null);
        assertEquals(c.toString(),"Cavalry");
    }
    
}
