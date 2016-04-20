/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.yura.domination.engine.core;

import java.util.Vector;
import junit.framework.TestCase;
import net.yura.domination.engine.ColorUtil;

/**
 *
 * @author Jason
 */
public class ContinentTest extends TestCase {
    
    Player p1;
    Player p2;
    
    public ContinentTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        int HumanType = 0;
        p1 = new Player(HumanType, "John", ColorUtil.BLACK, "1");
        p2 = new Player(HumanType, "Doe", ColorUtil.GREEN, "2");
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testToString() {
        String id = "1";
        String expectedId = "1 [3]";
        String name = "Africa";
        Continent c = new Continent(id, name, 3, ColorUtil.BLACK);
        Continent c1 = new Continent(id, name, 0, ColorUtil.BLACK);
        assertEquals(c.toString(), expectedId);
        assertEquals(c1.toString(),id);
    }

    public void testGetIdString() {
        String id = "1";
        String name = "Africa";
        Continent c = new Continent(id, name, 3, ColorUtil.BLACK);
        assertEquals(c.getIdString(), id);
    }

    public void testSetIdString() {
        String id = "1";
        String name = "Africa";
        Continent c = new Continent(id, name, 3, ColorUtil.BLACK);
        assertEquals(c.getIdString(), id);
        c.setIdString("2");
        assertEquals(c.getIdString(), "2");
    }

    public void testGetName() {
        String id = "1";
        String name = "Africa";
        Continent c = new Continent(id, name, 3, ColorUtil.BLACK);
        assertEquals(c.getName(), name);
    }

    public void testSetName() {
        String id = "1";
        String name = "Africa";
        Continent c = new Continent(id, name, 3, ColorUtil.BLACK);
        assertEquals(c.getName(), name);
        c.setName("North America");
        assertEquals(c.getName(), "North America");
    }

    public void testGetColor() {
        String id = "1";
        String name = "Africa";
        Continent c = new Continent(id, name, 3, ColorUtil.BLACK);
        assert(c.getColor() == ColorUtil.BLACK);
    }

    public void testSetColor() {
        String id = "1";
        String name = "Africa";
        Continent c = new Continent(id, name, 3, ColorUtil.BLACK);
        assert(c.getColor() == ColorUtil.BLACK);
        c.setColor(ColorUtil.PINK);
        assert(c.getColor() == ColorUtil.PINK);
    }

    public void testGetArmyValue() {
        String id = "1";
        String name = "Africa";
        Continent c = new Continent(id, name, 3, ColorUtil.BLACK);
        assert(c.getArmyValue() == 3);
    }

    public void testSetArmyValue() {
        String id = "1";
        String name = "Africa";
        Continent c = new Continent(id, name, 3, ColorUtil.BLACK);
        assert(c.getArmyValue() == 3);
        c.setArmyValue(5);
        assert(c.getArmyValue() == 5);
    }

    public void testIsOwned() {
        String id = "1";
        String name = "Africa";
        Continent c = new Continent(id, name, 3, ColorUtil.BLACK);
        
        Country cn1 = new Country(ColorUtil.BLACK, "cn1", "Germany", c, 1, 1);
        Country cn2 = new Country(ColorUtil.PINK, "cn2", "France", c, 1, 2);
        Country cn3 = new Country(ColorUtil.ORANGE, "cn3", "Sweden", c, 1, 3);
        
        cn1.setOwner(p1);
        cn2.setOwner(p1);
        cn3.setOwner(p1);
        
        c.addTerritoriesContained(cn1);
        c.addTerritoriesContained(cn2);
        c.addTerritoriesContained(cn3);
        
        assert(c.isOwned(p1));
        assert(!c.isOwned(p2));
        
    }

    public void testGetNumberOwned() {
        String id = "1";
        String name = "Africa";
        Continent c = new Continent(id, name, 3, ColorUtil.BLACK);
        
        Country cn1 = new Country(ColorUtil.BLACK, "cn1", "Germany", c, 1, 1);
        Country cn2 = new Country(ColorUtil.PINK, "cn2", "France", c, 1, 2);
        Country cn3 = new Country(ColorUtil.ORANGE, "cn3", "Sweden", c, 1, 3);
        
        cn1.setOwner(p1);
        cn2.setOwner(p1);
        cn3.setOwner(p2);
        
        c.addTerritoriesContained(cn1);
        c.addTerritoriesContained(cn2);
        c.addTerritoriesContained(cn3);
        
        assert(c.getNumberOwned(p1) == 2);
        assert(c.getNumberOwned(p2) == 1);
        
    }

    public void testGetOwner() {
        String id = "1";
        String name = "Africa";
        Continent c = new Continent(id, name, 3, ColorUtil.BLACK);
        
        Country cn1 = new Country(ColorUtil.BLACK, "cn1", "Germany", c, 1, 1);
        Country cn2 = new Country(ColorUtil.PINK, "cn2", "France", c, 1, 2);
        Country cn3 = new Country(ColorUtil.ORANGE, "cn3", "Sweden", c, 1, 3);
        
        cn1.setOwner(p1);
        cn2.setOwner(p1);
        cn3.setOwner(p2);
        
        c.addTerritoriesContained(cn1);
        c.addTerritoriesContained(cn2);
        c.addTerritoriesContained(cn3);
        
        assert(c.getOwner() == null);
        cn3.setOwner(p1);
        assert(c.getOwner() == p1);
        
    }

    public void testGetBorderCountries() {
        Continent c1 = new Continent("1", "Europe", 3, ColorUtil.BLACK);
        Continent c2 = new Continent("2", "Asia", 3, ColorUtil.BLACK);
        
        Country cn1 = new Country(ColorUtil.BLACK, "cn1", "Germany", c1, 1, 1);
        Country cn2 = new Country(ColorUtil.PINK, "cn2", "France", c1, 1, 2);
        Country cn3 = new Country(ColorUtil.ORANGE, "cn3", "Sweden", c1, 1, 3);
        Country cn4 = new Country(ColorUtil.BLACK, "cn4", "Finland", c1, 1, 4);
        Country cn5 = new Country(ColorUtil.PINK, "cn5", "Russia", c1, 1, 5);
        Country cn6 = new Country(ColorUtil.ORANGE, "cn6", "Denmark", c1, 1, 6);
        Country cn7 = new Country(ColorUtil.GRAY, "cn7", "China", c2, 1, 7);
        Country cn8 = new Country(ColorUtil.RED, "cn7", "Thailand", c2, 1, 8);
        
        cn1.addNeighbour(cn6); // Germany -> Denmark
        cn1.addNeighbour(cn2); // Germany -> France
        cn2.addNeighbour(cn1); // France -> Germany
        cn6.addNeighbour(cn1); // Denmark -> Germany
        cn6.addNeighbour(cn3); // Denmark -> Sweden
        cn3.addNeighbour(cn6); // Sweden -> Denmark
        cn3.addNeighbour(cn4); // Sweden -> Finland
        cn4.addNeighbour(cn3); // Finland -> Sweden
        cn4.addNeighbour(cn5); // Finland -> Russia
        cn5.addNeighbour(cn4); // Russia -> Finland
        cn5.addNeighbour(cn7); // Russia -> China
        cn7.addNeighbour(cn7); // China -> Russia
        
        c1.addTerritoriesContained(cn1);
        c1.addTerritoriesContained(cn2);
        c1.addTerritoriesContained(cn3);
        c1.addTerritoriesContained(cn4);
        c1.addTerritoriesContained(cn5);
        c1.addTerritoriesContained(cn6);
        c2.addTerritoriesContained(cn7);
        c2.addTerritoriesContained(cn8);
        
        //Border Country between Europe and Asia should be Russia / China
        // depending on the continent the method is called for
        assert(c1.getBorderCountries().get(0).equals(cn5));
        assert(c2.getBorderCountries().get(0).equals(cn7));
        
    }

    public void testGetTerritoriesContained() {
        Continent c1 = new Continent("1", "Europe", 3, ColorUtil.BLACK);
        Country cn1 = new Country(ColorUtil.BLACK, "cn1", "Germany", c1, 1, 1);
        Country cn2 = new Country(ColorUtil.PINK, "cn2", "France", c1, 1, 2);
        Country cn3 = new Country(ColorUtil.ORANGE, "cn3", "Sweden", c1, 1, 3);
        Country cn4 = new Country(ColorUtil.BLACK, "cn4", "Finland", c1, 1, 4);
        Country cn5 = new Country(ColorUtil.PINK, "cn5", "Russia", c1, 1, 5);
        Country cn6 = new Country(ColorUtil.ORANGE, "cn6", "Denmark", c1, 1, 6);
        c1.addTerritoriesContained(cn1);
        c1.addTerritoriesContained(cn2);
        c1.addTerritoriesContained(cn3);
        c1.addTerritoriesContained(cn4);
        c1.addTerritoriesContained(cn5);
        c1.addTerritoriesContained(cn6);
        Vector<Country> v = new Vector<Country>();
        v.add(cn1);
        v.add(cn2);
        v.add(cn3);
        v.add(cn4);
        v.add(cn5);
        v.add(cn6);
        
        Vector<Country> v2 = c1.getTerritoriesContained();
        assert(v.size() == v2.size());
        for(int i = 0 ; i < v.size(); i++){
            assert(v.get(i).equals(v2.get(i)));
        }
    }

    /*
        Everytime this method runs, it should clear the current computed border countries
        because they could have changed with the new country.
    */
    public void testAddTerritoriesContained() {
        Continent c1 = new Continent("1", "Europe", 3, ColorUtil.BLACK);
        Continent c2 = new Continent("2", "Asia", 3, ColorUtil.BLACK);
        
        Country cn1 = new Country(ColorUtil.BLACK, "cn1", "Germany", c1, 1, 1);
        Country cn2 = new Country(ColorUtil.PINK, "cn2", "France", c1, 1, 2);
        Country cn3 = new Country(ColorUtil.ORANGE, "cn3", "Sweden", c1, 1, 3);
        Country cn4 = new Country(ColorUtil.BLACK, "cn4", "Finland", c1, 1, 4);
        Country cn5 = new Country(ColorUtil.PINK, "cn5", "Russia", c1, 1, 5);
        Country cn6 = new Country(ColorUtil.ORANGE, "cn6", "Denmark", c1, 1, 6);
        Country cn7 = new Country(ColorUtil.GRAY, "cn7", "China", c2, 1, 7);
        Country cn8 = new Country(ColorUtil.RED, "cn7", "Mongolia", c2, 1, 8);
        
        cn1.addNeighbour(cn6); // Germany -> Denmark
        cn1.addNeighbour(cn2); // Germany -> France
        cn2.addNeighbour(cn1); // France -> Germany
        cn6.addNeighbour(cn1); // Denmark -> Germany
        cn6.addNeighbour(cn3); // Denmark -> Sweden
        cn3.addNeighbour(cn6); // Sweden -> Denmark
        cn3.addNeighbour(cn4); // Sweden -> Finland
        cn4.addNeighbour(cn3); // Finland -> Sweden
        cn4.addNeighbour(cn5); // Finland -> Russia
        cn5.addNeighbour(cn4); // Russia -> Finland
        cn5.addNeighbour(cn7); // Russia -> China
        cn7.addNeighbour(cn7); // China -> Russia

        c1.addTerritoriesContained(cn1);
        c1.addTerritoriesContained(cn2);
        c1.addTerritoriesContained(cn3);
        c1.addTerritoriesContained(cn4);
        c1.addTerritoriesContained(cn5);
        c1.addTerritoriesContained(cn6);
        c2.addTerritoriesContained(cn7);

        //Russia should be the border country
        assertEquals(cn5, c1.getBorderCountries().get(0));
        //China should be the border country
        assertEquals(cn7, c2.getBorderCountries().get(0));

        //Add a new country: Mongolia
        cn8.addNeighbour(cn5); // Mongolia-> Russia
        cn8.addNeighbour(cn7); // Mongolia-> China
        cn7.addNeighbour(cn8); // China -> Mongolia
        cn5.addNeighbour(cn8); // Russia -> Mongolia
        c2.addTerritoriesContained(cn8);
        
        //Russia is still the only border country from Europe to Asia
        assertEquals(cn5, c1.getBorderCountries().get(0));
        //There should now be two bordering countries from Asia to Europe
        assert(c2.getBorderCountries().size() == 2);
        
    }

    public void testEquals() {
        Continent c1 = new Continent("1", "Europe", 3, ColorUtil.BLACK);
        Continent c2 = new Continent("2", "Asia", 3, ColorUtil.BLACK);
        Continent c3 = new Continent("2", "Asia", 3, ColorUtil.MAGENTA);
        Continent c4 = new Continent("1", "Europe", 3, ColorUtil.BLACK);
        Country cn1 = new Country(ColorUtil.BLACK, "cn1", "Germany", c1, 1, 1);
        
        assert(!c1.equals(c2));
        assert(c2.equals(c3)); //Color shouldn't matter
        assert(c1.equals(c1));
        assert(c1.equals(c4)); //Equivalent to different instance
        assert(!c1.equals(cn1)); //Not equivalent to something that's not a Continent
    }
    
}
