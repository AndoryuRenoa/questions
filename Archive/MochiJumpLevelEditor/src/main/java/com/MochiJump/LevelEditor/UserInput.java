package com.MochiJump.LevelEditor;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
// Using the below or @Column (unique = true) does not seem to do anything
// @Table(uniqueConstraints={@UniqueConstraint(columnNames={"levelName"})})
// for now consider querying the database checking for the same name and then working in a 
// way to drop that row if the user accepts client side

public class UserInput {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	

	private String levelName;
	
	@Column(length = 1000000)
	@Lob
	private ArrayList<Integer> startX;
	
	@Column(length = 1000000)
	@Lob
	private ArrayList<Integer> startY;
	
	@Column(length = 1000000)
	@Lob
	private ArrayList<Integer> width;
	
	@Column(length = 1000000)
	@Lob
	private ArrayList<Integer> height;
	

	public Integer getId () {
		return id;
	}
	

	public void setId (Integer id) {
		this.id = id;
	}
	
	
	public String getlevelName() {
		return levelName;
	}
	

	public void setLevelName(String levelName) {
		this.levelName=levelName;
		System.out.println(levelName);
	}
	

	public ArrayList<Integer> getStartX() {
		return startX;
	}

	public void setStartX(ArrayList<Integer> startX) {
		this.startX = startX;
	}

	public ArrayList<Integer> getStartY() {
		return startY;
	}

	public void setStartY (ArrayList<Integer> startY) {
		this.startY = startY;
	}

	public ArrayList<Integer> getWidth () {
		return width;

	}

	public void setWidth (ArrayList<Integer> width) {
		this.width = width;
		System.out.println(width);
	}

	public ArrayList<Integer> getHeight() {
		return height;
	}

	public void setHeight (ArrayList<Integer> height) {
		this.height = height;
	}
	
	
}
