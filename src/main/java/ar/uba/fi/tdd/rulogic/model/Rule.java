package ar.uba.fi.tdd.rulogic.model;

public class Rule {

    String stringRule;
    public Rule (String rule){
        this.stringRule = rule;
    }

    public static boolean isRule(String rule){
//		return rule.matches("\\w+\\(\\w+(,\\ \\w+)*\\)\\ \\:\\-\\ (\\w+\\(\\w+(,\\ \\w+)*\\),\\ )*\\.");
        return rule.matches("\\w+\\(\\w+(, \\w+)*\\) :- (\\w+\\(\\w+(, \\w+)*\\), )*\\w+\\(\\w+(, \\w+)*\\).");
    }

}
