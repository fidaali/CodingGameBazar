/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import skynetMedium.SkyNet;

/**
 *
 * @author Jahan
 */
public class PathCalc {
    
    public PathCalc() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void helloGraph() {
        skynetMedium.SkyNet.Input.GameInput in=new skynetMedium.SkyNet.Input.GameInput(4,4,1);
        in.addLinkDescr(1,2);
        //in.addLinkDescr(0, 2);
        in.addLinkDescr(1, 0);
        //in.addLinkDescr(2, 3);
        in.addGateWay(2);
        in.setAgent(1);
        
        List<SkyNet.Input.PathToGate> path=in.pathToGates();
        for(SkyNet.Input.PathToGate ptg : path){
            System.err.println("= "+ptg);
        }
    }
}
