package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import ladder.NaturalNumber;
class LadderTest {

    @Test
    void 사다리_생성_확인() {
        //given
        NaturalNumber numberOfRows = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5) ;

        //when
        LadderCreator ladder  = new LadderCreator(numberOfRows, numberOfPerson);

        //then
        assertNotNull(ladder);
    }

    @Test
    void 사다리_시작위치_예외_처리() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        NaturalNumber numberOfRows = NaturalNumber.of(1);
        LadderCreator ladder = new LadderCreator(numberOfRows, numberOfPerson);

        //when
        Position position = Position.of(3);

        //then
        assertThrows(IllegalArgumentException.class, () -> ladder.run(Position.of(3)));
    }

    @Test
    void 사다리_결과_확인() {
        //given
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        NaturalNumber numberOfRows =NaturalNumber.of(4) ;
        LadderCreator ladder = new LadderCreator(numberOfRows, numberOfPerson);
        ladder.drawLine(1,0);
        ladder.drawLine(1,2);
        ladder.drawLine(2,1);


        //when
        Position position = Position.of(0);
        LadderRunner ladderRunner = new LadderRunner(ladder.getRows());
        Position resultPosition = ladderRunner.run(position);

        //then
        assertEquals(2, resultPosition);

        //when
        position = Position.of(1);
        resultPosition = ladder.run(position);
        //then
        assertEquals(0, resultPosition);

        //when
        position = Position.of(2);
        resultPosition = ladder.run(position);
        //then
        assertEquals(3, resultPosition);

        //when
        position = Position.of(3);
        resultPosition = ladder.run(position);
        //then
        assertEquals(1, resultPosition);



    }
}