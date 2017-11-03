/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lakshika
 */
public class chemical_managementTest {
    
    @Test
    public void testAddChemical() {
        System.out.println("addChemical");
        String tchemCode = "";
        String tchemName = "";
        String ttype = "";
        String tqty = "";
        String supId = "";
        chemical_management instance = new chemical_management();
        instance.addChemical(tchemCode, tchemName, ttype, tqty, supId);
        
        TestData td = new TestData();
        //td.drugData();
    }

    /**
     * Test of updateChemical method, of class chemical_management.
     */
    @Test
    public void testUpdateChemical() {
        System.out.println("updateChemical");
        String tchemCode = "";
        String tchemName = "";
        String ttype = "";
        String tqty = "";
        String supId = "";
        chemical_management instance = new chemical_management();
        instance.updateChemical(tchemCode, tchemName, ttype, tqty, supId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteChemical method, of class chemical_management.
     */
    @Test
    public void testDeleteChemical() {
        System.out.println("deleteChemical");
        String chemCode = "";
        chemical_management instance = new chemical_management();
        instance.deleteChemical(chemCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
