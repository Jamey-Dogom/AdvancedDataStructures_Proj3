/* Jamey Dogom
   Comp. 282
   Project 3 */   

import java.util.Comparator;

public class Node implements Comparator<Node> {
    public String Move;
    public Puzzle puzzle= null;
    public int pcost=0;
    public int hcost=0;
    public int tcost=0;
    public Node parent=null;
    @Override
    public int compare(Node a, Node b)
    {

        if (a.tcost < b.tcost)
        {
            return -1;
        }
        if (a.tcost > b.tcost)
        {
            return 1;
        }
        return 0;
    }

    public Node(int pcost,int hcost,Puzzle puzzle,Node parent,String Move){
        this.puzzle=puzzle;
        this.hcost=hcost;
        this.pcost=pcost;
        this.tcost=hcost+pcost;
        this.parent=parent;
        this.Move=Move;
    }
    public Node() {
		// TODO Auto-generated constructor stub
	}

	public void printNode(){
     System.out.println("Move Slide "+this.puzzle.Space);
    }

    public int getCost()
    {
     return this.hcost;
    }
}
