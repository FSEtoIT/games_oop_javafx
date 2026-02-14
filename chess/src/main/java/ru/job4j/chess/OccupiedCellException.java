package ru.job4j.chess;

public class OccupiedCellException extends RuntimeException {
    public OccupiedCellException(String message) {
        super(message);
    }
}
