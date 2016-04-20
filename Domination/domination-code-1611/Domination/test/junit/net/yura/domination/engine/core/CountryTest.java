/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.yura.domination.engine.core;

import java.util.List;
import java.util.Vector;
import junit.framework.TestCase;
import net.yura.domination.engine.ColorUtil;

/**
 *
 * @author Jason
 */
public class CountryTest extends TestCase {
    
    private Continent c1;
    private Continent c2;
    
    public CountryTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        c1 = new Continent("1", "Europe", 3, ColorUtil.BLACK);
        c2 = new Continent("2", "Asia", 3, ColorUtil.BLACK);
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGetIdString() {
        Country country1 = new Country(ColorUtil.PINK, "count1", "Germany", c1, 1,1);
        assertEquals(country1.getIdString(), "count1");
        Country country2 = new Country(ColorUtil.CYAN, "count2", "Japan", c2, 1,2);
        assertEquals(country2.getIdString(), "count2");
        assertEquals(country1.getIdString(), "count1");
    }

    public void testSetIdString() {
        Country country1 = new Country(ColorUtil.PINK, "count1", "Germany", c1, 1,1);
        assertEquals(country1.getIdString(), "count1");
        country1.setIdString("count2");
        assertEquals(country1.getIdString(), "count2");
    }

    public void testToString() {
        Country country1 = new Country(ColorUtil.PINK, "count1", "Germany", c1, 1,1);
        String expected = "count1 (" + ColorUtil.PINK + ")";
        assertEquals(country1.toString(), expected);
    }

    public void testIsNeighbours() {
        Country country1 = new Country(ColorUtil.PINK, "count1", "Germany", c1, 1,1);
        Country country2 = new Country(ColorUtil.PINK, "count2", "France", c1, 1,2);
        country1.addNeighbour(country2);
        assert(country1.isNeighbours(country2));
        assert(country2.isNeighbours(country1));
    }

    public void testGetNeighbours() {
        Country country1 = new Country(ColorUtil.PINK, "count1", "Germany", c1, 1,1);
        Country country2 = new Country(ColorUtil.PINK, "count2", "France", c1, 1,2);
        country1.addNeighbour(country2);
        assert(country1.getNeighbours().size() == 1);
        assert(country1.getNeighbours().get(0).equals(country2));
        assert(country2.getNeighbours().size() == 1);
        assert(country2.getNeighbours().get(0).equals(country1));
    }

    public void testGetCrossContinentNeighbours() {
        Country country1 = new Country(ColorUtil.PINK, "count1", "Germany", c1, 1,1);
        Country country2 = new Country(ColorUtil.PINK, "count2", "France", c1, 1,2);
        Country country3 = new Country(ColorUtil.PINK, "count3", "China", c2, 1,2);
        country1.addNeighbour(country2);
        country1.addNeighbour(country3);
        assert(country1.getCrossContinentNeighbours().size() == 1);
        assert(country1.getCrossContinentNeighbours().get(0).equals(country3));
        
    }

    public void testGetName() {
        Country country1 = new Country(ColorUtil.PINK, "count1", "Germany", c1, 1,1);
        Country country2 = new Country(ColorUtil.PINK, "count2", "France", c1, 1,2);
        assertEquals(country1.getName(), "Germany");
        assertEquals(country2.getName(), "France");
    }

    public void testSetName() {
        Country country1 = new Country(ColorUtil.PINK, "count1", "Germany", c1, 1,1);
        assertEquals(country1.getName(), "Germany");
        country1.setName("France");
        assertEquals(country1.getName(), "France");
    }

    public void testGetArmies() {
        Country country1 = new Country(ColorUtil.PINK, "count1", "Germany", c1, 1,1);
        country1.addArmies(5);
        assert(country1.getArmies() == 5);
    }

    public void testGetContinent() {
        Country country1 = new Country(ColorUtil.PINK, "count1", "Germany", c1, 1,1);
        assertEquals(country1.getContinent(), c1);
    }

    public void testSetContinent() {
        Country country1 = new Country(ColorUtil.PINK, "count1", "Germany", c1, 1,1);
        assertEquals(country1.getContinent(), c1);
        country1.setContinent(c2);
        assertEquals(country1.getContinent(), c2);
    }

    public void testAddNeighbour() {
        Country country1 = new Country(ColorUtil.PINK, "count1", "Germany", c1, 1,1);
        Country country2 = new Country(ColorUtil.PINK, "count2", "France", c1, 1,2);
        Country country3 = new Country(ColorUtil.PINK, "count3", "Finland", c1, 1,2);
        country1.addNeighbour(country2);
        assert(country1.getNeighbours().size() == 1);
        country1.addNeighbour(country3);
        assert(country1.getNeighbours().size() == 2);
        
        //Shouldn't be able to add self as neighbour
        country1.addNeighbour(country1);
        assert(country1.getNeighbours().size() == 2);
        
        //This method should add both ways
        assert(country2.getNeighbours().size() == 1);
        assert(country3.getNeighbours().size() == 1);
        
    }

    public void testGetIncomingNeighbours() {
        fail("Requires serialization/deserialization to test correctly. Ignoring for now.");
    }

    public void testSetOwner() {
        Country country1 = new Country(ColorUtil.PINK, "count2", "Germany", c1, 1,2);
        Player p1 = new Player(0, "John", ColorUtil.BLACK, "1"); //Human
        Player p2 = new Player(2, "Doe", ColorUtil.GREEN, "2"); //AI
        assert(country1.getOwner() == null);
        country1.setOwner(p1);
        assertEquals(country1.getOwner(), p1);
        country1.setOwner(p2);
        assertEquals(country1.getOwner(), p2);
    }

    public void testGetOwner() {
        Country country1 = new Country(ColorUtil.PINK, "count2", "Germany", c1, 1,2);
        Player p1 = new Player(0, "John", ColorUtil.BLACK, "1"); //Human
        Player p2 = new Player(2, "Doe", ColorUtil.GREEN, "2"); //AI
        assert(country1.getOwner() == null);
        country1.setOwner(p1);
        assertEquals(country1.getOwner(), p1);
        country1.setOwner(p2);
        assertEquals(country1.getOwner(), p2);
    }

    public void testAddArmy() {
        Country country1 = new Country(ColorUtil.PINK, "count2", "Germany", c1, 1,2);
        country1.addArmy();
        assert(country1.getArmies() == 1);
        country1.addArmy();
        assert(country1.getArmies() == 2);
    }

    public void testAddArmies() {
        Country country1 = new Country(ColorUtil.PINK, "count2", "Germany", c1, 1,2);
        country1.addArmies(5);
        assert(country1.getArmies() == 5);
        country1.addArmies(5);
        assert(country1.getArmies() == 10);
        country1.addArmies(0);
        assert(country1.getArmies() == 10);
        country1.addArmies(1);
        assert(country1.getArmies() == 11);
        
    }

    public void testRemoveArmies() {
        Country country1 = new Country(ColorUtil.PINK, "count2", "Germany", c1, 1,2);
        country1.addArmies(20);
        assert(country1.getArmies() == 20);
        country1.removeArmies(5);
        assert(country1.getArmies() == 15);
        country1.removeArmies(5);
        assert(country1.getArmies() == 10);
        country1.removeArmies(9);
        assert(country1.getArmies() == 1);
        country1.removeArmies(20);
        //Cannot have negative armnies
        assert(country1.getArmies() == 0); 
    }

    public void testLooseArmy() {
        Country country1 = new Country(ColorUtil.PINK, "count2", "Germany", c1, 1,2);
        country1.addArmies(3);
        assert(country1.getArmies() == 3);
        country1.looseArmy();
        assert(country1.getArmies() == 2);
        country1.looseArmy();
        assert(country1.getArmies() == 1);
        country1.looseArmy();
        assert(country1.getArmies() == 0);
        country1.looseArmy();
        assert(country1.getArmies() == 0);
    }

    public void testGetColor() {
        Country country1 = new Country(ColorUtil.PINK, "count2", "Germany", c1, 1,2);
        assertEquals(country1.getColor(), ColorUtil.PINK);
    }

    public void testSetColor() {
        Country country1 = new Country(ColorUtil.PINK, "count2", "Germany", c1, 1,2);
        assertEquals(country1.getColor(), ColorUtil.PINK);
        country1.setColor(ColorUtil.BLACK);
        assertEquals(country1.getColor(), ColorUtil.BLACK);
    }

    public void testGetX() {
        Country country1 = new Country(ColorUtil.PINK, "count2", "Germany", c1, 1,2);
        assert(country1.getX() == 1);
    }

    public void testGetY() {
        Country country1 = new Country(ColorUtil.PINK, "count2", "Germany", c1, 1,2);
        assert(country1.getY() == 2);
    }

    public void testSetX() {
        Country country1 = new Country(ColorUtil.PINK, "count2", "Germany", c1, 1,2);
        assert(country1.getX() == 1);
        country1.setX(3);
        assert(country1.getX() == 3);
    }

    public void testSetY() {
        Country country1 = new Country(ColorUtil.PINK, "count2", "Germany", c1, 1,2);
        assert(country1.getY() == 2);
        country1.setY(3);
        assert(country1.getY() == 3);
    }

    public void testGetDistanceTo() {
        int x = 2;
        int y = 2;
        
        //Euclidiean Distance
        Country country1 = new Country(ColorUtil.PINK, "count2", "Germany", c1, 1,1);
        int expected = (int)Math.sqrt(2);
        assert(country1.getDistanceTo(x, y) == expected);
    }
    
}
