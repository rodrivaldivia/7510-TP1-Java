package ar.uba.fi.tdd.rulogic.model;

import java.util.LinkedList;

public class Parser {

    String [] facts;

    public Parser(String content){
        this.facts = content.split("\\n");
    }


    public boolean parseDB (LinkedList<Fact> factList, LinkedList<Rule> ruleList){
        for (int i=0; i<facts.length; i++){
            if (Rule.isRule(facts[i])){
                ruleList.add(new Rule(facts[i]));
            }
            else{
                if(Fact.isFact(facts[i])){
                    factList.add(new Fact(facts[i]));
                }
                else{
                    return false;
                }
            }
        }
    return true;
    }
}
