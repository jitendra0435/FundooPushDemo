package com.bridgelabz.junit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {

    public boolean validateFirstName(String firstName){
        String patternName="[A-Z][a-zA-Z]{2,}";
        Pattern pattern=Pattern.compile(patternName);
        Matcher matcher=pattern.matcher(firstName);
        return matcher.matches();
    }

    public boolean validateLastName(String lastName) {
        String patternName="[A-Z][a-zA-Z]{2,}";
        Pattern pattern=Pattern.compile(patternName);
        Matcher matcher=pattern.matcher(lastName);
        return matcher.matches();
    }

    public boolean validateEmail(String Email) {
        String patternName="^[0-9a-zA-Z]+[._+-]{0,1}[0-9a-zA-Z]+[@][0-9a-zA-Z]+[.][a-zA-Z]{2,3}([.][a-z]{2}){0,1}$";
        Pattern pattern=Pattern.compile(patternName);
        Matcher matcher=pattern.matcher(Email);
        return matcher.matches();
    }
}
