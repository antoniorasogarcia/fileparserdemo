package com.fileparser;
import java.net.URL;
import java.util.List;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

import com.fileparser.util.FileLine;
import com.fileparser.util.FileParserUtil;
import com.fileparser.rules.RuleDateExpire;
// import com.fileparser.rules.RuleDocumentNumber;
// import com.fileparser.rules.RuleSamePerson;

  
//Constantes en un array para comprobar los países válidos

public class App {
    static final String FILE_NAME = "textToParse.txt";
    /**
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        
        App app = new App(); 
        final URL resource =  app.getResourceURL();

        List<FileLine> lines = FileParserUtil.getFileLineList(resource);
        lines.forEach(System.out::println);
       
        for (FileLine line : lines) {
            Facts fact = new Facts();
            fact.put("person", line);
            RulesEngine rulesEngine = new DefaultRulesEngine();
            rulesEngine.fire(getRules(), fact);
        }

    }
    private URL getResourceURL(){
        return getClass().getClassLoader().getResource(FILE_NAME);
    }

    public static Rules getRules() {
        Rules rules = new Rules();
        rules.register(new RuleDateExpire());
        return rules;
    }

    // public static Rules createRules() {
    //     Rules rules = new Rules();
    //     rules.register(new RuleDateExpire());
    //     // rules.register(new RuleSamePerson());
    //     // rules.register(new RuleDocumentNumber());
    //     return rules;
    // }

}
