package ar.uba.fi.tdd.rulogic.model;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class KnowledgeBaseTest {

	@InjectMocks
	private KnowledgeBase knowledgeBase;

	@Before
	public void setUp() throws Exception {
		initMocks(this);
		knowledgeBase = new KnowledgeBase();
		this.knowledgeBase.parseDB("src/main/resources/rules.db");
	}

	@Test
	public void test_Wrong_Fact() {
		Assert.assertFalse(this.knowledgeBase.answer("varon(javier)."));
	}

	@Test
	public void test_Wrong_Fact2() {
		Assert.assertFalse(this.knowledgeBase.answer("hermano(javier, sanchez)."));
	}

	@Test
	public void test_Wrong_Fact3() { Assert.assertFalse(this.knowledgeBase.answer("")); }



	@Test
	public void test_Correct_Fact() {
		Assert.assertTrue(this.knowledgeBase.answer("varon(juan)."));
	}

	@Test
	public void test_Correct_Fact2() {
		Assert.assertTrue(this.knowledgeBase.answer("hermano(nicolas, roberto)."));
	}



	@Test
	public void test_Non_Existent_Rule() {
		Assert.assertFalse(this.knowledgeBase.answer("primo(X, Y)."));
	}

	@Test
	public void test_Non_Existent_Rule2() {
		Assert.assertFalse(this.knowledgeBase.answer("(X, Y)."));
	}


	@Test
	public void test_Correct_Rule() {
		Assert.assertTrue(this.knowledgeBase.answer("hijo(alejandro, roberto)."));
	}

	@Test
	public void test_Correct_Rule2() {
		Assert.assertTrue(this.knowledgeBase.answer("tio(nicolas, cecilia, roberto)."));
	}

	@Test
	public void test_Valid_Rule_Wrong_Arg() {
		Assert.assertFalse(this.knowledgeBase.answer("tio(roberto, cecilia, nicolas)."));
	}

}
