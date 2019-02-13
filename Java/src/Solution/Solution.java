package Solution;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //input number of students
        int n = sc.nextInt();
        int best = 0;
        int current;
        int bestID = 0;
        int[] arr, refArr;
        
        arr = new int[n];
        refArr = new int[n];
        
        //input all student times and creates a reference array for comparison
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            refArr[i] = arr[i];
        }
        sc.close();
        
        //test every possible startposition to see which is best
        for(int i = 0; i < n; i++){
            current = cycle(arr, i);
            if(current > best){
                best = current;
                bestID = i+1;
            }
        }
        System.out.println(bestID);
        
    }
    
    //function to see how many would finish in given startposition
    public static int cycle(int[] arr, int startpos){
        
        //copies original arrays values
        int[] array = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            array[i] = arr[i];
        }
        
        int steps = array.length;
        int finished = 0;

        
        while(steps > 0){
            
            //check if finished drawing
            if(array[startpos] <= 0){
                finished++;
            }
            
            //forward time and progression of the rest
            for(int i = 0; i < array.length; i++){
                array[i]--;
            }
            
            //position of the next to be checked
            startpos++;
            
            //loop to the beginning of array if out of bounds
            if(startpos > array.length-1){
                startpos = 0;
            }
            steps--;
        }
        return finished;
    }
}