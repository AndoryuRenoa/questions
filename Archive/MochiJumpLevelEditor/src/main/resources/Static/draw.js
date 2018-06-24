/** Optional additional to Do:
* Undo button works, but in working with it I realize that 2 of every object is being created, and I do not know why, adding removeChild
* the end of the creation function keeps it from creating anything, so I'm not sure what exactly is going on here, but the short fix is
* to duplicate the undo script twice.
* add mochi start point
*
*
*
* Current reading: https://www.w3schools.com/js/js_json_intro.asp
* continued: https://blog.garstasio.com/you-dont-need-jquery/ajax/
* continued: https://www.kirupa.com/html5/making_http_requests_js.htm
* continued: https://stackoverflow.com/questions/7071544/post-from-xmlhttp-with-parameters
*/

/** use (i=0; i<.length;i++) to create output for DB
* NOTE! Occassionally I get a float value for value for x or y: make sure you cast value to int either in js or php!
*/

    var svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');
    svg.setAttribute ("width", "100%");
    svg.setAttribute ("height", "100%");
    var x;
    var y;
    var mouseDown;
    var makeRect;
    var xmlns = "http://www.w3.org/2000/svg";
    var brushSize = 5;
    var allRects;
    var pBRects = document.getElementById("paintBox").getBoundingClientRect();
document.getElementById("paintBox").style.cursor = "crosshair";
document.getElementById("paintBox").addEventListener("mousemove",function(event){
		cordsFunction(event);
	});
document.getElementById("paintBox").addEventListener("mouseleave", mouseReset);
document.getElementById("paintBox").addEventListener("mousedown", mouseDn);
document.getElementById("paintBox").addEventListener("mouseup", mouseUp);
document.getElementById("paintBox").addEventListener("mousemove", mouseMoveDrawBox);
	function mouseMoveDrawBox(){
     if (mouseDown == true){
		makeNewBox();
      }
     }
	function makeNewBox(){
        var newRect = document.createElementNS('http://www.w3.org/2000/svg', 'rect');
        newRect.setAttribute("x", (x*2-brushSize)/2);
        newRect.setAttribute("y", (y*2-brushSize)/2);
        newRect.setAttribute ("width", brushSize);
        newRect.setAttribute ("height", brushSize);
        newRect.setAttribute("fill", "#82571b");
		//^^ same color as in mochiJump currently
        svg.appendChild(newRect);
        document.getElementById("paintBox").appendChild(svg);
	}
	function cordsFunction(e){
		x = e.clientX -pBRects.left-5;
		y = e.clientY-pBRects.top-5;
		var output = "Coordinates : (" + x + "," + y +")";
		document.getElementById("demoOutput").innerHTML = output;
	}
    function mouseDn(){
    	mouseDown= true;
        }
    function mouseUp(){
    	mouseDown= false;
		makeNewBox();
        }
	function mouseReset(){
		mouseDown= false;
	}
	function brushS(){
		brushSize = 5;
	}
	function brushM(){
		brushSize = 50;
	}
	function brushL(){
		brushSize = 150;
	}
	function clearAll(){
		location.reload();
	}
	function getCoords(){
			allRects = svg.getElementsByTagName("*");
			var testOutput = allRects[0].getBoundingClientRect();
			alert(allRects.length+" objects have been created. Attributes for the first painted object is: x="+testOutput.left+", y="+ testOutput.top+",width="+testOutput.width+",height="+testOutput.height);
			//^^ I'm so close to being able to export this data to a database!!!
	}
// have not tested the function below! May need line to update document!
	function delLastAdded(){
		svg.removeChild(svg.lastChild);
		svg.removeChild(svg.lastChild);
	}
	
	function callLevel(){
		alert("Testing");
		var xhttp = new XMLHttpRequest();
			xhttp.open("GET", "/test/returnAll", true);
			xhttp.onload = function (){
				console.log("hi "+xhttp.responseText);
			};
			xhttp.send();
	}
	function createNewLevel(){
		alert ("This feature is not yet implimented");
	}