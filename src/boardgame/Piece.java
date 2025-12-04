package boardgame;

public class Piece {

    protected Position position;
    private Board board;

    //a posição de uma peça recem criada sera nula no caso nao foi colocada no tabuleiro aionda

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return board;
    }
    //nao tem set prq o tabuleiro nao pode ser alterado
}
