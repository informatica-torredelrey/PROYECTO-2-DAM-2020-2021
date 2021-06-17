/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author admin
 */
public class PatronEmail {
    private Pattern pattern;
    private Matcher matcher;
    
    private static final String PATRON_EMAIL = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    public PatronEmail(){
        pattern = Pattern.compile(PATRON_EMAIL);
    }
    
    public boolean validador(final String hex) {

        matcher = pattern.matcher(hex);
        return matcher.matches();

    }
    
}
