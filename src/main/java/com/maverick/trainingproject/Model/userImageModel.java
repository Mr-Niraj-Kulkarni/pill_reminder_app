package com.maverick.trainingproject.Model;

import java.sql.Blob;

public class userImageModel {
	protected String name;
	protected Blob image;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	
}
