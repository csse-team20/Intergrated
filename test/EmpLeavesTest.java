/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import csse.EmpLeaves;
import static java.lang.Thread.sleep;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class EmpLeavesTest {

    EmpLeaves frame;
    JTextField inputText;
    String expectedResult;
    
    public EmpLeavesTest() {
        System.out.println("test EmployeeLeaves");
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        frame = new EmpLeaves();
        
    }

    @After
    public void tearDown() {
    
       frame.dispose();
       System.out.println("disposed");
    }

    @Test
    public void testInputJtextField() throws InterruptedException {
    
        inputText = new JTextField();
       
        frame.setVisible(true);

        Thread.sleep(5000);

        inputText.setText("1");

        sleep(5000);

        expectedResult = "1";
        sleep(5000);
        assertEquals(expectedResult, inputText.getText());
    }
    

}
