package com.MochiJump.LevelEditor;


import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MochiJump.LevelEditor.UserInput;
import com.MochiJump.LevelEditor.UserInputRepo;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(path="/test")
public class UserInputController {
	ObjectMapper mapper = new ObjectMapper();

	
	@Autowired
	private UserInputRepo UserInputRepo;
	
	@GetMapping(path="/returnAll")
	public @ResponseBody Iterable <UserInput> getAllUserInputs(){
		return UserInputRepo.findAll();
	}
	
	@GetMapping(path="/return")
	public @ResponseBody Iterable <UserInput> getLevel (@RequestParam String name) {
		return UserInputRepo.findByLevelName(name);
	}
	
	@PostMapping(path="/json")	
	public @ResponseBody void recieverTest(@RequestBody String s){
		try {
		UserInput i = mapper.readValue(s, UserInput.class);
		UserInputRepo.save(i);
		} catch (JsonMappingException e) {
		    e.printStackTrace();
		} catch (JsonGenerationException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
}
