package application;

import chess.ChessPiece;

public class UI {

    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8-i) + " ");
            for (int j = 0 ; j<pieces.length; j++) {
                printPiece(pieces[i][j]);
            }
            System.out.println(); //quebra de linha na matriz ex: linha 8 para 7
        }
        System.out.println("  a b c d e f g h"); // espaço no começo das colunas no terminal
    }
    //imprimir uma peça e se for = nulo nao tinha peça nessa posiççao tabuleiro
    private static void printPiece(ChessPiece piece) {
        if (piece == null) {
            System.out.print("-");
        }
        else {
            System.out.print(piece);
        }
        System.out.print(" ");
    }
}
