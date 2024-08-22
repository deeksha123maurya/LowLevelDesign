package com.example.lowleveldesign.tictactoe;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;

    public void initializeGame()
    {
        players=new LinkedList<>();
        gameBoard=new Board(3);

        Player player1=new Player("Player1",new PlayingPieceX());
        Player player2=new Player("Player2",new PlayingPieceO());

        players.add(player1);
        players.add(player2);
    }

    public String startGame()
    {
        boolean noWinner=true;

        while(noWinner)
        {
            Player playerTurn=players.removeFirst();
            gameBoard.printBoard();

            List<Pair<Integer,Integer>> freeCells=gameBoard.getFreeCells();

            if(freeCells.isEmpty()==false)
            {
                noWinner=false;
                continue;
            }

            System.out.println("Enter row and col:");
            Scanner input=new Scanner(System.in);
            String s= input.nextLine();
            String[] values=s.split(",");
            int row=Integer.valueOf(values[0]);
            int col=Integer.valueOf(values[1]);

            boolean pieceAddedSuccessfully= gameBoard.addPiece(row,col,playerTurn.playingPiece);
            if(pieceAddedSuccessfully==false)
            {
                System.out.println("Incorrect Position");
                players.addFirst(playerTurn);
                continue;
            }

            boolean winner=isThereWinner(row,col,playerTurn.playingPiece.pieceType);
            if(winner) {
                System.out.print("Winner is" + playerTurn.name);
            }
        }
        return "tie";
    }

    public boolean isThereWinner(int row,int col, PieceType pieceType)
    {
        boolean rowMatch=true;
        boolean colMatch=true;
        boolean diagMatch=true;
        boolean antiDiagMatch=true;

        for(int i=0;i< gameBoard.size;i++)
        {
            if(gameBoard.board[row][i]==null || gameBoard.board[row][i].pieceType!=pieceType)
                rowMatch=false;
        }

        for(int i=0;i< gameBoard.size;i++)
        {
            if(gameBoard.board[i][col]==null || gameBoard.board[i][col].pieceType!=pieceType)
                colMatch=false;
        }

        for(int i=0,j=0;i< gameBoard.size;i++,j++)
        {
            if(gameBoard.board[i][j]==null || gameBoard.board[i][j].pieceType!=pieceType)
                diagMatch=false;
        }

        for(int i=0,j=0;i< gameBoard.size;i++,j--)
        {
            if(gameBoard.board[i][j]==null || gameBoard.board[i][j].pieceType!=pieceType)
                antiDiagMatch=false;
        }

        return rowMatch || colMatch || diagMatch || antiDiagMatch;
    }
}
