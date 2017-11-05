package ar.uba.fi.tdd.rulogic.model;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

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
}
