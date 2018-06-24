package com.MochiJump.LevelEditor;

//Attempt to simply launch the webpage
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// ^ if proper dependencies aren't setup at the beginning they can be adjusted in pom.xml

@Controller
public class PageLaunchController {
	@RequestMapping("/")
	public String index() {
		return"draw.html";
	}

}
