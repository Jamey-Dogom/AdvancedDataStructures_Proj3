/* Jamey Dogom
   Comp. 282
   Project 3 */   

import java.io.FileNotFoundException;
import java.util.*;

public class BFS {
    
    Queue<String> q = new LinkedList<String>();    
    Map<String,Integer> map = new HashMap<String, Integer>(); 
    String solution = "";
    String goal ="123456780";
    void add(String input,int n){
        if(!map.containsKey(input)){
            map.put(input,n);
            q.add(input);
        }
        
    }
    
    void MoveUp(String input){
        int temp = input.indexOf("0");
        if(temp>2){
            String s = input.substring(0,temp-3)+"0"+input.substring(temp-2,temp)+input.charAt(temp-3)+input.substring(temp+1);
            add(s,map.get(input)+1);
            if(s.equals(goal)) {
                solution = "Solution Exists with "+map.get(s)+" Steps";
            }
        }
    }
    void MoveDown(String input){
        int temp = input.indexOf("0");
        if(temp<6){
            String s = input.substring(0,temp)+input.substring(temp+3,temp+4)+input.substring(temp+1,temp+3)+"0"+input.substring(temp+4);
            add(s,map.get(input)+1);
            if(s.equals(goal)) {
            	solution = "Solution Exists with "+map.get(s)+" Steps";
            }
        }
    }
    void MoveLeft(String input){
        int temp = input.indexOf("0");
        if(temp!=0 && temp!=3 && temp!=6){
            String s = input.substring(0,temp-1)+"0"+input.charAt(temp-1)+input.substring(temp+1);
            add(s,map.get(input)+1);
            if(s.equals(goal)) {
            	solution = "Solution Exists with "+map.get(s)+" Steps";
            }
        }
    }
    void MoveRight(String input){
        int temp = input.indexOf("0");
        if(temp!=2 && temp!=5 && temp!=8){
            String s = input.substring(0,temp)+input.charAt(temp+1)+"0"+input.substring(temp+2);
            add(s,map.get(input)+1);
            if(s.equals(goal)) {
            	solution = "Solution Exists with "+map.get(s)+" Steps";
            }
        }
    }
    public String Solution()
    {
    	return solution;
    }
}
