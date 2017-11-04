/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.validation;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class RememberValidation {

    public void checkRemEmpty(JTextField txtNic, JTextField txtAnswer) {

        String nic = txtNic.getText();
        String answer = txtAnswer.getText();
        if (nic.isEmpty()) {

            JOptionPane.showMessageDialog(txtAnswer, "Nic Should be Entered");

        }
        if (answer.isEmpty()) {

            JOptionPane.showMessageDialog(txtAnswer, "Answer Should be Entered");

        }

    }

}
