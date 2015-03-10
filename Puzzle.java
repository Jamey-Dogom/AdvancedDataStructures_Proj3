/* Jamey Dogom
   Comp. 282
   Project 3 */   

import java.util.*;

public class Puzzle {
	int logic  = 3;
    public int State[][] = new int[logic][logic];
    public int Space;
    public int boardID;
    int moveTo;
    int moveFrom;
    int moveToX;
    int moveToY;
    int moveFromX;
    int moveFromY;
    int tempValue;
    
    public Puzzle() {
    }

    public void preparePuzzle(int[] puzzle_board){
        int x=0;
     
        for (int i=0;i<logic;i++){
            for (int j=0;j<logic;j++){
               State[i][j]=puzzle_board[x++];
               if (puzzle_board[x-1]==0){
                   Space=x-1;
               }
            }
        }
    }
   
    public int[] MoveTile() {
        int pos = Space;
        int x[] = new int[4];
        int Xposition = pos / logic;
        int Yposition = pos % logic;

        //TOP
        if (Xposition > 0) {
            x[0] = ((Xposition - 1) * logic) + (Yposition);

        } else {
            x[0] = -1;
        }

        //DOWN
        if (Xposition < 2) {
            x[1] = ((Xposition + 1) * logic) + (Yposition);
        } else {
            x[1] = -1;
        }

        //LEFT
        if (Yposition > 0) {
            x[2] = (Xposition * logic) + (Yposition - 1);
        } else {
            x[2] = -1;
        }

        //RIGHT
        if (Yposition < 2) {
            x[logic] = (Xposition * logic) + (Yposition + 1);
        } else {
            x[logic] = -1;
        }

        return x;
    }

    public boolean MoveUp() {
       
        if (MoveTile()[0] != -1) {
            moveTo = this.MoveTile()[0];
            moveFrom = Space;
            Space = moveTo;
            moveToX = moveTo / logic;
            moveToY = moveTo % logic;
            moveFromX = moveFrom / logic;
            moveFromY = moveFrom % logic;
            tempValue = this.State[moveToX][moveToY];
            this.State[moveToX][moveToY] = this.State[moveFromX][moveFromY];
            this.State[moveFromX][moveFromY] = tempValue;
            return true;
        } else {
            return false;
        }

    }

    public boolean MoveDown() {
      
        if (MoveTile()[1] != -1) {
            moveTo = this.MoveTile()[1];
            moveFrom = Space;
            Space = moveTo;
            moveToX = moveTo / logic;
            moveToY = moveTo % logic;
            moveFromX = moveFrom / logic;
            moveFromY = moveFrom % logic;
            tempValue = this.State[moveToX][moveToY];
            this.State[moveToX][moveToY] = this.State[moveFromX][moveFromY];
            this.State[moveFromX][moveFromY] = tempValue;
            return true;
        } else {
            return false;
        }

    }

    public boolean MoveLeft() {
   
        if (MoveTile()[2] != -1) {
            moveTo = this.MoveTile()[2];
            moveFrom = Space;
            Space = moveTo;
            moveToX = moveTo / logic;
            moveToY = moveTo % logic;
            moveFromX = moveFrom / logic;
            moveFromY = moveFrom % logic;
            tempValue = this.State[moveToX][moveToY];
            this.State[moveToX][moveToY] = this.State[moveFromX][moveFromY];
            this.State[moveFromX][moveFromY] = tempValue;
            return true;
        } else {
            return false;
        }

    }

    public boolean MoveRight() {
      
        if (MoveTile()[logic] != -1) {
            moveTo = this.MoveTile()[logic];
            moveFrom = Space;
            Space = moveTo;
            moveToX = moveTo / logic;
            moveToY = moveTo % logic;
            moveFromX = moveFrom / logic;
            moveFromY = moveFrom % logic;
            tempValue = this.State[moveToX][moveToY];
            this.State[moveToX][moveToY] = this.State[moveFromX][moveFromY];
            this.State[moveFromX][moveFromY] = tempValue;
            return true;
        } else {
            return false;
        }

    }

    public void Duplicate(Puzzle puzzle_board) {

        for (int i = 0; i < logic; i++) {
            for (int j = 0; j < logic; j++) {
                this.State[i][j] = puzzle_board.State[i][j];
            }
        }
        this.Space = puzzle_board.Space;
    }
}
