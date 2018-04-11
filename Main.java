// Array Riddle

public class MyClass {
    String oItemS1[] = {"a","b","c","d"};
    Double oPriceS1[] = {10.00, 5.55, 9.00, 2.00};
    String itemS1[] = {"a", "c", "d"};
    Double priceS1[] = {10.00, 10.00, 10.00};
    int lies =0;
    
    private void solvePuzzle (String oItem[], Double oPrice[], String item[], Double price[]) {
    int oItemLength = oItem.length;
    int itemLength = item.length;
    for (int i=0; i<oItemLength; i++){
      for (int a=0; i<itemLength; a++){
        if (oItem[i] == item[a]){
          if (oPrice[i] != price[a]){
            lies++;
          }
        }
      }
    }
  }


    
    public static void main(String args[]) {
        solvePuzzle (oItemS1, oPriceS1, itemS1, priceS1);
        System.out.println(lies);

        
    }
}
