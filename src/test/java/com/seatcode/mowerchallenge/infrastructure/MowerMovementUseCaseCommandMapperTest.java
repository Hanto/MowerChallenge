package com.seatcode.mowerchallenge.infrastructure;

import com.seatcode.mowerchallenge.application.MowerMovementUseCaseCommand;
import com.seatcode.mowerchallenge.application.MowerMovementsRequest;
import com.seatcode.mowerchallenge.domain.Mower;
import com.seatcode.mowerchallenge.domain.Position;
import com.seatcode.mowerchallenge.domain.states.LookingEast;
import com.seatcode.mowerchallenge.domain.states.LookingNorth;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.seatcode.mowerchallenge.application.MowerMovementsRequest.*;
import static org.assertj.core.api.Assertions.assertThat;

class MowerMovementUseCaseCommandMapperTest
{
    @Test
    public void deserialization()
    {
        String input = "5 5\n" +
            "1 2 N\n" +
            "LMLMLMLMM\n" +
            "3 3 E\n" +
            "MMRMMRMRRM\n";

        MowerMovementUseCaseCommandMapper mapper = new MowerMovementUseCaseCommandMapper();
        MowerMovementUseCaseCommand command = mapper.fromString(input);

        Mower mower1 = command.getMowers().get(0).getMower();
        Mower mower2 = command.getMowers().get(1).getMower();
        List<MowerMovementsRequest> mower1Movements = command.getMowers().get(0).getMowerMovements();
        List<MowerMovementsRequest> mower2Movements = command.getMowers().get(1).getMowerMovements();


        assertThat(command.getPlateau()).isEqualTo(new Position(5, 5));
        assertThat(command.getMowers()).hasSize(2);
        assertThat(mower1.getPosition()).isEqualTo(new Position(1, 2));
        assertThat(mower2.getPosition()).isEqualTo(new Position(3, 3));
        assertThat(mower1.getState()).isInstanceOf(LookingNorth.class);
        assertThat(mower2.getState()).isInstanceOf(LookingEast.class);

        assertThat(mower1Movements).isEqualTo(Arrays.asList(L, M, L, M, L, M, L, M, M));
        assertThat(mower2Movements).isEqualTo(Arrays.asList(M, M, R, M, M, R, M, R, R, M));

    }
}