package ar.uba.fi.tdd.rulogic.model;

import java.util.LinkedList;
import java.util.List;

public class Rule {

    String stringRule;
    public Rule (String rule){
        this.stringRule = rule;
    }

    public static boolean isRule(String rule){
//		return rule.matches("\\w+\\(\\w+(,\\ \\w+)*\\)\\ \\:\\-\\ (\\w+\\(\\w+(,\\ \\w+)*\\),\\ )*\\.");
        return rule.matches("\\w+\\(\\w+(, \\w+)*\\) :- (\\w+\\(\\w+(, \\w+)*\\), )*\\w+\\(\\w+(, \\w+)*\\).");
    }

    public static String name(String rule){
        return rule.substring(0,rule.indexOf("("));
    }

    public String getName(){
        return this.name(this.stringRule);
    }

    private String[] getArguments(String rule){
        return rule.substring(rule.indexOf("(")+1,rule.indexOf(")")).split(", ");
    }

    public LinkedList<Fact> getFacts(String rule){
        LinkedList <Fact> factsList = new LinkedList<Fact>();
        String[] queryArguments = getArguments(rule);
        String[] ruleArguments = getArguments(this.stringRule);
        String ruleWithArguments = this.stringRule;
        for(int i=0 ; i<ruleArguments.length ; i++){
            ruleWithArguments = ruleWithArguments.replaceAll(ruleArguments[i],queryArguments[i]);
            System.out.println(ruleWithArguments);
        }

        return factsList;
    }

}
