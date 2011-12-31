package org.agenda.android.model;

import java.util.ArrayList;
import java.util.List;

public class JournalRepository 
{

	

	public static List<Journal> s_journals = new ArrayList<Journal>();
	static 
	{
		Journal journal = new Journal("The Marker", "The Marker");
		Item item = new Item("https://sites.google.com/a/idpuzzle.com/file-hoster/mobile/judahism_001.jpg", "https://sites.google.com/a/idpuzzle.com/file-hoster/mobile/item_1.html");
		journal.addItem(item);
		s_journals.add(journal);
		journal = new Journal("the economist", "The Economist");
		item = new Item("https://sites.google.com/a/idpuzzle.com/file-hoster/mobile/judahism_001.jpg", "https://sites.google.com/a/idpuzzle.com/file-hoster/mobile/item_1.html");
		journal.addItem(item);
		s_journals.add(journal);
		journal = new Journal("Rock or Pop", "Rock or Pop");
		item = new Item("https://sites.google.com/a/idpuzzle.com/file-hoster/mobile/judahism_001.jpg", "https://sites.google.com/a/idpuzzle.com/file-hoster/mobile/item_1.html");
		journal.addItem(item);
		s_journals.add(journal);
	}
	
	public static List<Journal> getJournals()
	{
		return s_journals;
	}
}
