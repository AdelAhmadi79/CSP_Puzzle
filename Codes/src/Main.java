import java.util.*;
public class Main {
    int n, m, i = 0;
    int[] rowPositive;
    int[] rowNegative;
    int[] columnPositive;
    int[] columnNegative;
    int[][] board;
    Square[][] squares;
    ArrayList<Place> placeArrayList = new ArrayList<>();
    public static void main(String [] args){
    }
    public void printBoard(){
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(squares[i][j].empty){
                    System.out.print("#  ");
                }else {
                    if(squares[i][j].positiveOrNegative){
                        System.out.print("+  ");
                    }else {
                        System.out.print("-  ");
                    }
                }
            }
            System.out.println();
        }
    }
    private Place makePlace(int i1, int j1, int i2, int j2, boolean vertical) {
        Square square1;
        Square square2;
        Place place;
        square1 = new Square(i1, j1, true);
        Main main = new Main();
        main.getSquares()[i1][j1] = square1;
        square2 = new Square(i2, j2, false);
        main.getSquares()[i2][j2] = square2;
        place = new Place(square1, square2, vertical,i);
        i++;
        return place;
    }
    public void inputs(){
        String str0,str1,str2,str3,str4;
        String[] str0arr,str1arr,str2arr,str3arr,str4arr;
        Scanner scan = new Scanner(System.in);
        str0 = scan.nextLine();
        str1 = scan.nextLine();
        str2 = scan.nextLine();
        str3 = scan.nextLine();
        str4 = scan.nextLine();
        str0arr = str0.split(" ");
        str1arr = str1.split(" ");
        str2arr = str2.split(" ");
        str3arr = str3.split(" ");
        str4arr = str4.split(" ");
        n = Integer.parseInt(str0arr[0]);
        m = Integer.parseInt(str0arr[1]);
        for(int i = 0; i < n; i++){
            rowPositive[i] = Integer.parseInt(str1arr[i]);
        }
        for(int i = 0; i < n; i++){
            rowNegative[i] = Integer.parseInt(str2arr[i]);
        }
        for(int i = 0; i < m; i++){
            columnPositive[i] = Integer.parseInt(str3arr[i]);
        }
        for(int i = 0; i < m; i++){
            columnNegative[i] = Integer.parseInt(str4arr[i]);
        }
        for(int i = 0; i < n; i++){
            String str = scan.nextLine();
            String[] strarr = str.split(" ");
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(strarr[j]);
            }
        }
    }
    public void createBoard(){
        inputs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == n - 1 && j == m - 1) {
                    continue;
                } else if (j == m - 1) {
                    if (board[i][j] == board[i + 1][j]) {
                        placeArrayList.add(makePlace(i, j, i + 1, j, true));
                    }
                } else if (i == n - 1) {
                    if (board[i][j] == board[i][j + 1]) {
                        placeArrayList.add(makePlace(i, j, i, j + 1, false));
                    }
                } else if (i != n - 1 && j != m - 1) {
                    if (board[i][j] == board[i][j + 1]) {
                        placeArrayList.add(makePlace(i, j, i, j + 1, false));
                    } else if (board[i][j] == board[i + 1][j]) {
                        placeArrayList.add(makePlace(i, j, i + 1, j, true));
                    }
                }
            }
        }
    }

    public Square[][] getSquares(){
        return squares;
    }
}
