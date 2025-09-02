package d250527.b1018;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // [문제 분석]
    // 체스판의 크기는 8x8 + 서로 만나는 칸끼리는 반드시 다른 색이어야 함
    // => 올바른 체스판은 다음 두 가지 뿐

    // WBWBWBWB BWBWBWBW
    // BWBWBWBW WBWBWBWB
    // WBWBWBWB BWBWBWBW
    // BWBWBWBW WBWBWBWB
    // WBWBWBWB BWBWBWBW
    // BWBWBWBW WBWBWBWB
    // WBWBWBWB BWBWBWBW
    // BWBWBWBW WBWBWBWB

    // 주어진 보드를 8x8 크기의 틀에 맞춰서 복제한 후 해당 부분을 올바른 체스판 두 가지와 직접 비교하기
    // 보드의 크기가 MxN일 때 (M - 7) x (N - 7)개의 8x8 복제 체스판 생성

    char[][] chessBoard = new char[scanner.nextInt()][scanner.nextInt()];
    scanner.nextLine();
    for (int i = 0; i < chessBoard.length; i++) {
      String line = scanner.nextLine();

      for (int j = 0; j < chessBoard[i].length; j++) {
        chessBoard[i][j] = line.charAt(j);
      }
    }

    // 8x8 체스판을 복제하고 올바른 두 가지 체스판과 비교
    int minimumChange = Integer.MAX_VALUE;
    for (int i = 0; i < chessBoard.length - 7; i++) {
      for (int j = 0; j < chessBoard[i].length - 7; j++) {
        char[][] newBoard = set8x8Board(chessBoard, i, j);

        int resultWB = compareWB(newBoard);
        int resultBW = compareBW(newBoard);

        if (resultWB < minimumChange) minimumChange = resultWB;
        if (resultBW < minimumChange) minimumChange = resultBW;
      }
    }

    System.out.println(minimumChange);
  }

  // set8x8Board => 주어진 보드의 [i, j]칸을 [0, 0]으로 하는 8x8 체스판을 생성
  static char[][] set8x8Board(char[][] chessBoard, int rowNum, int colNum) {
    char[][] newBoard = new char[8][8];

    for (int i = rowNum; i < rowNum + 8; i++) {
      for (int j = colNum; j < colNum + 8; j++) {
        newBoard[i - rowNum][j - colNum] = chessBoard[i][j];
      }
    }

    return newBoard;
  }

  // compareWB => 체스판을 WBWB... 방식의 올바른 체스판과 비교
  static int compareWB(char[][] chessBoard) {
    int changeCount = 0;

    for (int i = 0; i < 8; i += 2) {
      for (int j = 0; j < 8; j += 2) {
        if (chessBoard[i][j] != 'W') changeCount++;
      }

      for (int j = 1; j < 8; j += 2) {
        if (chessBoard[i][j] != 'B') changeCount++;
      }
    }

    for (int i = 1; i < 8; i += 2) {
      for (int j = 0; j < 8; j += 2) {
        if (chessBoard[i][j] != 'B') changeCount++;
      }

      for (int j = 1; j < 8; j += 2) {
        if (chessBoard[i][j] != 'W') changeCount++;
      }
    }

    return changeCount;
  }

  // compareBW => 체스판을 BWBW... 방식의 올바른 체스판과 비교
  static int compareBW(char[][] chessBoard) {
    int changeCount = 0;

    for (int i = 0; i < 8; i += 2) {
      for (int j = 0; j < 8; j += 2) {
        if (chessBoard[i][j] != 'B') changeCount++;
      }

      for (int j = 1; j < 8; j += 2) {
        if (chessBoard[i][j] != 'W') changeCount++;
      }
    }

    for (int i = 1; i < 8; i += 2) {
      for (int j = 0; j < 8; j += 2) {
        if (chessBoard[i][j] != 'W') changeCount++;
      }

      for (int j = 1; j < 8; j += 2) {
        if (chessBoard[i][j] != 'B') changeCount++;
      }
    }

    return changeCount;
  }
}