package com.example.lowleveldesign.SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {

    Board board;
    Dice dice;
    Deque<Player> players;
    Player winner;

    public Game() {
        initializeGame();
    }

    private void initializeGame()
    {
        board =new Board(10,5,4);
        dice=new Dice(1);
        winner=null;
        addPlayers();
        players=new LinkedList<>();
    }

    private void addPlayers()
    {
        players.add(new Player("P1",0));
        players.add(new Player("P2",0));
    }

    public void startGame()
    {
        while(winner==null)
        {
            Player playerTurn=findPlayerTurn();
            System.out.println("The Player turn is"+playerTurn.id+"Current Position is"+ playerTurn.currentPosition);

            int diceNumbers=dice.rollDice();
            int playerNewPosition= playerTurn.currentPosition+diceNumbers;

            playerNewPosition=jumpCheck(playerNewPosition);

            playerTurn.currentPosition=playerNewPosition;

            System.out.println("The Player turn is"+playerTurn.id+"Current Position is"+ playerNewPosition);

            if(playerNewPosition>=board.cells.length*board.cells.length-1)
                winner=playerTurn;

            System.out.println("Winner is"+ winner.id);
        }
    }

    private Player findPlayerTurn()
    {
        Player playerTurn=players.removeFirst();
        players.addLast(playerTurn);
        return playerTurn;
    }

    private int jumpCheck(int playerNewPosition)
    {
        if(playerNewPosition>board.cells.length*board.cells.length-1)
            return playerNewPosition;
        Cell cell= board.getCell(playerNewPosition);

        if(cell.jump!=null && cell.jump.start==playerNewPosition)
        {
            String jumpBy=(cell.jump.start<cell.jump.end)?"Ladder":"Snake";
            System.out.println("Jump done by"+jumpBy);
            return cell.jump.end;
        }

        return playerNewPosition;
    }
}
