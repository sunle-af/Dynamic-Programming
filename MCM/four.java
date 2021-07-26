import java.util.*;
public class four {
 static HashMap<String, Boolean> map = new HashMap<>();
   static boolean solve(String a, String b){
    if(a.equals(b)) return true;

    //creating a unique key
    String key = a+ "_" +b;
    if(map.containsKey(key)){
         return map.get(key);
    }
    //flag creation
    boolean flag = false;
    int n = a.length();
    for(int i =1; i<=n-1; i++){
        boolean noswap=(solve(a.substring(0, i),b.substring(n - i,n)) && solve(a.substring(i, n),b.substring(0, n-i)));
         
        boolean swap=(solve(a.substring(0, i),b.substring(0, i))  && solve(a.substring(i, n),b.substring(i, n)));  if(swap || noswap){
            flag= true;
            break;
        }
    }
    map.put(a+"_"+b, flag);
    return flag;
}
    public static void main(String [] args){
        String a= "coder";
        String b= "ocred";
        System.out.print(solve(a, b));

    }
}
