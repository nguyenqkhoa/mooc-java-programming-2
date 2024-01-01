
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        // X X X
        // X 1 X
        // X X X
        int row = 0;
        int column = size / 2;
        square.placeValue(column, row, 1);

        for(int i = 2; i <= size*size; i++){
            // R X X
            // R X X
            // R X X
            int nextRow = row - 1;
            if (nextRow < 0){
                nextRow = square.getHeight() - 1;
            }
            // C C C
            // X X X
            // X X X
            int nextColumn = column + 1;
            if(nextColumn >= square.getWidth()) {
                nextColumn = 0;
            }

            int nextValue = square.readValue(nextColumn, nextRow);
            if (nextValue != 0){
                nextRow = row + 1;
                nextColumn = column;
            }

            square.placeValue(nextColumn, nextRow, i);
            row = nextRow;
            column = nextColumn;
        }
        return square;
    }

}
