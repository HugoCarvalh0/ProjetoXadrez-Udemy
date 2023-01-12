package application;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch match = new ChessMatch();

		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(match.getPieces());
				System.out.println();
				System.out.print("Posicao de origem: ");
				ChessPosition origem = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = match.possibleMoves(origem);
				UI.clearScreen();
				UI.printBoard(match.getPieces(), possibleMoves);

				System.out.println();
				System.out.print("Posicao de destino: ");
				ChessPosition destino = UI.readChessPosition(sc);

				ChessPiece capturedPiece = match.performChessMove(origem, destino);
			} catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}
