package com.denshiksmle.friendly.model.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by troll on 10.12.2017.
 */

public class Validator {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_PASSWORD_REGEX = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$",
            Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_PHONE_REGEX = Pattern.compile("^(\\+\\d{1,2}\\s?)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{2}\\s?\\d{2}$");
    private static final Pattern VALID_NAME_REGEX = Pattern.compile("^[\\p{L} .'-]+$");

    public static Validator getInstance(){
        return new Validator();
    }

    public boolean validateEmail(String email){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public boolean validatePassword(String password){
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
        return matcher.find();
    }

    public boolean validatePhone(String phone){
        Matcher matcher = VALID_PHONE_REGEX.matcher(phone);
        return matcher.find();
    }

    public boolean validateName(String nameOrSurname){
        Matcher matcher = VALID_NAME_REGEX.matcher(nameOrSurname);
        return matcher.find();
    }
}
