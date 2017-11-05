package ar.uba.fi.tdd.rulogic.model;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.LinkedList;

public class RuleTest {

    @InjectMocks
    private KnowledgeBase knowledgeBase;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void test_isRule_correct_2args() {
        Assert.assertTrue(Rule.isRule("hijo(X, Y) :- varon(X), padre(Y, X)."));
    }

    @Test
    public void test_isRule_correct_1arg() {
        Assert.assertTrue(Rule.isRule("hijo(X, Y) :- varon(X)."));
    }

    @Test
    public void test_isQueryRule_correct() {
        Assert.assertTrue(Rule.isQueryRule("hijo(juan, fran)."));
    }

    @Test
    public void test_isRule_incomplete() {
        Assert.assertFalse(Rule.isRule("hijo(X, Y) :- varon(X"));
    }

    @Test
    public void test_isRule_incorrect() {
        Assert.assertFalse(Rule.isRule("hijo(X, Y) :- varon[X]"));
    }

    @Test
    public void test_isRule_withFact() {
        Assert.assertFalse(Rule.isRule("padre(juan, pepa)."));
    }

    @Test
    public void test_getFact() {
        Rule rule = new Rule("hijo(X, Y) :- varon(X).");
        String query = "hijo(marcelo, juan)";
        LinkedList<Fact> facts = rule.getFacts(query);
        Assert.assertTrue(facts.get(0).isEqual("varon(marcelo)."));
    }

    @Test
    public void test_getFacts() {
        Rule rule = new Rule("tio(X, Y, Z) :- varon(X), hermano(X, Z), padre(Z, Y).");
        String query = "tio(marcelo, juan, sanchez)";
        LinkedList<Fact> facts = rule.getFacts(query);
        Assert.assertTrue(facts.get(0).isEqual("varon(marcelo)."));
        Assert.assertTrue(facts.get(1).isEqual("hermano(marcelo, sanchez)."));
        Assert.assertTrue(facts.get(2).isEqual("padre(sanchez, juan)."));
    }
}
