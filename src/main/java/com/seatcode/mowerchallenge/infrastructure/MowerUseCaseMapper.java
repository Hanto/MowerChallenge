package com.seatcode.mowerchallenge.infrastructure;// Created by jhant on 18/11/2022.

import com.seatcode.mowerchallenge.application.MowerCommand;
import com.seatcode.mowerchallenge.application.MowerInputs;
import com.seatcode.mowerchallenge.domain.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class MowerUseCaseMapper
{
    public MowerCommand fromString(String string)
    {
        List<String> lines = Arrays.asList(string.split("\n"));

        return MowerCommand.builder()
            .plateau(retrievePlateau(lines))
            .mowers(retrieveMowersInputs(lines))
            .build();
    }

    // HELPER
    //--------------------------------------------------------------------------------------------------------

    private Position retrievePlateau(List<String>lines)
    {
        String firstLine = lines.get(0);

        List<Integer> positionList = Stream.of(firstLine.split(" "))
            .map(Integer::parseInt).toList();

        return new Position(positionList.get(0), positionList.get(1));
    }

    private List<MowerInputs> retrieveMowersInputs(List<String>lines)
    {
        lines.remove(0);

        List<MowerInputs> mowerInputs = new ArrayList<>();

        for (int i=0; i < lines.size(); i = i + 2)
        {
            String mowerPositionAndDirection = lines.get(i);
            String mowerMovements = lines.get(i+1);

            MowerInputs mowerInput = retrieveMowerInputs(mowerPositionAndDirection, mowerMovements);
            mowerInputs.add(mowerInput);
        }

        return mowerInputs;
    }

    private MowerInputs retrieveMowerInputs(String mowerPositionAndState, String mowerCommands)
    {
        List<String> positionAndState = Stream.of(mowerPositionAndState.split(" ")).toList();

        Position initialPosition = new Position(parseInt(positionAndState.get(0)), parseInt(positionAndState.get(1)));
        Direction initialDirection = Direction.valueOf(positionAndState.get(2));

        List<Movement>movementsRequests = Stream.of(mowerCommands.split(""))
            .map(Movement::valueOf).toList();

        return MowerInputs.builder()
            .initialPosition(initialPosition)
            .initialDirection(initialDirection)
            .mowerMovements(movementsRequests)
            .build();
    }
}