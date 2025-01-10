package com.habit.Habit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "habits")
public class Habits {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	@Column(name = "Passcode")
	  private int passcode;
	  @Column(name = "hab")
	  private String hab;

	  public Habits(Integer passcode, String hab) {
		  this.passcode = passcode;
		  this.hab = hab;
	  }
	  
	  public Habits() {
		  
	  }
	  public Integer getId() {
	    return Id;
	  }

	  public void setId(Integer Id) {
	    this.Id = Id;
	  }

	  public int getPasscode() {
	    return passcode;
	  }
	  
	  public void setPasscode(int passcode) {
		    this.passcode = passcode;
		  }
	  public void setHabitList(String hab) {
	    this.hab = hab;
	  }

	  public String getHabitList() {
	    return hab;
	  }
}
