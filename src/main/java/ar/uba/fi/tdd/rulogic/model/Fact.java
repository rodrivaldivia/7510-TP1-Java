package ar.uba.fi.tdd.rulogic.model;

public class Fact {

    String stringFact;
    public Fact (String fact){
        this.stringFact = fact;
    }

    public boolean isFact(String otherFact){
        return this.stringFact.equals(otherFact);
    }
}
