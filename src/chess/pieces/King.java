package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "♔";
    }

    @Override
    public boolean [][] possibleMoves () {
        //matriz temporaria retorna tudo falso,como se estivesse preso a peca
        return new boolean[getBoard().getRows()][getBoard().getColumns()];
    }
}
