package com.habit.Habit.controller;

import java.util.List;
import java.util.Map;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.habit.Habit.model.Habits;

import com.habit.Habit.repository.MySqlRepository;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HabitController {
	@Autowired
	MySqlRepository mySqlRepository;
	
	@GetMapping("/")
	public List<Habits> getAllHabits() {
		
		return mySqlRepository.findAll();
	}
	
	@GetMapping("/{passcode}")
	 public Optional<Habits> getHabitByPasscode(@PathVariable("passcode")int passcode) {
	        return mySqlRepository.findByPasscode(passcode);
	    }
	
	@DeleteMapping("/remove/{id}")
	public boolean deleteHabit(@PathVariable("id") Integer id) {
		if(!mySqlRepository.findById(id).equals(Optional.empty())) {
			mySqlRepository.deleteById(id);
			return true;
		}
		return false;
		
	}
	
	@PutMapping("/update/{id}")
	public Habits updateHabits(@PathVariable("id") Integer id, @RequestBody Map<String,String> body) {
		
		Habits currentHabit =  mySqlRepository.findById(id).get();
		currentHabit.setHabitList(body.get("habits"));
		mySqlRepository.save(currentHabit);
		return currentHabit;
		
	}
	
	@PostMapping("/add")
	public Habits create(@RequestBody Map<String, String> body) {
		Integer passcode = Integer.parseInt(body.get("passcode"));
		String habits = body.get("habits");
		
		Habits newHabits = new Habits(passcode, habits);
		return mySqlRepository.save(newHabits);
		
	}
	
	 
}
