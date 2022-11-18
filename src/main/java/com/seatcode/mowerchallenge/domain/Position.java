package com.seatcode.mowerchallenge.domain;// Created by jhant on 18/11/2022.

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@Value @AllArgsConstructor @EqualsAndHashCode @ToString
public class Position
{
    int x;
    int y;
}
