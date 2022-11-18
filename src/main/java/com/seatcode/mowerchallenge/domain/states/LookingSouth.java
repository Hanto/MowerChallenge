package com.seatcode.mowerchallenge.domain.states;// Created by jhant on 18/11/2022.

import com.seatcode.mowerchallenge.domain.Position;
import com.seatcode.mowerchallenge.domain.State;

public class LookingSouth implements State
{
    @Override
    public String state()
    {
        return "S";
    }

    @Override
    public State turnRight()
    {
        return new LookingWest();
    }

    @Override
    public State turnLeft()
    {
        return new LookingEast();
    }

    @Override
    public Position move(Position initialPosition)
    {
        return new Position(initialPosition.getX(), initialPosition.getY() - 1);
    }
}
