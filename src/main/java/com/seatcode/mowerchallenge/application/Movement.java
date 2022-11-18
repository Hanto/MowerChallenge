package com.seatcode.mowerchallenge.application;// Created by jhant on 18/11/2022.

import com.seatcode.mowerchallenge.domain.Mower;

public enum Movement
{
    L{
        @Override
        public void executeCommand(Mower mower)
        {
            mower.turnLeft();
        }
    },
    R{
        @Override
        public void executeCommand(Mower mower)
        {
            mower.turnRight();
        }
    },
    M{
        @Override
        public void executeCommand(Mower mower)
        {
            mower.move();
        }
    };

    public abstract void executeCommand(Mower mower);
}
