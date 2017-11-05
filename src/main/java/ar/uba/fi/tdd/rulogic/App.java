package ar.uba.fi.tdd.rulogic;

import ar.uba.fi.tdd.rulogic.model.KnowledgeBase;

import java.util.Scanner;

/**
 * Console application.
 *
 */
public class App
{
	public static void main(String[] args) {
		
		System.out.println("I shall answer all your questions!");
		KnowledgeBase knowledgeBase = new KnowledgeBase();
		if(!knowledgeBase.parseDB("src/main/resources/rules.db")){
			return;
		}
		Scanner scanner = new Scanner( System.in );
		String input;
		do{
			System.out.print( "Type your query (\"quit\" to quit program): " );
			input = scanner.nextLine();
			System.out.println( "Query = " +  knowledgeBase.answer(input));
		}while (input.compareTo("quit") != 0);
    }
}
