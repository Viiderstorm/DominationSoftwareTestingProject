/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.yura.domination.engine.core;

import junit.framework.TestCase;
import net.yura.domination.engine.ColorUtil;
import net.yura.domination.engine.Risk;

/**
 *
 * @author Jason
 */
public class MissionTest extends TestCase {
    
    private Continent n1;
    private Continent n2;
    private Continent n3;
    private Continent n4;
    
    private Player p1;
    private Player p2;
    
    public MissionTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        int HumanType = 0;
        int playerColor = ColorUtil.BLUE;
        String address = "stub address";
        String address2 = "stub address 2";
        p1 = new Player(HumanType, "Jason", playerColor, address);
        p2 = new Player(HumanType, "Jason", ColorUtil.DARK_GRAY, address2);
        n1 = new Continent("1","Africa", 5, ColorUtil.GREEN);
        n2 = new Continent("2","Asia", 5, ColorUtil.CYAN);
        n3 = new Continent("3","North America", 5, ColorUtil.RED);
        n4 = new Continent("4","South America", 5, ColorUtil.ORANGE);
        
        
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGetPlayer() {
        String description = "Capture 5 countries with a minimum of 5 armies on Stand By";
        Mission m = new Mission(p1, 5, 5, n1, n2, n3, description );
        Mission m2 = new Mission(p2, 3, 3, n1, n2, n3, description );
        assert(m.getPlayer() == p1);
        //Adding the second check validates that the classes are not static
        //this does happen sometimes
        assert(m2.getPlayer() == p2);
    }

    public void testGetNoofcountries() {
        String description = "Capture 5 countries with a minimum of 5 armies on Stand By";
        Mission m = new Mission(p1, 5, 5, n1, n2, n3, description );
        Mission m2 = new Mission(p2, 3, 3, n1, n2, n3, description );
        assert(m.getNoofcountries() == 5);
        assert(m2.getNoofcountries() == 3);
        
    }

    public void testGetNoofarmies() {
        String description = "Capture 5 countries with a minimum of 5 armies on Stand By";
        Mission m = new Mission(p1, 5, 5, n1, n2, n3, description );
        assert(m.getNoofarmies() == 5);
    }

    
    public void testGetContinent1() {
        String description = "Capture 5 countries with a minimum of 5 armies on Stand By";
        Mission m = new Mission(p1, 5, 5, n1, n2, n3, description );
        assert(m.getContinent1() == n1);
    }

    public void testGetContinent2() {
        String description = "Capture 5 countries with a minimum of 5 armies on Stand By";
        Mission m = new Mission(p1, 5, 5, n1, n2, n3, description );
        assert(m.getContinent2() == n2);
    }

    public void testGetContinent3() {
        String description = "Capture 5 countries with a minimum of 5 armies on Stand By";
        Mission m = new Mission(p1, 5, 5, n1, n2, n3, description );
        assert(m.getContinent3() == n3);
    }

    public void testGetDiscription() {
        String description = "Capture 5 countries with a minimum of 5 armies on Stand By";
        Mission m = new Mission(p1, 5, 5, n1, n2, n3, description );
        assert(m.getDiscription() == description);
    }

    public void testToString() {
        String description = "Capture 5 countries with a minimum of 5 armies on Stand By";
        Mission m = new Mission(p1, 5, 5, n1, n2, n3, description );
        assert(m.toString() == description);
        Mission m2 = new Mission(p1, 5,5,n1,n2,n3, "");
        assert(m.toString() == description);
        assertEquals(m2.toString(),"(Discription Missing)");        
    }

    public void testSetPlayer() {
        String description = "Capture 5 countries with a minimum of 5 armies on Stand By";
        Mission m = new Mission(p1, 5, 5, n1, n2, n3, description );
        assert(m.getPlayer() == p1);
        m.setPlayer(p2);
        assert(m.getPlayer() == p2);
        
    }

    public void testSetNoofcountries() {
        String description = "Capture 5 countries with a minimum of 5 armies on Stand By";
        Mission m = new Mission(p1, 5, 5, n1, n2, n3, description );
        assert(m.getNoofcountries() == 5);
        m.setNoofcountries(7);
        assert(m.getNoofcountries() == 7);
    }

    public void testSetNoofarmies() {
        String description = "Capture 5 countries with a minimum of 5 armies on Stand By";
        Mission m = new Mission(p1, 5, 5, n1, n2, n3, description );
        assert(m.getNoofarmies() == 5);
        m.setNoofarmies(7);
        assert(m.getNoofarmies() == 7);
    }

    public void testSetContinent1() {
        String description = "Capture 5 countries with a minimum of 5 armies on Stand By";
        Mission m = new Mission(p1, 5, 5, n1, n2, n3, description );
        assert(m.getContinent1() == n1);
        m.setContinent1(n4);
        assert(m.getContinent1() == n4);
    }

    public void testSetContinent2() {
        String description = "Capture 5 countries with a minimum of 5 armies on Stand By";
        Mission m = new Mission(p1, 5, 5, n1, n2, n3, description );
        assert(m.getContinent2() == n2);
        m.setContinent2(n4);
        assert(m.getContinent2() == n4);
    }

    public void testSetContinent3() {
        String description = "Capture 5 countries with a minimum of 5 armies on Stand By";
        Mission m = new Mission(p1, 5, 5, n1, n2, n3, description );
        assert(m.getContinent3() == n3);
        m.setContinent3(n4);
        assert(m.getContinent3() == n4);
    }

    public void testSetDiscription() {
        String description = "Capture 5 countries with a minimum of 5 armies on Stand By";
        String description2 = "Changed";
        Mission m = new Mission(p1, 5, 5, n1, n2, n3, description );
        assert(m.getDiscription() == description);
        m.setDiscription(description2);
        assert(m.getDiscription() == description2);
    }
    
}
