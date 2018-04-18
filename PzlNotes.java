String o1 = "(";
        String o2 = "{"
        String 03 = "["
        String c1 = ")"
        String c2 = "}"
        String c3 = "]"
        String open[] = {01,02,03}
        pass = false;
        /*
        for (all available opens)
        *if (testee contains open){
            where does testee contain open{
                     if (testee contains corresponding close[i] at a later spot){
                        pass= True
                    } else{
                     pass = flase
                    }
                }
            }
            
        }
        */





// seperate puzzle:
class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for (i2=0; i2<n; i2++){
                
            }
        }
        in.close();
    }
}

// different puzzle (still get timeout error on two cases) Long is too small BigInteger causes problems.

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            BigInteger n = in.nextBigInteger();
            BigInteger sum= BigInteger.valueOf(0);
            ArrayList<BigInteger> arr = new ArrayList<BigInteger>() ;
            for (BigInteger i = BigInteger.valueOf(0); i.compareTo(n)<0; i.add(BigInteger.ONE)){
                if (i.remainder(BigInteger.valueOf(3)) == BigInteger.valueOf(0) || i.remainder(BigInteger.valueOf(5)) == BigInteger.valueOf(0)){
                    arr.add(i);
                }
                
            }
            for (int z=0; z<arr.size(); z++){
                sum = sum.add(arr.get(z));
            }
            System.out.println(sum);
        }
    } 
}
// hourglass puzzle
/*
* setup if statement for length of 1st D & 2nd D & define hourglass shape. Create arraylist for input, create for
* statement to get largest sum in arraylist. easy day
*/

//next puzzle:
