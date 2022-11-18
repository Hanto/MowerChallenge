package com.seatcode.mowerchallenge.infrastructure;// Created by jhant on 18/11/2022.

import com.seatcode.mowerchallenge.application.MowerMovementUseCase;
import com.seatcode.mowerchallenge.application.MowerMovementUseCaseCommand;

public class Main
{


    public static void main(String...args)
    {
        //String input = args[0];

        String input = "5 5\n" +
            "1 2 N\n" +
            "LMLMLMLMM\n" +
            "3 3 E\n" +
            "MMRMMRMRRM\n";

        MowerMovementUseCaseCommandMapper mapper = new MowerMovementUseCaseCommandMapper();
        MowerMovementUseCase useCase = new MowerMovementUseCase();

        MowerMovementUseCaseCommand command = mapper.fromString(input);
        useCase.executeMowerMovement(command);
    }
}
