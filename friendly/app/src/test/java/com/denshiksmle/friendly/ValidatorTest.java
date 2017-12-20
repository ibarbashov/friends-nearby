package com.denshiksmle.friendly;

import com.denshiksmle.friendly.model.utils.Validator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by troll on 10.12.2017.
 */

public class ValidatorTest {

    @Test
    public void testValidateEmail(){
        Validator validator = Validator.getInstance();
        boolean exp = true;
        assertEquals(exp, validator.validateEmail("example@email.com"));
    }

    @Test
    public void testValidatePassword(){
        Validator validator = Validator.getInstance();
        boolean exp = true;
        assertEquals(exp, validator.validatePassword("24081991ukr"));
    }

    @Test
    public void testValidatePhone(){
        Validator validator = Validator.getInstance();
        boolean exp = true;
        assertEquals(exp, validator.validatePhone("+380982986452"));
    }

    @Test
    public void testValidateName(){
        Validator validator = Validator.getInstance();
        boolean exp = true;
        assertEquals(exp, validator.validateName("Дмитро"));
    }
}
