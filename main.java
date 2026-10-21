import java.util.*;
class sliding_game extends ent
//8 for UP
//2 for Down
//4 for left
//6 for right
{
    static int n=3;
    //checks whether the game ends or not
    static boolean checker(int ar[][])
    {
        int c=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==n-1 && j==n-1)
                return ar[i][j]==0;
                if(ar[i][j]!=c++)
                return false;
                
            }
        }
        return true;
    }
    //prints the array everytime after valid update
    static void print(int ar[][])
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            System.out.print(ar[i][j]+" ");
            System.out.println();
        }
        System.out.println();
        if(checker(ar))
        {System.out.println("CONGRATS YOU WON THE GAME");
        System.exit(0);}
    }
    public static void main()
    {
        int ar[][]={{4,3,6},{1,8,2},{7,5,0}};
        //4 6 3
        //1 8 2
        //7 5 0
        System.out.println("Rules\nThere is a 3x3 matrix as shown\nYou can only move 0 tile via \n8-Up\t2-Down\n6-Right\t4-Left\nPut 0 at the last to win the game");
        System.out.println("Enter 0 any where to exit the game");
        //locator for 0 tile
        int locator_col,locator_row;
        locator_row=locator_col=2;
        print(ar);
        //counter for number of steps
        int c=0;
        while(true)
        {
            int ch=int_();
            switch(ch)
            {
                case 8:
                {
                    if(locator_row-1>=0 && locator_row-1<n)
                    {
                        int t=ar[locator_row][locator_col];
                        ar[locator_row][locator_col]=ar[locator_row-1][locator_col];
                        ar[locator_row-1][locator_col]=t;
                        locator_row--;
                        print(ar);
                        c++;
                    }
                    else
                    System.out.println("NOT POSSIBLE");
                }
                break;
                case 2:
                {
                    if(locator_row+1>=0 && locator_row+1<n)
                    {
                        int t=ar[locator_row][locator_col];
                        ar[locator_row][locator_col]=ar[locator_row+1][locator_col];
                        ar[locator_row+1][locator_col]=t;
                        locator_row++;
                        print(ar);c++;
                    }
                    else
                    System.out.println("NOT POSSIBLE");
                }
                break;
                case 6:
                {
                    if(locator_col+1>=0 && locator_col+1<n)
                    {
                        int t=ar[locator_row][locator_col];
                        ar[locator_row][locator_col]=ar[locator_row][locator_col+1];
                        ar[locator_row][locator_col+1]=t;
                        locator_col++;c++;
                        print(ar);
                    }
                    else
                    System.out.println("NOT POSSIBLE");
                }
                break;
                case 4:
                {
                    if(locator_col-1>=0 && locator_col-1<n)
                    {
                        int t=ar[locator_row][locator_col];
                        ar[locator_row][locator_col]=ar[locator_row][locator_col-1];
                        ar[locator_row][locator_col-1]=t;
                        locator_col--;c++;
                        print(ar);
                    }
                    else
                    System.out.println("NOT POSSIBLE");
                }
                break;
                case 0: {System.out.println("Number of steps taken->"+c+"\nExiting");System.exit(0);break;}
                default: System.out.println("Re-enter");
            }
        }
    }
}//end of sliding_game
//start of ent

import java.util.*;
class ent
{
    static int int_()
    {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
        try
        {
            return sc.nextInt();
        }
        catch(InputMismatchException e)
        {
            sc.next();
            System.out.println("INVALID");
            continue;}
        }
    
    }
}//end of ent
