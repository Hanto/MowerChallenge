package com.seatcode.mowerchallenge.infrastructure;// Created by jhant on 18/11/2022.

import com.seatcode.mowerchallenge.domain.State;
import com.seatcode.mowerchallenge.domain.states.LookingEast;
import com.seatcode.mowerchallenge.domain.states.LookingNorth;
import com.seatcode.mowerchallenge.domain.states.LookingSouth;
import com.seatcode.mowerchallenge.domain.states.LookingWest;

public enum MowerDirectionRequest
{
    N{
        @Override
        public State getState()
        {
            return new LookingNorth();
        }
    },
    S{
        @Override
        public State getState()
        {
            return new LookingSouth();
        }
    },
    E{
        @Override
        public State getState()
        {
            return new LookingEast();
        }
    },
    W{
        @Override
        public State getState()
        {
            return new LookingWest();
        }
    };

    public abstract State getState();
}
