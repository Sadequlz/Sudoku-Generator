import java.util.Random;

public class Sudoku {
  public static final int SIZE = 9;
  
  // Random number generator for shuffling numbers
  private final Random random = new Random();

  //creates a two-dimensional array representing the filled Sudoku board.
  public int[][] generateSudoku() {
    int[][] board = new int[SIZE][SIZE];
    // Call the method to fill the boar recursively ( will code later )
    fillBoard(board);
    return board;
    }

  //method to recursively fill the Sudoku board.
  private boolean fillBoard(int[][] board) {
  // Loop through each cell of the board
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        // If the cell is empty (contains a zero), try to fill it
        if (board[row][col] == 0) {
        // Get a shuffled array of numbers from 1 to 9
          int[] nums = getRandomNumbers();
          // Try each number to see if it can be placed in the cell
          for (int num : nums) {
            if (isValidPlacement(board, num, row, col)) {
              board[row][col] = num;
              // Continue filling the rest of the board and return true if successful
              if (fillBoard(board)) {
                return true;
              }
              // If not successful, reset the cell and try the next number
              board[row][col] = 0;
            }
          }
          // If no numbers are valid, return false to trigger backtracking
            return false;
        }
      }
    }
      // If the entire board is filled successfully, return true
      return true;
  }

  //Creates an array of numbers from 1 to 9 shuffled in random order.
  private int[] getRandomNumbers() {
    // Initialize an array with numbers 1 through 9
    int[] nums = new int[SIZE];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = i + 1;
    }
    // Shuffle the array using Fisher-Yates alogrithm
    for (int i = 0; i < nums.length; i++) {
      int randomIndex = random.nextInt(SIZE);
      int temp = nums[i];
      nums[i] = nums[randomIndex];
      nums[randomIndex] = temp;
    }
        return nums;
  }
  
    //method that checks if a given number is valid at the specified position.
    private boolean isValidPlacement(int[][] board, int num, int row, int col) {
        // Check the validity of the number in the row, column, and subgrid
        return isValidRow(board, row, num) && 
               isValidColumn(board, col, num) && 
               isValidSubgrid(board, row - row % 3, col - col % 3, num);
    }
    //method that checks if a number can be placed in a given row.
    private boolean isValidRow(int[][] board, int row, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        return true;
    }
  
  //method that checks if a number can be placed in a given column.
  private boolean isValidColumn(int[][] board, int col, int num) {
    for (int i = 0; i < SIZE; i++) {
      if (board[i][col] == num) {
        return false;
      }
    }
    return true;
  }
  
  //Checks if a number can be placed in a specific 3x3 subgrid of the Sudoku board.
  private boolean isValidSubgrid(int[][] board, int startRow, int startCol, int num) {
      for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
              if (board[startRow + i][startCol + j] == num) {
                  return false;
              }
          }
      }
      return true;
  }
}
