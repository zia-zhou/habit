package com.habit.Habit.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.habit.Habit.model.Habits;

import java.util.Optional;


public interface MySqlRepository extends JpaRepository<Habits, Integer>  {
	Optional<Habits> findByPasscode(int passcode);
}


