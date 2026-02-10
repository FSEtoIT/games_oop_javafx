package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LogicTest {

    @Test
    public void whenMoveFigureThenSuccess() throws Exception {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));

        logic.move(Cell.C1, Cell.G5);
    }

    @Test
    public void whenFigureNotFoundThenException() {
        Logic logic = new Logic();

        assertThrows(
                FigureNotFoundException.class,
                () -> logic.move(Cell.C1, Cell.G5)
        );
    }

    @Test
    public void whenImpossibleMoveThenException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));

        assertThrows(
                ImpossibleMoveException.class,
                () -> logic.move(Cell.C1, Cell.C2)
        );
    }

    @Test
    public void whenWayIsOccupiedThenException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.D2)); // стоит на пути

        assertThrows(
                OccupiedCellException.class,
                () -> logic.move(Cell.C1, Cell.G5)
        );
    }

    @Test
    public void whenCleanThenBoardIsEmpty() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.clean();

        assertThrows(
                FigureNotFoundException.class,
                () -> logic.move(Cell.C1, Cell.G5)
        );
    }
}
