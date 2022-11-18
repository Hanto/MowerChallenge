package com.seatcode.mowerchallenge.domain.states;// Created by jhant on 18/11/2022.

import com.seatcode.mowerchallenge.domain.Position;
import com.seatcode.mowerchallenge.domain.State;

public class LookingEast implements State
{
    @Override
    public String state()
    {
        return "E";
    }

    @Override
    public State turnRight()
    {
        return new LookingSouth();
    }

    @Override
    public State turnLeft()
    {
        return new LookingNorth();
    }

    @Override
    public Position move(Position initialPosition)
    {
        return new Position(initialPosition.getX() +1, initialPosition.getY());
    }
}
