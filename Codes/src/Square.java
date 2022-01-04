public class Square {
    boolean first, empty, positiveOrNegative;
    int row, column;

    public Square(int row,int column,boolean isFirst){
        this.row = row;
        this.column = column;
        this.first = isFirst;
        this.empty = true;
    }
    public void positiveSquare(){
        this.empty =false;
        positiveOrNegative = true;
    }
    public void negativeSquare(){
        this.empty =false;
        positiveOrNegative = false;
    }
    public void emptySquare(){
        this.empty = true;
        this.positiveOrNegative = false;
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
}
