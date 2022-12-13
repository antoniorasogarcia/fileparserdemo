package com.fileparser.util;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileLine {

    private String id;
    private String documentType;
    private String countryCode;
    private String lastName;
    private String firstName;
    private String documentNumber;
    private String birthday;
    private String expireDate;
    private String nationality;
    public static  ArrayList <String> errorList;
    public static  ArrayList <String> correctList;

    public FileLine(String data){
        String[] attributes = data.split(",");
        if(attributes.length<8){
            throw new IllegalArgumentException("Invalid file line");
        }
        this.id = attributes[0];
        this.documentType = attributes[1];
        this.countryCode = attributes[2];
        this.lastName = attributes[3];
        this.firstName = attributes[4];
        this.documentNumber = attributes[5];
        this.nationality = attributes[6];
        this.birthday = attributes[7];
        this.expireDate = attributes[8];
        FileLine.errorList = new ArrayList<String>();
        FileLine.correctList = new ArrayList<String>();
    }
    public String getId() {
        return id;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate() {
        this.expireDate = expireDate;
    }

    public static ArrayList<String> getErrorList(){
        return errorList;
    }

    public void setErrorList(){
        this.errorList = errorList;
    }
    public static ArrayList<String> getCorrectList(){
        return errorList;
    }

    public void setCorrectList(){
        this.errorList = errorList;
    }
}
