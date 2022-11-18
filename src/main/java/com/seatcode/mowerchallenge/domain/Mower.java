package com.seatcode.mowerchallenge.domain;// Created by jhant on 18/11/2022.

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Getter @Builder @EqualsAndHashCode @ToString
public class Mower
{
    private State state;
    private Position position;

    public void turnLeft()
    {
        state = state.turnLeft();
    }

    public void turnRight()
    {
        state = state.turnRight();
    }

    public void move()
    {
        position = state.move(position);
    }

    @Override
    public String toString()
    {
        return position.getX() + " " + position.getY() + " " + state.state();
    }
}
