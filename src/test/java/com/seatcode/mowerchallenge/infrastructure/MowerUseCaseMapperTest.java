package com.seatcode.mowerchallenge.infrastructure;

import com.seatcode.mowerchallenge.application.MowerCommand;
import com.seatcode.mowerchallenge.domain.Position;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.seatcode.mowerchallenge.infrastructure.Movement.*;
import static org.assertj.core.api.Assertions.assertThat;

class MowerUseCaseMapperTest
{
    @Test
    public void deserialization()
    {
        String input = "5 5\n" +
            "1 2 N\n" +
            "LMLMLMLMM\n" +
            "3 3 E\n" +
            "MMRMMRMRRM\n";

        MowerUseCaseMapper mapper = new MowerUseCaseMapper();
        MowerCommand command = mapper.fromString(input);


        List<Movement> mower1Movements = command.getMowers().get(0).getMowerMovements();
        List<Movement> mower2Movements = command.getMowers().get(1).getMowerMovements();


        assertThat(command.getPlateau()).isEqualTo(new Position(5, 5));
        assertThat(command.getMowers()).hasSize(2);

        assertThat(mower1Movements).isEqualTo(Arrays.asList(L, M, L, M, L, M, L, M, M));
        assertThat(mower2Movements).isEqualTo(Arrays.asList(M, M, R, M, M, R, M, R, R, M));

    }
}