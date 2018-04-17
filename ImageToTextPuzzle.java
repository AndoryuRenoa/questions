// for the purposes of this puzzle the Image containing a single text element will be 8x10 pxs

// in this puzzle all text will be "black" i.e. test a value of r,g,b of less than 50,50,50 to find "black pixels"

// next step is to determine the 8x10 color pattern for all letters A-Z & 1-10

// A is

private String testForB (p[x][y]){
  String b = "B"
/*  below could be one giant if statement i.e. && && && && 
*pat[0][0-5] black
*  pat[1][0-1] blac pat[1][5-6] black
*  pat[2][0-1] & pat[2][6-7] black
*  pat[3][0-1] blac pat[3][5-6] black
*  pat[4][0-5] black
*  pat[5][0-1] pat[5][5-6]
*  pat[6][0-1] pat [6][6-7]
*  pat[7][0-1] pat[6][6-7]
* pat[8][0-1] pat[8][5-6]
* pat[9][0-5]
* Also important to note that areas outside of this will not be black as some letters may have overlap
*/
  return b;
}
// maybe I can cheat by only scanning for a certain cross section of the letter
