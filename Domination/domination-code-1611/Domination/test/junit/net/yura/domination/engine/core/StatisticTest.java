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
public class StatisticTest extends TestCase {
    
    public StatisticTest(String testName) {
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

    public void testEndGoStatistics() {
        Statistic s = new Statistic();
        s.endGoStatistics(1, 2, 3, 4, 5);
        assert(s.get(StatType.COUNTRIES) == 1);
        assert(s.get(StatType.ARMIES) == 2);
        assert(s.get(StatType.CONTINENTS) == 3);
        assert(s.get(StatType.CONNECTED_EMPIRE) == 4);
        assert(s.get(StatType.CARDS) == 5);
    }

    public void testAddReinforcements() {
        Statistic s = new Statistic();
        assert(s.get(StatType.REINFORCEMENTS) == 0);
        s.addReinforcements(1);
        assert(s.get(StatType.REINFORCEMENTS) == 1);
    }

    public void testAddKill() {
        Statistic s = new Statistic();
        assert(s.get(StatType.KILLS) == 0);
        s.addKill();
        assert(s.get(StatType.KILLS) == 1);
    }

    public void testAddCasualty() {
        Statistic s = new Statistic();
        assert(s.get(StatType.CASUALTIES) == 0);
        s.addCasualty();
        assert(s.get(StatType.CASUALTIES) == 1);
    }

    public void testAddAttack() {
        Statistic s = new Statistic();
        assert(s.get(StatType.ATTACKS) == 0);
        s.addAttack();
        assert(s.get(StatType.ATTACKS) == 1);
    }

    public void testAddAttacked() {
        Statistic s = new Statistic();
        assert(s.get(StatType.ATTACKED) == 0);
        s.addAttacked();
        assert(s.get(StatType.ATTACKED) == 1);
    }

    public void testAddRetreat() {
        Statistic s = new Statistic();
        assert(s.get(StatType.RETREATS) == 0);
        s.addRetreat();
        assert(s.get(StatType.RETREATS) == 1);
    }

    public void testAddCountriesWon() {
        Statistic s = new Statistic();
        assert(s.get(StatType.COUNTRIES_WON) == 0);
        s.addCountriesWon();
        assert(s.get(StatType.COUNTRIES_WON) == 1);
    }

    public void testAddCountriesLost() {
        Statistic s = new Statistic();
        assert(s.get(StatType.COUNTRIES_LOST) == 0);
        s.addCountriesLost();
        assert(s.get(StatType.COUNTRIES_LOST) == 1);
    }

    public void testAddDice() {
        Statistic s = new Statistic();
        assert(s.get(StatType.DICE) == 0);
        s.addDice(5);
        assert(s.get(StatType.DICE) == 6);
        s.addDice(5);
        assert(s.get(StatType.DICE) == 6);
        s.addDice(2);
        assert(s.get(StatType.DICE) == 5);
        try{
            s.addDice(6);
            fail("Only positive integers from 0-5 allowed");
        } catch(Exception e){
            
        }
        try{
            s.addDice(-6);
            fail("Only positive integers from 0-5 allowed");
        } catch(Exception e){
            
        }
    }

    public void testGet() {
        Statistic s = new Statistic();
        s.endGoStatistics(1,2,3,4,5);
        s.addReinforcements(6);
        s.addKill();
        s.addCasualty();
        s.addAttack();
        s.addAttacked();
        s.addRetreat();
        s.addCountriesWon();
        s.addCountriesLost();
        s.addDice(5);
        assert(s.get(StatType.COUNTRIES) == 1);
        assert(s.get(StatType.ARMIES) == 2);
        assert(s.get(StatType.CONTINENTS) == 3);
        assert(s.get(StatType.CONNECTED_EMPIRE) == 4);
        assert(s.get(StatType.CARDS) == 5);
        assert(s.get(StatType.REINFORCEMENTS) == 6);
        assert(s.get(StatType.KILLS) == 1);
        assert(s.get(StatType.CASUALTIES) == 1);
        assert(s.get(StatType.ATTACKS) == 1);
        assert(s.get(StatType.ATTACKED) == 1);
        assert(s.get(StatType.RETREATS) == 1);
        assert(s.get(StatType.COUNTRIES_WON) == 1);
        assert(s.get(StatType.COUNTRIES_LOST) == 1);
        assert(s.get(StatType.DICE) == 6);
        
        
        
        
    }
    
}
