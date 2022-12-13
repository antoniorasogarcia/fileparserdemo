package com.fileparser.rules;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.fileparser.util.FileLine;
 
@Rule(name = "documentValidation", description = "Validates that the document is valid")
//We are going to check the document number, issuing country and document type are the same.
public class RuleDocumentNumber {
    private static Logger log = Logger.getLogger(RuleDocumentNumber.class.getName());
 
    @Condition
    public boolean isSameDocument(@Fact("person") FileLine document) {
        String docNum = document.getDocumentNumber();
        String country = document.getCountryCode();
        String typeOfDoc = document.getDocumentType();
        return (docNum == country);
    }
 
    @Action
    public void allowAccess(@Fact("person") FileLine document) {        
        log.log(Level.INFO, String.format("Allow access to the person %s", document));
    }
}