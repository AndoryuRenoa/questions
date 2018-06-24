package com.MochiJump.LevelEditor;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.MochiJump.LevelEditor.UserInput;

public interface UserInputRepo extends CrudRepository <UserInput, Long> {
	public List<UserInput> findByLevelName (String levelName);
	
}
