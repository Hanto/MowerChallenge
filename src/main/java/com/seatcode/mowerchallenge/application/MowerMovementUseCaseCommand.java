package com.seatcode.mowerchallenge.application;// Created by jhant on 18/11/2022.

import com.seatcode.mowerchallenge.domain.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class MowerMovementUseCaseCommand
{
    private Position plateau;
    private List<MowerRequest>mowers;

}
