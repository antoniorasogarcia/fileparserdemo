package com.fileparser.rules;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.fileparser.util.FileLine;
 
@Rule(name = "personValidation", description = "Validates that the person is not duplicated")
//We are going to check the first name, last name, nationality and date of birth are the same
public class RuleSamePerson {
    private static Logger log = Logger.getLogger(RuleDocumentNumber.class.getName());

    @Condition
    public boolean isDuplicatePerson(@Fact("person") FileLine person) {
        String name = person.getFirstName();
        String lastName = person.getLastName();
        String nationality = person.getNationality();
        return name.equals(lastName);
    }
 
    /**
     * @param person
     */

    @Action
    public void deniedAccess(@Fact("person") FileLine person) {
        log.log(Level.INFO, String.format("Allow access to the person %s", person));    }
}