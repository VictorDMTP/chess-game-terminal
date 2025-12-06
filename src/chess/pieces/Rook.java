package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import  chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "♜";
    }

    @Override
    public boolean[][] possibleMoves() {
        //matriz temporaria
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //pra cima
        p.setValues(position.getRow() - 1,position.getColumn()); // -1 e porque estou pegando sempre a position acima dessa peca
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))  //enquanto nao tiver nada na posicao marca ela como verdadeira
        {
            mat[p.getRow()][p.getColumn()] = true; //marca a posicao da matriz como verdadeira logo a peca pode ir pra la
            p.setRow(p.getRow() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //Baixo
        p.setValues(position.getRow() + 1,position.getColumn()); // -1 e porque estou pegando sempre a position acima dessa peca
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))  //enquanto nao tiver nada na posicao marca ela como verdadeira
        {
            mat[p.getRow()][p.getColumn()] = true; //marca a posicao da matriz como verdadeira logo a peca pode ir pra la
            p.setRow(p.getRow() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }


        //esquerda
        p.setValues(position.getRow() ,position.getColumn() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //direita
        p.setValues(position.getRow() ,position.getColumn() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
        {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        return mat;
    }
}