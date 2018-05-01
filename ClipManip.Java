// This is taken from: http://mrbool.com/manipulating-clipboard-content-with-java/24758
// could be used to strip copied iscis of spaces / dashes / parenthesis


import java.awt.Toolkit; import java.awt.datatransfer.DataFlavor; 
import java.awt.datatransfer.StringSelection; 
import java.awt.datatransfer.Transferable; 


public class ClipBoard { public static void main(String args[]) {
  Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null); 
   try { if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) { 
    String text = (String)t.getTransferData(DataFlavor.stringFlavor); 
    text=text.toUpperCase(); StringSelection ss = new StringSelection(text);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); 
   } 
  } catch (Exception e) { 
   } 
 }
}

// yeah you can get this to run on a thread in the background perpetually trying to strip contents of clipboard to acceptable
// parameters
