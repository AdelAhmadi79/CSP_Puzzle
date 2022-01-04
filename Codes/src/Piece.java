import java.util.ArrayList;

public class Piece {
    boolean empty,positiveNegative;
    public Piece(){
        this.empty=true;
    }
    public Piece(String str){
        if (str.equals("positiveNegative")) {
            this.empty = false;
            this.positiveNegative = true;
        }
        if (str.equals("negativePositive")){
            this.empty = false;
            this.positiveNegative = false;
        }
        else this.empty = true;
    }
    public void setPositiveNegativePiece(Place place){
        place.firstSquare.positiveSquare();
        place.secondSquare.negativeSquare();
        place.piece.empty =false;
        place.piece.positiveNegative = true;
    }
    public void setNegativePositivePiece(Place place){
        place.firstSquare.negativeSquare();
        place.secondSquare.positiveSquare();
        place.piece.empty =false;
        place.piece.positiveNegative = false;
    }
    public void setPieceEmpty(Place place){
        place.firstSquare.emptySquare();
        place.secondSquare.emptySquare();
        place.piece.empty =true;
    }
}

class Place {
    int i = 0;
    Square firstSquare, secondSquare;
    int index;
    boolean empty, vertical;
    Piece piece ;
    ArrayList<Piece> values = new ArrayList<>();
    boolean positive1,positive2;
    public Place(Square firstSquare,Square secondSquare,boolean vertical,int index){
        this.firstSquare = firstSquare;
        this.secondSquare = secondSquare;
        this.vertical = vertical;
        this.empty = true;
        piece = new Piece() ;
        values.add(new Piece("positiveNegative"));
        values.add(new Piece("negativePositive"));
        values.add(new Piece());
        this.index = index ;
    }
    public  Place (Piece piece,boolean vertical){
        this.piece =piece;
        this.vertical = vertical;
    }
    public Square getFirstSquare() {
        return firstSquare;
    }
    public Square getSecondSquare() {
        return secondSquare;
    }
    public void setPieceEmpty() {
        piece.setPieceEmpty(this);
        this.empty = true;
    }
    public void setPiecePositiveNegative() {
        piece.setPositiveNegativePiece(this);
        positive1 = true;
        positive2 = false;
        this.empty = false;
    }
    public void setPieceNegativePositive() {
        piece.setNegativePositivePiece(this);
        positive1 =false;
        positive2=true;
        this.empty = false;
    }
    public Piece getPiece() {
        return piece;
    }
}
