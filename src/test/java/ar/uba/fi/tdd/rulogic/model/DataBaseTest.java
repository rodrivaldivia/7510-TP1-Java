package ar.uba.fi.tdd.rulogic.model;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;


public class DataBaseTest {

    @InjectMocks
    private KnowledgeBase knowledgeBase;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        knowledgeBase = new KnowledgeBase();
    }

    @Test
    public void test1_Wrong_File() {

        Assert.assertFalse(this.knowledgeBase.parseDB("src/main/resources/non-existent-rules.db"));

    }

    @Test
    public void test2_Incomplete_DB() {

        Assert.assertFalse(this.knowledgeBase.parseDB("src/main/resources/incomplete-rules.db"));

    }
}
