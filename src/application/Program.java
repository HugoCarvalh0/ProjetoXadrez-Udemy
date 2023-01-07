package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch match = new ChessMatch();

		while (true) {
			UI.printBoard(match.getPieces());
			System.out.println();
			System.out.print("Posicao de origem: ");
			ChessPosition origem= UI.readChessPosition(sc);
			
			System.out.println();
			System.out.print("Posicao de destino: ");
			ChessPosition destino = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = match.performChessMove(origem, destino);
		}
	}
}
