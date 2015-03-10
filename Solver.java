/* Jamey Dogom
   Comp. 282
   Project 3 */   
   
import java.util.Comparator;

import java.util.PriorityQueue;

public class Solver {

    public int lowestTotalCost=0;
    public int pcost = 0;
    public int hcost = 0;
    public Puzzle game_Board = null;

    public Solver(Puzzle puzzle) {
        game_Board = puzzle;
    }
    public Node SolvePuzzel() {
        Comparator<Node> comparator = new Node();
        PriorityQueue<Node> queue =
                new PriorityQueue<Node>(350, comparator);

        Node mTile = null;
        
        pcost = 0;
        Node moveTile = new Node(pcost, calculateHeuristic(game_Board), game_Board, null,"Start");
        
        queue.add(moveTile);
        Puzzle puzzle_Board=new Puzzle();
        do {
            Puzzle puzzle = null;
            pcost++; 
            moveTile = queue.remove();
            puzzle = new Puzzle();
            puzzle.Duplicate(moveTile.puzzle);
            puzzle_Board.Duplicate(puzzle);

            if (puzzle.MoveUp() == true) {

                mTile = new Node(pcost, calculateHeuristic(puzzle), puzzle, moveTile,"UP");
                queue.add(mTile);

                if (mTile.hcost == 0) {
                    return mTile;
                }
            }
            puzzle= new Puzzle();
            puzzle.Duplicate(puzzle_Board);
            if (puzzle.MoveDown() == true) {

                mTile = new Node(pcost, calculateHeuristic(puzzle), puzzle, moveTile,"Down");
                queue.add(mTile);
                if (mTile.hcost == 0) {
                    return mTile;
                }
            }
            puzzle= new Puzzle();
            puzzle.Duplicate(puzzle_Board);;
            if (puzzle.MoveLeft() == true) {

                mTile = new Node(pcost, calculateHeuristic(puzzle), puzzle, moveTile,"Left");
                queue.add(mTile);

                if (mTile.hcost == 0) {
                    return mTile;
                }
            }
            puzzle= new Puzzle();
            puzzle.Duplicate(puzzle_Board);
            if (puzzle.MoveRight() == true) { 
                mTile = new Node(pcost, calculateHeuristic(puzzle), puzzle, moveTile,"Right");
                queue.add(mTile);

                if (mTile.hcost == 0) {
                    return mTile;
                }
            }
        } while (true);
    }

    public int calculateHeuristic(Puzzle puzzle) {
        int cost = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {

                int value = puzzle.State[x][y];
                int xvalue = value / 3;
                int yvalue = value % 3;
                cost = cost + (Math.abs(x - xvalue) + Math.abs(y - yvalue));
            }
        }
        return cost;
    }
}


