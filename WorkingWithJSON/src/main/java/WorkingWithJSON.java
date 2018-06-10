import com.fasterxml.jackson.*;

public class WorkingWithJSON {
	public static void main(String[] args) {
		String in = "{\"0\":{\"levelName\":\"naka\",\"x\":611,"
				+ "\"y\":195,\"height\":150,\"width\":150},"
				+ "\"1\":{\"levelName\":\"naka\",\"x\":262,\"y\":244,"
				+ "\"height\":150,\"width\":150}}";
		System.out.println(in);
		
		//okay this single class setup with Spring and JSON API capability should be a good
		//place to play around with the imported JSON string until I can get it formatted the
		//way it needs to be for the purposes of MochiJumpLevelEditor
		
	}
}
