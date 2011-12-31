package org.agenda.android.model;

import android.graphics.drawable.Drawable;

public class Item 
{

	public String title;
	public String content;
	private Drawable image;
	private String imageUrl;
	private String contentAndTitleUrl;

	public Item(String imageUrl, String contentAndTitleUrl) 
	{
		this.imageUrl = imageUrl;
		this.contentAndTitleUrl = contentAndTitleUrl;
	}

	public String getTitle() 
	{
		return title;
	}

	public String getContent() 
	{
		return content;
	}
	
	public Drawable getImage() {
		return image;
	}

	public void setImage(Drawable drawable) {
		this.image = drawable;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getContentAndTitleUrl() {
		return contentAndTitleUrl;
	}

	public void setContent(String content) {
		this.content = content;
		
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	
	
	
	
}
