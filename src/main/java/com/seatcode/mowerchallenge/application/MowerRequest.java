package com.seatcode.mowerchallenge.application;// Created by jhant on 18/11/2022.

import com.seatcode.mowerchallenge.domain.Mower;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MowerRequest
{
    private Mower mower;
    private List<MowerMovementsRequest> mowerMovements;
}
