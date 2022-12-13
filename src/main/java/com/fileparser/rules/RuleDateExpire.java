package com.fileparser.rules;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import com.fileparser.util.FileLine;
 
@Rule(name = "dateValidation", description = "Validates that the data is not expired")
public class RuleDateExpire {
    
    @Condition
    public boolean isValidateData(@Fact("person") FileLine expiryDate) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        LocalDate isCorrectDate = LocalDate.parse(expiryDate.getExpireDate(), formatter);
        return (!isCorrectDate.isAfter(today));
    }
 
    @Action
    public void deniedAccess(@Fact("person") FileLine expiryDate) {
        FileLine.errorList.add(expiryDate.getId() + ", expired \n");
    }
}