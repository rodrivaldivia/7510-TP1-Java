package ar.uba.fi.tdd.rulogic.model;

public class Fact {

    public String stringFact;

    public Fact (String fact){
        this.stringFact = fact;
    }

    public boolean isEqual(String otherFact){
        return this.stringFact.equals(otherFact);
    }

    public boolean equals(Fact otherFact){
        return otherFact.isEqual(this.stringFact);
    }

    public static boolean isFact (String fact){
//        if (Rule.isRule(fact)){
//            return false;
//        }
        return fact.matches("\\w+\\(\\w+(, \\w+)*\\).");
    }
}
