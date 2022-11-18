package com.seatcode.mowerchallenge.infrastructure;// Created by jhant on 18/11/2022.

import com.seatcode.mowerchallenge.application.MowerMovementUseCaseCommand;
import com.seatcode.mowerchallenge.application.MowerMovementsRequest;
import com.seatcode.mowerchallenge.application.MowerRequest;
import com.seatcode.mowerchallenge.domain.Mower;
import com.seatcode.mowerchallenge.domain.Position;
import com.seatcode.mowerchallenge.domain.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class MowerMovementUseCaseCommandMapper
{
    public MowerMovementUseCaseCommand fromString(String string)
    {
        List<String> lines = Arrays.asList(string.split("\n"));

        return MowerMovementUseCaseCommand.builder()
            .plateau(retrievePlateau(lines))
            .mowers(retrieveMowerRequests(lines))
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

    private List<MowerRequest>retrieveMowerRequests(List<String>lines)
    {
        List<String>mowerLines = new ArrayList<>(lines);
        mowerLines.remove(0);

        List<MowerRequest>mowerRequests = new ArrayList<>();

        for (int i=0; i < mowerLines.size(); i = i + 2)
        {
            String mowerPosition = mowerLines.get(i);
            String mowerCommands = mowerLines.get(i+1);

            MowerRequest mowerRequest = retrieveMowerRequest(mowerPosition, mowerCommands);
            mowerRequests.add(mowerRequest);
        }

        return mowerRequests;
    }

    private MowerRequest retrieveMowerRequest(String mowerPositionAndState, String mowerCommands)
    {
        List<String> positionAndState = Stream.of(mowerPositionAndState.split(" ")).toList();

        Position initialPosition = new Position(parseInt(positionAndState.get(0)), parseInt(positionAndState.get(1)));
        State initialState = MowerDirectionRequest.valueOf(positionAndState.get(2)).getState();
        Mower mower = new Mower(initialState, initialPosition);

        List<MowerMovementsRequest>movementsRequests = Stream.of(mowerCommands.split(""))
            .map(MowerMovementsRequest::valueOf).toList();

        return MowerRequest.builder()
            .mower(mower)
            .mowerMovements(movementsRequests)
            .build();
    }
}