package ar.uba.fi.tdd.rulogic.model;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class FactTest {

    @InjectMocks
    private KnowledgeBase knowledgeBase;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void test_isFact_correct_2args() {
        Assert.assertTrue(Fact.isFact("hermano(roberto, nicolas)."));
    }

    @Test
    public void test_isFact_correct_1arg() {
        Assert.assertTrue(Fact.isFact("mujer(cecilia)."));
    }

    @Test
    public void test_isFact_withRule() {
        Assert.assertFalse(Fact.isFact("tio(X, Y, Z) :- varon(X), hermano(X, Z), padre(Z, Y)."));
    }
}
