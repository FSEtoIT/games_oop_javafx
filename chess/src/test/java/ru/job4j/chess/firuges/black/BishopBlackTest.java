package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    public void whenGetPositionThenReturnSameCell() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell result = bishop.position();
        assertThat(result, is(Cell.C1));
    }

    @Test
    public void whenCopyThenNewFigureWithNewPosition() {
        Figure bishop = new BishopBlack(Cell.C1);
        Figure copy = bishop.copy(Cell.H6);
        assertThat(copy.position(), is(Cell.H6));
    }

    @Test
    public void whenMoveIsImpossibleThenException() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        assertThrows(
                ImpossibleMoveException.class,
                () -> bishop.way(Cell.C2)
        );
    }

    @Test
    public void whenBishopMoveFromC1ToG5ThenCorrectWay() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] result = bishop.way(Cell.G5);

        Cell[] expected = {
                Cell.D2,
                Cell.E3,
                Cell.F4,
                Cell.G5
        };

        assertThat(result, is(expected));
    }
}
