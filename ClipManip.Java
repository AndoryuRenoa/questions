// isci trimmer/stripper for clipboard
//  Inspired by: http://mrbool.com/manipulating-clipboard-content-with-java/24758



import java.awt.Toolkit; 
import java.awt.datatransfer.DataFlavor; 
import java.awt.datatransfer.StringSelection; 
import java.awt.datatransfer.Transferable; 


public class ClipManip { public static void main(String args[]) {
  Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null); 
   try { 
     if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) { 
        String text = (String)t.getTransferData(DataFlavor.stringFlavor); 
        text=text.toUpperCase(); 
        StringBuffer sb = new StringBuffer(text);
        sb.replace(" ","");
        sb.replace("-","");
        sb.replace("(","");
        sb.replace(")","");
        sb.replace("_","");
        sb.replace("[","");
        sb.replace("]","");
        sb.replace("{","");
        sb.replace("}","");
        sb.replace("/","");
        sb.replace("\","");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sb, null); 
      } 
    }catch (Exception e) {
     
   } 
 }
}

// yeah you can get this to run on a thread in the background perpetually trying to strip contents of clipboard to acceptable
// parameters
