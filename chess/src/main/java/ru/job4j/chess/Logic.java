package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Cell[] steps = figures[index].way(dest);
        free(steps, index);
        figures[index] = figures[index].copy(dest);
    }

    private boolean free(Cell[] steps, int figureIndex) throws OccupiedCellException {
        for (int i = 0; i < steps.length - 1; i++) {
            Cell step = steps[i];
            for (int i2 = 0; i2 < figures.length; i2++) {
                if (i2 == figureIndex) {
                    continue; // ⬅ игнорируем фигуру, которая ходит
                }
                Figure figure = figures[i2];
                if (figure != null && figure.position().equals(step)) {
                    throw new OccupiedCellException();
                }
            }
        }
        return true;
    }


    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException("Figure not found on the board.");
    }
}
