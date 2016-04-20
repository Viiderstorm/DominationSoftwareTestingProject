/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.yura.domination.engine;

import junit.framework.TestCase;
import net.yura.domination.engine.core.RiskGame;

/**
 *
 * @author Scott
 */
public class RiskControllerTest extends TestCase {
    // Dummy class with virtual methods so we don't have to override everything
    public class vListener implements RiskListener {
        public void sendMessage(String output, boolean redrawNeeded, boolean repaintNeeded) {
        }

        public void needInput(int s) {
        }

        public void noInput() {
        }

        public void setGameStatus(String state) {
        }

        public void newGame(boolean t) {
        }

        public void startGame(boolean localGame) {
        }

        public void closeGame() {
        }

        public void showMapPic(RiskGame p) {
        }

        public void showCardsFile(String c, boolean hasMission) {
        }

        public void serverState(boolean s) {
        }

        public void openBattle(int c1num, int c2num) {
        }

        public void closeBattle() {
        }

        public void addPlayer(int type, String name, int color, String ip) {
        }

        public void delPlayer(String name) {
        }

        public void showDiceResults(int[] att, int[] def) {
        }

        public void setNODAttacker(int n) {
        }

        public void setNODDefender(int n) {
        }

        public void sendDebug(String a) {
        }

        public void showMessageDialog(String a) {
        }

    }
    
    public void testAddListener() {
        RiskController rc = new RiskController(); 
        
        assertEquals(rc.countListeners(), 0);
        
        try {
            rc.addListener(null);
            fail("Expected exception");
        } catch (NullPointerException e)
        {}
        
        assertEquals(rc.countListeners(), 0);
        
        RiskListener rl = new vListener();
        
        rc.addListener(rl);
        
        assertEquals(rc.countListeners(), 1);
        
        rc.addListener(rl);
        
        assertEquals(rc.countListeners(), 1);
    }
    
    public void testCountListeners() {
        RiskController rc = new RiskController();
        assertEquals(rc.countListeners(), 0);
        rc.addListener(new vListener());
        assertEquals(rc.countListeners(), 1);
    }
    
    public void testDeleteListener() {
        RiskController rc = new RiskController();               
        RiskListener rl = new vListener();
        rc.addListener(rl);
        
        assertEquals(rc.countListeners(), 1);
        
        rc.deleteListener(null);
        
        assertEquals(rc.countListeners(), 1);
        
        rc.deleteListener(rl);
        
        assertEquals(rc.countListeners(), 0);
    }
    
    public class sml extends vListener {
        public String _o;
        public boolean _d, _p;
        public void sendMessage(String output, boolean redrawNeeded, boolean repaintNeeded) {
            _o = output;
            _d = redrawNeeded;
            _p = repaintNeeded;
        }        
    }
    public void testSendMessage() {
        RiskController rc = new RiskController();
             
        sml rl = new sml();
        
        rc.addListener(rl);
        
        rc.sendMessage("hi", true, false);
        
        assertEquals(rl._o, "hi");
        assertTrue(rl._d);
        assertFalse(rl._p);
    }
    
    public class inputL extends vListener {
        public int _s, _c;
        public void needInput(int s) {
            _s = s;
        }
        public void noInput() {
            _c++;
        }
    }
    public void testNeedInput() {
        RiskController rc = new RiskController();
        
        inputL i = new inputL();
        
        rc.addListener(i);
        
        rc.needInput(7);
        
        assertEquals(i._s, 7);
    }
    
    public void testNoInput() {
        RiskController rc = new RiskController();
        
        inputL i = new inputL();
        
        rc.addListener(i);
        
        rc.noInput();
        
        assertEquals(i._c, 1);
    }
    
    public class gsListener extends vListener {
        public String _s;
        public void setGameStatus(String s) {
            _s = s;
        }
    }
    public void testSetGameStatus() {
        RiskController rc = new RiskController();
        
        gsListener i = new gsListener();
        
        rc.addListener(i);
        
        rc.setGameStatus("test");
        
        assertEquals(i._s, "test");
    }
    
    public class newGameListener extends vListener {
        public boolean _t;
        public void newGame(boolean t) {
            _t = t;
        }
    }
    public void testNewGame() {
        RiskController rc = new RiskController();
        
        newGameListener i = new newGameListener();
        
        rc.addListener(i);
        
        rc.newGame(true);
        
        assertTrue(i._t);
    }

    public class startGameListener extends vListener {
        public boolean _t;
        public void startGame(boolean t) {
            _t = t;
        }
    }
    public void testStartGame() {
        RiskController rc = new RiskController();
        
        startGameListener i = new startGameListener();
        
        rc.addListener(i);
        
        rc.startGame(true);
        
        assertTrue(i._t);
    }
    
    public class closeGameListener extends vListener {
        public int _c;
        public void closeGame() {
            _c++;
        }
    }
    public void testCloseGame() {
        RiskController rc = new RiskController();
        
        closeGameListener i = new closeGameListener();
        
        rc.addListener(i);
        
        rc.closeGame();
        
        assertEquals(i._c, 1);
    }

}

