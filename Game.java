package com.company;


import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Game class represents a Pentago game.
 * It stores board game and marbles and have essential methods according to Pentago rules.
 *
 * @author Fatemeh Valeh
 */
public class Game {
    //main board, empty slots are 0, black is 1 and white is 2
    private int [][] board;
    //visual board shown with white and black circles(marble)
    private Marble[][] visualBoard;
    //black marble is black circle
    private char black = (char) 9679;
    //white marble is white circle
    private char white = (char) 128308;
    //right arrow curving left emojy
    private char clockWSign = (char) 8617;
    //left arrow curving right emojy
    private char couClockWSign = (char) 8618;

    /**
     * creates new game, new board
     */
    public Game(){
        board = new int[6][6];
        visualBoard = new Marble[6][6];

    }

    /**
     * this method convert a char standing for a player to it's int number, 1 for black player, 2 for white player
     * @param player char player want to change
     * @return corresponding int to the player, 1 or 2
     */
    public int convertCharToInt(char player){
        if (player == black){
            return 1;
        }
        else {
            return 2;
        }
    }

    /**
     * checks if a slot is empty so one can put a marble
     * @param x x position of slot in board
     * @param y y position of slot in board
     * @return true if slot is empty, false otherwise
     */
    public boolean isEmpty(int x, int y){
        if (board[y][x] == 0)
            return true;
        else{
            System.out.println("This slot is occupied :\\");
            return false;
        }
    }

    /**
     * updates visual board according to ints in board with marbles
     */
    public void updateVisualBoard(){
        for (int i=0; i<6; i++){
            for (int j=0; j<6; j++){
                if (board[i][j] == 1){
                    visualBoard[i][j] = new Marble(black);
                }
                if (board[i][j] == 2){
                    visualBoard[i][j] = new Marble(white);
                }
                if (board[i][j] == 0){
                    visualBoard[i][j] = null;
                }
            }
        }
    }

    /**
     * get a marble and it's position in board and put it in the board
     * @param marble char that represents color of marble
     * @param x x position in board
     * @param y y position in board
     */
    public void putMarble(char marble, int x, int y){
        if (isEmpty(x,y)){
            int player = convertCharToInt(marble);
            board[y][x] = player;
        }
    }

    /**
     * indicates who wins the game when 5 marbles of one color occur vertically, horizontally or diagonally
     * @return 3 if there is no winner, 1 if black wins, 2 if white wins
     */
    public int winner(){
        int winner = 0;
        int blackWin = 0;
        int whiteWin = 0;
        //horizontal
        for (int i=0; i<6; i++){
            if ( (board[i][0] == 1 && board[i][1] == 1 && board[i][2] == 1 && board[i][3] == 1 && board[i][4] == 1) || (board[i][1] == 1 && board[i][2] == 1 && board[i][3] == 1 && board[i][4] == 1 && board[i][5] == 1) )
                blackWin = 1;
            if ( (board[i][0] == 2 && board[i][1] == 2 && board[i][2] == 2 && board[i][3] == 2 && board[i][4] == 2) || (board[i][1] == 2 && board[i][2] == 2 && board[i][3] == 2 && board[i][4] == 2 && board[i][5] == 2) )
                whiteWin = 1;
        }
        //vertical
        for (int i=0; i<6; i++){
            if ( (board[0][i] == 1 && board[1][i] == 1 && board[2][i] == 1 && board[3][i] == 1 && board[4][i] == 1) || (board[1][i] == 1 && board[2][i] == 1 && board[3][i] == 1 && board[4][i] == 1 && board[5][i] == 1) )
                blackWin = 1;
            if ( (board[0][i] == 2 && board[1][i] == 2 && board[2][i] == 2 && board[3][i] == 2 && board[4][i] == 2) || (board[1][i] == 2 && board[2][i] == 2 && board[3][i] == 2 && board[4][i] == 2 && board[5][i] == 2) )
                whiteWin = 1;
        }
        //diagonal
        if (board[1][0] == 1 && board[2][1] == 1 && board[3][2] == 1 && board[4][3] == 1 && board[5][4] == 1)
            blackWin = 1;
        if (board[1][0] == 2 && board[2][1] == 2 && board[3][2] == 2 && board[4][3] == 2 && board[5][4] == 2)
            whiteWin = 1;

        if ( (board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1 && board[3][3] == 1 && board[4][4] == 1) || (board[1][1] == 1 && board[2][2] == 1 && board[3][3] == 1 && board[4][4] == 1 && board[5][5] == 1 ) )
            blackWin = 1;
        if ( (board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2 && board[3][3] == 2 && board[4][4] == 2) || (board[1][1] == 2 && board[2][2] == 2 && board[3][3] == 2 && board[4][4] == 2 && board[5][5] == 2 ) )
            whiteWin = 1;

        if (board[0][1] == 1 && board[1][2] == 1 && board[2][3] == 1 && board[3][4] == 1 && board[4][5] == 1)
            blackWin = 1;
        if (board[0][1] == 2 && board[1][2] == 2 && board[2][3] == 2 && board[3][4] == 2 && board[4][5] == 2)
            whiteWin = 1;


        if (board[4][0] == 1 && board[3][1] == 1 && board[2][2] == 1 && board[1][3] == 1 && board[0][4] == 1)
            blackWin = 1;
        if (board[4][0] == 2 && board[3][1] == 2 && board[2][2] == 2 && board[1][3] == 2 && board[0][4] == 2)
            whiteWin = 1;

        if ((board[5][0] == 1 && board[4][1] == 1 && board[3][2] == 1 && board[2][3] == 1 && board[1][4] == 1) || (board[4][1] == 1 && board[3][2] == 1 && board[2][3] == 1 && board[1][4] == 1 && board[0][5] == 1 ))
            blackWin = 1;
        if ((board[5][0] == 2 && board[4][1] == 2 && board[3][2] == 2 && board[2][3] == 2 && board[1][4] == 2) || (board[4][1] == 2 && board[3][2] == 2 && board[2][3] == 2 && board[1][4] == 2 && board[0][5] == 2 ))
            whiteWin = 1;

        if (board[5][1] == 1 && board[4][2] == 1 && board[3][3] == 1 && board[2][4] == 1 && board[1][5] == 1)
            blackWin = 1;
        if (board[5][1] == 2 && board[4][2] == 2 && board[3][3] == 2 && board[2][4] == 2 && board[1][5] == 2)
            whiteWin = 1;

        if (blackWin!=0 && whiteWin!=0){
            winner = 3; //game is draw
        }
        else if (blackWin!=0)
            winner = 1;
        else if (whiteWin!=0)
            winner = 2;

        return winner;

    }

    /**
     * give the column user want to put marble
     * @param column char that user entered
     * @return int corresponding to column
     */
    public int getColumn( char column){
        int res = -1;
        switch (column){
            case 'a':
                res = 0;
                break;
            case 'b':
                res = 1;
                break;
            case 'c':
                res = 2;
                break;
            case 'd':
                res = 3;
                break;
            case 'e':
                res = 4;
                break;
            case 'f':
                res = 5;
                break;
        }
        return res;
    }

    /**
     * change player turn in game, get a character and change it to another one
     * @param player current player
     * @return next player
     */
    public char changeTurn( char player ){
        if (player == black){
            return white;
        }
        else
            return black;
    }

    /**
     * check the board if it still has room so one can put marble
     * @return true if capacity remain, false if board is full
     */
    public boolean hasRoom(){
        boolean res = false;
        for (int i=0; i<6; i++){
            for (int j=0; j<6; j++){
                if (board[i][j] == 0){
                    res = true;
                }
            }
        }
        if (!res){
            System.out.println("Bord fulled");
        }
        return res;
    }

    /**
     * this method rotate clockwise a quarter in main board represented by a letter,A , B , C or D
     * @param boardToRotate board want to rotate
     */
    public void rotateClockW(char boardToRotate){
        int[][] tmp = new int[3][3]; //keep one quarter rotation

        if (boardToRotate == 'A'){
            //rotate board A and put it in tmp
            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    tmp[j][2-i] = board[i][j];
                    //board[i][j] = 0;
                }
            }
            //put back tmp in main board
            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    board[i][j] = tmp[i][j];
                }
            }
        }

        if (boardToRotate == 'B'){
            //rotate board B and put it in tmp
            for (int i=0; i<3; i++){
                for (int j=3; j<6; j++){
                    tmp[j-3][2-i] = board[i][j];
                    board[i][j] = 0;
                }
            }
            //put tmp back in main board
            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    board[i][j+3] = tmp[i][j];
                }
            }
        }

        if (boardToRotate == 'C'){
            //rotate board C and put it in tmp
            for (int i=0; i<3; i++){
                for (int j=3; j<6; j++){
                    tmp[j-3][2-i] = board[3+i][j];
                    board[3+i][j] = 0;
                }
            }
            //put tmp back in main board
            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    board[i+3][j+3] = tmp[i][j];
                }
            }
        }

        if (boardToRotate == 'D'){
            //rotate board D and put in tmp
            for (int i=3; i<6; i++){
                for (int j=0; j<3; j++){
                    tmp[j][5-i] = board[i][j];
                    board[i][j] = 0;
                }
            }
            //put tmp back in main board
            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    board[3+i][j] = tmp[i][j];
                }
            }
        }


    }

    /**
     * this method rotate counter clockwise a quartet in main board represented by a letter A, B , C or D
     * @param board board want to rotate
     */
    public void rotateCounterClockW(char board){
        rotateClockW(board);
        rotateClockW(board);
        rotateClockW(board);
    }

    /**
     * the main method of Pentago game, put a marble, rotate a quarter, check if one wins and change turn of players
     */
    public void playPentago(){

        //first player chosen random
        int m = new Random().nextInt(2);
        char player = ' ';
        switch (m){
            case 0:
                player = black;
                break;
            case 1:
                player = white;
                break;
        }

        System.out.println("Game starts with '" + player + "'.");
        System.out.println("Chose a slot to put your marble using an integer and a letter e.g. '2 c'. Then choose a board and a direction to rotate it e.g 'A 1' rotates Board A clockwise.");
        displayBoard();

        //scan from console
        Scanner sc = new Scanner(System.in);
        while (hasRoom()) { //game continues while there is empty rooms to put marble
            int x, y;
            x = y = 9;
            int flag = 1;
            while (flag!=0) { //check if input is wrong, try again
                System.out.println("'" + player + "' TURN; Put a marble:");

                String line = sc.nextLine();
                StringTokenizer tk = new StringTokenizer(line, " ");
                 y = Integer.parseInt(tk.nextToken()) - 1; // array index starts form 0
                 x = getColumn(tk.nextToken().charAt(0));
                 flag = 0;
                if (x < 0 || y < 0 || x > 5 || y > 5) {
                    flag = 1;
                    System.out.println("Invalid input. Try again");
                }
            }
            putMarble(player, x, y);
            displayBoard();

            //check if one wins by putting a marble
            if (winner() != 0) {
                if (winner() == 1) {
                    System.out.println("'" + black + "' WON the game :)");
                } else if (winner() == 2){
                    System.out.println("'" + white + "' WON the game :)");
                }
                else {
                    System.out.println("Draw game.");
                }
                return;
            }

            System.out.println("'" + player + "' TURN; Rotate a Board:");
            System.out.println("A)Board A   B)Board B   C)Board C   D)Board D");
            System.out.println("1) " + clockWSign + "    2) " + couClockWSign);
            int foo = 1;
            char boardSelected = 0;
            int directionSelected = 0;
            //scan from console for rotation
            while (foo != 0) { //getting correct input from user
                String line = sc.nextLine();
                StringTokenizer stTok = new StringTokenizer(line, " ");

                boardSelected = stTok.nextToken().charAt(0);
                directionSelected = Integer.parseInt(stTok.nextToken());

                System.out.println("board: " + boardSelected + "dir: " + directionSelected);
                foo = 0;
                if ( (directionSelected!=2 && directionSelected!=1) || (boardSelected!='A' && boardSelected!='B' && boardSelected!='C' && boardSelected!='D') ){
                    foo = 1;
                    System.out.println("Invalid input. Please try again.");
                }
            }
            //rotate selected board in selected direction, clockwise or counter clockwise
            if (directionSelected == 1){
                rotateClockW(boardSelected);
            }
            else if (directionSelected == 2){
                rotateCounterClockW(boardSelected);
            }

            displayBoard();

            //check if one wins by rotating a board
            if (winner() != 0) {
                if (winner() == 1) {
                    System.out.println("'" + black + "' WON the game :)");
                } else if (winner() == 2){
                    System.out.println("'" + white + "' WON the game :)");
                }
                else {
                    System.out.println("Draw game.");
                }
                return;
            }
            //change player turn
            player = changeTurn(player);
        }

    }

    /**
     * this method display the board of the game
     */
    public void displayBoard(){
        updateVisualBoard();
        System.out.println("   Bard A   Board B");
        System.out.println("  a  b  c   d  e  f");
        int line = 1;
        for (int i=0; i<6; i++){

            if (i==3){
                System.out.println("  -----------------");
                System.out.print(line++);
            }
            if (i!=3){
                System.out.print(line++);
            }
            for (int j=0; j<6; j++){

                if (j==3){
                    System.out.print("|");
                }
                if (visualBoard[i][j]!=null){
                    System.out.print(" " + visualBoard[i][j].getColor() + " ");
                }
                else {
                    System.out.print(" " + "+" + " ");
                }

            }

            System.out.println();
        }
        System.out.println("   Bard D   Board C");

    }
}
