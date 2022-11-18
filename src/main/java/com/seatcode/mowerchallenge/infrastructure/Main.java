package com.seatcode.mowerchallenge.infrastructure;// Created by jhant on 18/11/2022.

import com.seatcode.mowerchallenge.application.MowerUseCase;
import com.seatcode.mowerchallenge.application.MowerCommand;

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
        MowerUseCase useCase = new MowerUseCase();

        MowerCommand command = mapper.fromString(input);
        useCase.executeMowerMovement(command);
    }
}
