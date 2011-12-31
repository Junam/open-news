package org.agenda.android.model;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.Drawable;


public class Journal {

	private String id;
	private String name;
	private List<Item> items;
	private Drawable listImage;
	
	
	

	public Journal(String id, String name) {
		this.id = id;
		this.name = name;
		items = new ArrayList<Item>();
	}
	
	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}
	
	public void addItem(Item item)
	{
		items.add(item);
	}

	public Item[] getItems() {
		return items.toArray(new Item[items.size()]);
	}
	
	public Drawable getListImage() {
		return listImage;
	}

	public void setListImage(Drawable listImage) {
		this.listImage = listImage;
	}
	
	
}
