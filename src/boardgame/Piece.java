package boardgame;

public abstract class Piece {

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

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMoves();   //matriz booleana que verifica se o movimento da peca e possivel, ent vai ter verdadeiro onde for possivel
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] == true) {
                    return true;
                }
            }
        }
        return false;
    }
}


