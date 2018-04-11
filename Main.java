//array riddle -- I have no idea why this outputs 3 lies instead of 2. I'm completely stumped.

public class MyClass {
    static String oItemS1[] = {"a","b","c","d"};
    static Double oPriceS1[] = {10.00, 5.55, 9.00, 2.00};
    static String itemS1[] = {"a", "b", "c", "d"};
    static Double priceS1[] = {10.00, 10.00, 10.00};
    int lies =0;
    
    private void solvePuzzle (String oItem[], Double oPrice[], String item[], Double price[]) {
    int oItemLength = oItem.length;
    int itemLength = item.length;
    for (int i=0; i<oItemLength; i++){
      for (int a=0; a<itemLength; a++){
        if (oItem[i].equals(item[a])){ // silly syntax error
          if (oPrice[i] != price[a]){
            lies++;
          }
        }
      }
    }
  }


    
    public static void main(String args[]) {
        MyClass myClass = new MyClass();
        myClass.solvePuzzle (oItemS1, oPriceS1, itemS1, priceS1);
        System.out.println(myClass.lies);
        
    }
}
