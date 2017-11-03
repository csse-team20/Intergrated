/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lakshika
 */
public class lab_test_managementTest {
    
    
    @Test
    public void testAddLabTest() {
        System.out.println("addLabTest");
        String ttestCode = "";
        String ttestsName = "";
        String ttestType = "";
        String tdiscrption = "";
        String[] chemical = null;
        lab_test_management instance = new lab_test_management();
     //   instance.addLabTest(ttestCode, ttestsName, ttestType, tdiscrption, chemical);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLabTestChemecal method, of class lab_test_management.
     */
    @Test
    public void testAddLabTestChemecal() {
        System.out.println("addLabTestChemecal");
        String ttestCode = "";
        String[] chemical = null;
        lab_test_management instance = new lab_test_management();
        instance.addLabTestChemecal(ttestCode, chemical);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateLab method, of class lab_test_management.
     */
    @Test
    public void testUpdateLab() {
        System.out.println("updateLab");
        String ttestCode = "";
        String ttestsName = "";
        String ttestType = "";
        String tdiscrption = "";
        String[] chemicals = null;
        lab_test_management instance = new lab_test_management();
        instance.updateLab(ttestCode, ttestsName, ttestType, tdiscrption, chemicals);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateLabChemicals method, of class lab_test_management.
     */
    @Test
    public void testUpdateLabChemicals() throws Exception {
        System.out.println("updateLabChemicals");
        String ttestCode = "";
        String[] chemicals = null;
        lab_test_management instance = new lab_test_management();
        instance.updateLabChemicals(ttestCode, chemicals);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteLab method, of class lab_test_management.
     */
    @Test
    public void testDeleteLab() {
        System.out.println("deleteLab");
        String tlabCode = "";
        lab_test_management instance = new lab_test_management();
        instance.deleteLab(tlabCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
