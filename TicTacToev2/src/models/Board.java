package models;

import java.util.ArrayList;

public class Board {
    int size;
    char[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new char[size][size];
        initialize();
    }
    void initialize(){
        for(int i =0;i<size;i++){
            for(int j=0;j<size;j++){
                board[i][j]='-';
            }
        }
    }
    public void printBoard(){
        for(int i =0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void addSymbols(int row,int col, char symbol){
        if(validInput(row,col) && isValidCell(row,col)){
            board[row][col] = symbol;
        }
    }

    public boolean isValidCell(int row, int col){
        return board[row][col] == '-';
    }

    public boolean validInput(int row, int col){
        return (row>=0 && row<size && col>=0 && col<size);
    }

    public boolean isOver(){
        for(int i =0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]=='-'){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(char symbol){
        // Checking rows
        for(int i=0;i<size;i++){
            boolean rowWin = true;
            for(int j=0;j<size;j++){
                if(board[i][j]!=symbol) {
                    rowWin = false;
                    break;
                }
            }
            if(rowWin) return true;
        }
        // Checking columns
        for(int j=0;j<size;j++){
            boolean colWin = true;
            for(int i=0;i<size;i++){
                if(board[i][j]!=symbol) {
                    colWin = false;
                    break;
                }
            }
            if(colWin) return true;
        }

        //Checking diagonals
        boolean diagonal = true;
        for(int i=0;i<size;i++){
            if(board[i][i]!=symbol){
                diagonal = false;
                break;
            }
        }
        if(diagonal) return true;

        //Checking anti-diagonals
        boolean antiDiagonal = true;
        for(int i =0;i<size;i++){
            if(board[i][size-i-1]!=symbol){
                antiDiagonal = false;
                break;
            }
        }
        return antiDiagonal;
    }
}
