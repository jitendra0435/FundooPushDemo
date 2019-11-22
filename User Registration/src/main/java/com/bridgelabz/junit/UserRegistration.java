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
}
