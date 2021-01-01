package com.company;

/**
 * Marble Class represents a marble in Pentago game.
 *
 * @author Fatemeh Valeh
 */
public class Marble {
    //color of the marble
    private char color;

    /**
     * create a marble with a color
     * @param color color of the marble
     */
    public Marble(char color){
        this.color = color;
    }

    /**
     * @return color of marble
     */
    public char getColor(){
        return color;
    }
}
