/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lakshika
 */
public class validation {

    public boolean dateValidation(java.util.Date dueDate) {
        boolean isValid = false;

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate now = LocalDate.now();
        String curDate[] = (dateFormat.format(now)).split("/");

        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String Date[] = (format.format(dueDate)).split("/");

        if (Integer.parseInt(Date[0]) == Integer.parseInt(curDate[0])) {

            if (Integer.parseInt(Date[1]) >= Integer.parseInt(curDate[1])) {

                if (Integer.parseInt(Date[2]) >= Integer.parseInt(curDate[2])) {

                    isValid = true;
                } else if (Integer.parseInt(Date[1]) > Integer.parseInt(curDate[1]) && Integer.parseInt(Date[2]) < Integer.parseInt(curDate[2])) {

                    isValid = true;
                } else if (Integer.parseInt(Date[0]) > Integer.parseInt(curDate[0]) && Integer.parseInt(Date[1]) > Integer.parseInt(curDate[1]) && Integer.parseInt(Date[2]) < Integer.parseInt(curDate[2])) {

                    isValid = true;
                }
            } else if (Integer.parseInt(Date[0]) > Integer.parseInt(curDate[0]) && Integer.parseInt(Date[1]) < Integer.parseInt(curDate[1])) {
                isValid = true;
            }
        } else if (Integer.parseInt(Date[0]) > Integer.parseInt(curDate[0])) {
            isValid = true;
        }

        return isValid;
    }
    
    public boolean isnumber(String s) {

        boolean isnumber = true;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!Character.isDigit(ch)) {
                isnumber = false;
                break;
            }
        }
        return isnumber;
    }
    
    public boolean priceOnly(String price){
    
        boolean valid=false;
        String expression="[0-9]+([,.][0-9]{1,2})?";
        CharSequence inputStr = price;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches()) {
            valid = true;
        }
        return valid;
    }

}
