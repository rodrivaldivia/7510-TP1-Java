package ar.uba.fi.tdd.rulogic.model;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class KnowledgeBase {

	private LinkedList<Fact> factList = new LinkedList<Fact>();
	private LinkedList<Rule> ruleList = new LinkedList<Rule>();


	public boolean answer(String query) {
		if(Fact.isFact(query)){
			for (int i=0; i < factList.size(); i++){
				if (factList.get(i).isEqual(query)) {
					return true;
				}
			}
		}
		return false;
	}


	private boolean isRule(String rule){
//		return rule.matches("\\w+\\(\\w+(,\\ \\w+)*\\)\\ \\:\\-\\ (\\w+\\(\\w+(,\\ \\w+)*\\),\\ )*\\.");
		return rule.matches("\\w+\\(\\w+(, \\w+)*\\) :- (\\w+\\(\\w+(, \\w+)*\\), )*\\w+\\(\\w+(, \\w+)*\\).");
	}

	public boolean parseDB(String fileName) {

		String content;
		try {
			content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
		}
		catch(java.io.FileNotFoundException e){
			System.out.println("No se encontró el archivo");
			return  false;
		}
		Parser parser = new Parser(content);
		if (!parser.parseDB(factList, ruleList)) {
			return false;
		}

		return true;
	}
}