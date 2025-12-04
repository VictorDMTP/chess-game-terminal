package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    //metodo piece que vai retornar uma peça recebendo linha e coluna e uma sobrecarga dele que recebe a position

    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("postion not on the board");
        }
        return pieces[row][column];
    }
    //retorna a peça peka posição
    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("postion not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position" +  position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position) {
        if(!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        //cse a peça naquela posição for nulo entao retorna nulo = nao tem peça alhi
        if (piece(position) == null) {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }


    //metodo auxiliar para testar pela linha e coluna mais facil que posição as vezes
    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }
    //caso diferente de nulo significa que tem uma peça alhi
    //antes de testar o thereIsAPiece ele ja testa se a posição existe se nao ele para
    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("postion not on the board");
        }
       return piece(position) != null;
    }
}
