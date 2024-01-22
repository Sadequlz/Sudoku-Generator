public class Main {
    public static void main(String[] args) {
        // Create a new instance of the Sudoku class.
        Sudoku sudoku = new Sudoku();

        // Generate a complete Sudoku puzzle.
        int[][] board = sudoku.generateSudoku();

        // Loop through each row of the Sudoku board.
        for (int i = 0; i < Sudoku.SIZE; i++) {

            // Loop through each column of the current row.
            for (int j = 0; j < Sudoku.SIZE; j++) {

                // Print the value in the current cell, followed by a space.
                System.out.print(board[i][j] + " ");

                // After every third number, print a vertical bar to separate 3x3 subgrids, except at the end of the row.
                if ((j + 1) % 3 == 0 && j < Sudoku.SIZE - 1) {
                    System.out.print("| ");
                }
            }

          System.out.println();

            // After every third row, print a horizontal line to separate 3x3 subgrids, except at the bottom of the board.
            if ((i + 1) % 3 == 0 && i < Sudoku.SIZE - 1) {
                System.out.println("---------------------");
            }
        }
    }
}
