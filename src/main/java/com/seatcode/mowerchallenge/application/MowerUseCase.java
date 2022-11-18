package com.seatcode.mowerchallenge.application;// Created by jhant on 18/11/2022.

import com.seatcode.mowerchallenge.domain.Mower;
import com.seatcode.mowerchallenge.infrastructure.Movement;

import java.util.List;

public class MowerUseCase
{
    public MowerResponse executeMowerMovement(MowerCommand command)
    {
        for (MowerInputs mowerInputs : command.getMowers())
        {
            Mower mower = new Mower(mowerInputs.getInitialDirection().getState(), mowerInputs.getInitialPosition());
            List<Movement> movements = mowerInputs.getMowerMovements();

            for (Movement movementsRequest: movements)
            {
                movementsRequest.executeCommand(mower);
            }

            System.out.println(mower);
        }


        return null;
    }
}
