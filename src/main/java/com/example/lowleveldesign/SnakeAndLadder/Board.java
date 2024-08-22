package com.example.lowleveldesign.SnakeAndLadder;

import javafx.scene.control.skin.CellSkinBase;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    public Board(int boardSize,int numberOfSnakes,int numberOfLadders) {
        initializeCells(boardSize);
        addSnakesAndLadders(cells,numberOfSnakes,numberOfLadders);
    }

    public void initializeCells(int boardSize)
    {
        cells=new Cell[boardSize][boardSize];

        for(int i=0;i<boardSize;i++)
        {
            for(int j=0;j<boardSize;j++)
            {
                Cell cellObj=new Cell();
                cells[i][j]=cellObj;
            }
        }
    }

    public void addSnakesAndLadders(Cell[][] cells, int numberOfSnakes,int numberOfLadders)
    {
        while(numberOfSnakes>0)
        {
            int snakeHead= ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1);
            int snakeTail= ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1);

            if(snakeTail>=snakeHead)
                continue;

            Jump snakeObj=new Jump();
            snakeObj.start=snakeHead;
            snakeObj.end=snakeTail;

            Cell cell=getCell(snakeHead);
            cell.jump=snakeObj;

            numberOfSnakes--;
        }

        while(numberOfLadders>0)
        {
            int ladderHead= ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1);
            int ladderTail= ThreadLocalRandom.current().nextInt(1, cells.length* cells.length-1);

            if(ladderTail>=ladderHead)
                continue;

            Jump snakeObj=new Jump();
            snakeObj.start=ladderHead;
            snakeObj.end=ladderTail;

            Cell cell=getCell(ladderHead);
            cell.jump=snakeObj;

            numberOfLadders--;
        }
    }

    Cell getCell(int playPosition)
    {
        int row=playPosition/ cells.length;
        int col=playPosition% cells.length;

        return cells[row][col];
    }
}
