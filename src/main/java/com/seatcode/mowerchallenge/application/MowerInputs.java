package com.seatcode.mowerchallenge.application;// Created by jhant on 18/11/2022.

import com.seatcode.mowerchallenge.domain.Position;
import com.seatcode.mowerchallenge.infrastructure.Direction;
import com.seatcode.mowerchallenge.infrastructure.Movement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MowerInputs
{
    private Position initialPosition;
    private Direction initialDirection;
    private List<Movement> mowerMovements;
}
