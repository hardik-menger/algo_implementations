import java.util.*;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Character>> columns = new ArrayList<HashSet<Character>>();
        ArrayList<HashSet<Character>> rows = new ArrayList<HashSet<Character>>();

        for (int colIndex = 0; colIndex < board[0].length; colIndex++) {
            columns.add(colIndex, new HashSet<Character>());
        }

        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            rows.add(rowIndex, new HashSet<Character>());
        }

        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            for (int colIndex = 0; colIndex < board[rowIndex].length; colIndex++) {
                char data = board[rowIndex][colIndex];
                if (data != '.') {
                    if (rows.get(rowIndex).contains(data) || columns.get(colIndex).contains(data))
                        return false;
                    columns.get(colIndex).add(data);
                    rows.get(rowIndex).add(data);
                }
            }
        }
        for (int rowIndex = 0; rowIndex < board.length; rowIndex += 3) {
            for (int colIndex = 0; colIndex < board[rowIndex].length; colIndex += 3) {
                HashSet<Character> hs = new HashSet<>();
                for (int boxRowIndex = rowIndex; boxRowIndex < rowIndex + 3; boxRowIndex++) {
                    for (int boxColIndex = colIndex; boxColIndex < colIndex + 3; boxColIndex++) {
                        char data = board[boxRowIndex][boxColIndex];
                        if (data != '.') {
                            System.out.println(boxRowIndex + "?" + boxColIndex);

                            if (hs.contains(board[boxRowIndex][boxColIndex]))
                                return false;
                            hs.add(board[boxRowIndex][boxColIndex]);
                        }
                    }
                }
            }
        }
        return true;
    }
}