/* Jamey Dogom
   Comp. 282
   Project 3 */   

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Driver3 {

    public static void main(String[] args) throws IOException {

        Puzzle puzzle = new Puzzle();
        int cost = 0,steps=0;
        String slides = "";
        ReadInput in = new ReadInput();        
        int board[]=in.ReadPuzzle();
        
        System.out.println("Welcome to the Nine Puzzle");
        System.out.println("Reading initial input: ");
        System.out.println(board[0] + " "+ board[1] + " " + board[2]);
        System.out.println(board[3] + " "+ board[4] + " " + board[5]);
        System.out.println(board[6] + " "+ board[7] + " " + board[8]);

        System.out.println("Solving by BFS:");
        String input= in.readBFS();               
        BFS bfs = new BFS();      
        bfs.add(input,0);                          
        
        while(bfs.q.peek()!=null){
            
            bfs.MoveUp(bfs.q.peek());                   
            bfs.MoveDown(bfs.q.peek());                
            bfs.MoveLeft(bfs.q.peek());                
            bfs.MoveRight(bfs.q.remove());              
        }
        System.out.println(bfs.Solution());
        System.out.println("Solving by AStar:");
        puzzle.preparePuzzle(board);
        
        Solver mySolver= new Solver(puzzle);
        Node node= mySolver.SolvePuzzel();
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        Node node1 = node;
        stack.push(node);

        for(int i=0;node1.parent!=null;i++){
            node1=node1.parent;
            stack.push(node1);          
        }
        
       
        int lent=stack.size();

        for(int i=0;i<lent-1;i++){
           node1= stack.pop();
          cost = cost + node1.getCost();
          node1.printNode();
          steps++;
        }
        System.out.println("Cost = "+cost);
        System.out.println("Steps = "+steps);
        

    }

}
