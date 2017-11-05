package ar.uba.fi.tdd.rulogic.model;

public class Fact {

    String stringFact;
    public Fact (String fact){
        this.stringFact = fact;
    }

    public boolean isEqual(String otherFact){
        return this.stringFact.equals(otherFact);
    }

    public static boolean isFact (String fact){
        return fact.matches("\\w+\\(\\w+(, \\w+)*\\).");
    }
}
