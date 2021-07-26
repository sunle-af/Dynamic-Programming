import java.util.*;
public class three {
     
    static int solve(String s,int i, int j, int isTrue){
        int t[][][] = new int[1001][1001][2];
        for(int [][]row: t)
            for(int []col: row){
                Arrays.fill(col,-1);
            }

        char ch[] = s.toCharArray();
        if(t[i][j][isTrue] != -1) return t[i][j][isTrue];
        if(i>0) return 0;

        if(i==j) {
            //for True
        if(isTrue== 1){
            if(ch[i] =='T')
         return t[i][j][isTrue] =1;
        else t[i][j][isTrue] =0;
        }
        //for False 
        else if(isTrue==0){
            if(ch[i] == 'F') return t[i][j][isTrue] =1;
            else return t[i][j][isTrue] = 0;
        }

        }
        int ans =0;
        int leftTrue, rightTrue, leftFalse,rightFlase;
        for(int k=i+1; k<=j-1; k=k+2){
            //leftTrue
            if( t[i][k-1][1] != -1){
                leftTrue= t[i][k-1][1];
            }else {
                leftTrue= solve(s, i, k-1, 1);
                t[i][k-1][1]= leftTrue;
            }
            //leftFalse
            if( t[i][k-1][0] != -1){
                leftFalse= t[i][k-1][0];

            }else {
                leftFalse= solve(s, i, k-1, 0);
                t[i][k-1][0]= leftFalse;
            }
            //righttrue
            if( t[k+1][j][1] != -1){
                rightTrue= t[k+1][j][1];

            }else {
                rightTrue= solve(s, k+1, j, 1);
                t[k+1][j][1]= rightTrue;
            }
            //rightFalse
            if( t[k+1][j][0] != -1){
                rightFlase= t[k+1][j][0];

            }else {
                rightFlase= solve(s, k+1, j, 0);
                t[k+1][j][0]= rightFlase;
            }
            //
            if(ch[k] == '&'){
                if(isTrue==1){
                    ans = ans+ leftTrue * rightTrue ;
                }else if(isTrue==0){
                    ans = ans + leftFalse*rightTrue + leftTrue * rightFlase + leftFalse*rightFlase;
                }
            }
            if(ch[k] == '|'){
                if(isTrue==1){
                    ans = ans + leftTrue * rightTrue + leftTrue * rightFlase + leftFalse * rightTrue; 
                }
                else if(isTrue==0){
                    ans = ans + leftFalse* rightFlase;
                }
            }
            if(ch[k] == '^'){
                if(isTrue==1){
                    ans = ans + leftTrue * rightFlase + leftFalse* rightTrue;
                }
                else if(isTrue==0){
                    ans = ans + leftTrue* rightTrue + leftFalse * rightFlase;
                }
            }

             
        }
        return t[i][j][isTrue] = ans%1001 ;

    }
    public static void main(String [] args){
        String s = "T|T&F^T";
        int i=0;
        int j = s.length()-1;
        int isTrue = 1;
        System.out.println(solve(s, i, j, isTrue));
    }
}
