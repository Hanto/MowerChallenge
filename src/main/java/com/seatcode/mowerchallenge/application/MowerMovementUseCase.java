package com.seatcode.mowerchallenge.application;// Created by jhant on 18/11/2022.

import com.seatcode.mowerchallenge.domain.Mower;

import java.util.List;

public class MowerMovementUseCase
{
    public MowerMovementResponse executeMowerMovement(MowerMovementUseCaseCommand command)
    {
        for (MowerRequest mowerRequest: command.getMowers())
        {
            Mower mower = mowerRequest.getMower();
            List<MowerMovementsRequest> movements = mowerRequest.getMowerMovements();

            for (MowerMovementsRequest movementsRequest: movements)
            {
                movementsRequest.executeCommand(mower);
            }

            System.out.println(mower);
        }


        return null;
    }
}
