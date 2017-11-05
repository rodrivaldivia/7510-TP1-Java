package ar.uba.fi.tdd.rulogic.model;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class KnowledgeBase {

	private LinkedList<Fact> factList = new LinkedList<Fact>();
	private LinkedList<Rule> ruleList = new LinkedList<Rule>();


	public boolean answer(String query) {
		if(isFact(query)){
			for (int i=0;i < factList.size();i++){
				if (factList.get(i).isFact(query)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isFact(String fact){
		if (isRule(fact)){
			return false;
		}
		return fact.matches("\\w+\\(\\w+(, \\w+)*\\).");
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
		String[] splitArray = content.split("\\n");
		for (int i=0; i<splitArray.length; i++){
//			System.out.println(splitArray[i]);
//			System.out.println("New String");
			if (isRule(splitArray[i])){
//				System.out.println(splitArray[i]);
				this.ruleList.add(new Rule(splitArray[i]));
			}
			else{
				if(isFact(splitArray[i])){
					System.out.println(splitArray[i]);
					this.factList.add(new Fact(splitArray[i]));
				}
				else{
//					System.out.println(splitArray[i]);
					return false;
				}
			}
		}
		return true;
	}
}