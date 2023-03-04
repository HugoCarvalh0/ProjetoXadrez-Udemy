package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch match = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();

		while (!match.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(match, captured);
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
				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}

				if (match.getPromoted() != null) {
					System.out.print("Digite a peca para promover seu peao (B/N/R/Q):");
					String type = sc.nextLine().toUpperCase();
					while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
						System.out.print("Peca Invalida!! Digite a peca para promover seu peao (B/N/R/Q):");
						type = sc.nextLine().toUpperCase();
					}
					match.replacePromotedPiece(type);
				}

			} catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(match, captured);
	}
}
