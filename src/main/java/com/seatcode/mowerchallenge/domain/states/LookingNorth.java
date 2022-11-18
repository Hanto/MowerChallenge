package com.seatcode.mowerchallenge.domain.states;// Created by jhant on 18/11/2022.

import com.seatcode.mowerchallenge.domain.Position;
import com.seatcode.mowerchallenge.domain.State;

public class LookingNorth implements State
{
    @Override
    public String state()
    {
        return "N";
    }

    @Override
    public State turnRight()
    {
        return new LookingEast();
    }

    @Override
    public State turnLeft()
    {
        return new LookingWest();
    }

    @Override
    public Position move(Position initialPosition)
    {
        return new Position(initialPosition.getX(), initialPosition.getY() + 1);
    }
}
