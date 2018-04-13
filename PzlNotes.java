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
            long n = in.nextLong();
            BigInteger sum= BigInteger.valueOf(0);
            ArrayList<Integer> arr = new ArrayList<Integer>() ;
            for (int i = 0; i<n; i++){
                if (i % 3 == 0 || i % 5 == 0){
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

