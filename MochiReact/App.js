import React, { Component } from 'react';
import './App.css';
class App extends Component {
  render() {
    return (
	<div>
	<div className="modal" id ="modal">
	<p>This project is still a work in progress</p>
	<p> MochiJump is a personal project designed by Andrew Lenoir.</p>
	<p> It is broken into two projects </p>
	<p></p>
	<p> MochiJump is a stand alone Desktop App that functions as a 2D 8 bit style platformer game. It is written in Java</p>
	<p> MochiJumpLevelEditor is the project that power's this website. Proceeding to "lvl edit" will allow you to retrieve levels or paint your own</p> 
	<p>The backend is written in Java and uses the Spring Framework along with a MySQL server. </p>
	<p>It is hosted on gCloud using the Compute Engine running an f1-micro machine instance with an Ubuntu OS.</p>
	<p styles={{paddingLeft: "30pt"}}>	Check out the Desktop App source code
		<a href="https://github.com/AndoryuRenoa/MochiJump">here</a>
		</p>
	<p styles={{paddingLeft: "30pt"}}>Direct link to Download MochiJump Desktop App 
		<a href ="https://github.com/AndoryuRenoa/MochiJump/blob/master/dist/MochiJump.jar?raw=true">here</a>
		</p>
	<p styles={{paddingLeft: "30pt"}}>	Check out the Web App source code
		<a href="https://github.com/AndoryuRenoa/MochiJumpLevelEditor">here</a>
		</p>
		<div className="aboutButton">
			<button id="hideAbout"> Close </button>
		</div>
	</div>
	<div className ="mochiIcon" id="mochiIcon">
		<img className="icon" src = "https://raw.githubusercontent.com/AndoryuRenoa/MochiJump/master/resources/background.png" ></img>
	</div>

	<div class ="container1">
		<div class="selector1" id="selector1">
			<img class= "selectorimg1" id="selectorimg1" src ="https://raw.githubusercontent.com/AndoryuRenoa/MochiJump/master/resources/bone1M.png" styles={{visibility: "hidden"}}></img>
		</div>
		<div class="option1" id="option1">
			<a href ="/test">
			<img  src = "https://raw.githubusercontent.com/AndoryuRenoa/MochiJump/master/resources/lvledit.png" styles={{float: 'right'}}></img>
			</a>
		</div>
		<div className= "right1"> </div>
	</div>
	
		<div className="container2">
		<div className="selector2" id="selector2">
			<img className= "selectorimg2" id="selectorimg2" src ="https://raw.githubusercontent.com/AndoryuRenoa/MochiJump/master/resources/bone1M.png" style ={{visibility: "hidden"}}></img>
		</div>
		<div className="option2" id="option2">
			<img  src = "https://raw.githubusercontent.com/AndoryuRenoa/MochiJump/master/resources/about.png" style={{float: 'right'}}></img>
		</div>
		<div class = "right2"> </div>
	</div>
	</div>
    );
  }
}

export default App;
