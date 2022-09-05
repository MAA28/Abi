import java.util.Arrays;

/**
 * A magic square is a square of numbers that is filled with numbers from 1 to 9 such that each row, column, and diagonal
 * adds up to 15
 */
public class MagicSquare {
    private int[][] square;

    public MagicSquare() {
        this.square = new int[3][3];
    }

    /**
     * Fill the square with random numbers from 1-9
     */
    public void fillSquare() {
        for(int i = 0; i < this.square.length; i++) {
            for(int j = 0; j < this.square.length; j++) {
                this.square[i][j] = (int) (1 + Math.random() * 9);
            }
        }
    }

    /**
     * Prints the square
     */
    public void print() {
        for(int i = 0; i < this.square.length; i++) {
            for (int j = 0; j < this.square[i].length; j++) {
                System.out.print(this.square[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    /**
     * Given a square matrix, check if it is a magic square
     *
     * @return A boolean value.
     */
    public boolean isMagic() {
        int[] sums = new int[(1 + this.square.length) * 2];

        // This is a nested for loop. The outer loop is for each row in the square. The inner loop is for each column in
        // the square.
        for(int i = 0; i < this.square.length; i++) {
            int n = 0;
            int m = 0;
            for(int j = 0; j < this.square[i].length; j++) {
                n += this.square[i][j];
                m += this.square[j][i];
            }

            sums[i * 2] = n;
            sums[i * 2 + 1] = m;
        }



        for(int i = 0; i < this.square.length; i++) {
            sums[(1 + this.square.length) * 2 - 2] += this.square[i][i];
            sums[(1 + this.square.length) * 2 - 1] += this.square[this.square.length - (i + 1)][this.square.length - (i + 1)];
        }


        for(int i = 0; i < this.square.length; i++) {
            for(int j = 0; j < this.square.length; j++) {
                for(int n = 0; n < this.square.length; n++) {
                    for(int m = 0; m < this.square.length; m++) {
                        if(this.square[i][j] == this.square[n][m]) {
                            return false;
                        }
                    }
                }
            }
        }



        for(int i = 1; i < sums.length; i++) {
            if(sums[i] != sums[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
