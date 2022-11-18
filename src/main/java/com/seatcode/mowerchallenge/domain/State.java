package com.seatcode.mowerchallenge.domain;// Created by jhant on 18/11/2022.

public interface State
{
    String state();
    State turnRight();
    State turnLeft();
    Position move(Position initialPosition);
}