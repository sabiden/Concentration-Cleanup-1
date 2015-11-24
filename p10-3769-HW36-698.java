//Team Shaibastian - Shaik Abiden and Sebastian Dittgen
//APCS1 - pd10
//HW 36 -- Some Folks Call It a Memory
//2015 - 11 - 23

import cs1.Keyboard;  //if comfortable with Scanner, you may comment this out

		
public class Concentration {

    //instance variables
    private Tile[][] _board;     //storage for 4x4 grid of Tiles.
    private int _numberFaceUp;   //count of Tiles with faces visible
    private String[] _words = {"Cats","Dogs","Fish","Mice","Pigs","Cows","Deer","Bird"};     //list of unique Strings used for Tile vals
    private static int _numRows = 4;
    private int moves = 0;
    private int matchesLeft = (_numRows*_numRows)/2;
    

    public Concentration(){
        Tile a = new Tile(_words[0]);
        Tile b = new Tile(_words[0]);
        Tile c = new Tile(_words[1]);
        Tile d = new Tile(_words[1]);
        Tile e = new Tile(_words[2]);
        Tile f = new Tile(_words[2]);
        Tile g = new Tile(_words[3]);
        Tile h = new Tile(_words[3]);
        Tile i = new Tile(_words[4]);
        Tile j = new Tile(_words[4]);
        Tile k = new Tile(_words[5]);
        Tile l = new Tile(_words[5]);
        Tile m = new Tile(_words[6]);
        Tile n = new Tile(_words[6]);
        Tile o = new Tile(_words[7]);
        Tile p = new Tile(_words[7]);
        _board = new Tile[][]{{a,b,c,d},{e,f,g,h},{i,j,k,l},{m,n,o,p}};
        _board = shuffle(_board);
        
    }
    public Tile[][] shuffle(Tile[][] a) {
        for (int i = 0; i < 40; i++) {
            int x1 = (int)(Math.random()*_numRows);
            int y1 = (int)(Math.random()*_numRows);
            int x2 = (int)(Math.random()*_numRows);
            int y2 = (int)(Math.random()*_numRows);
            Tile savedSwap = a[x2][y2];
            a[x2][y2] = a[x1][y1];
            a[x1][y1] = savedSwap;
        }
        return a;
    }
        
    public int countFace(){
        int counter = 0;
        for (Tile[] r : _board){
            for(Tile c : r){
                if (c.isFaceUp()){
                    counter = counter + 1;
                }
            }
        }
        _numberFaceUp = counter;
        return _numberFaceUp;
    }
    
    public String printArr( Tile[][] a ) {
        String retStr = "";
        for(int r = 0; r < a.length; r++){
            for (int c = 0; c < a[r].length; c++){
    	        retStr += a[r][c] + " ";
	               }
	        retStr += "\n";
	            }
	    return retStr;
    }
    
    public void play(){
        System.out.println("Welcome to a new game of Concentration!\nHere is your board");
        System.out.println(printArr(_board));
        while(_numberFaceUp < 16){
            System.out.println("Choose the Row of the First Tile (0-3):");
            int x1 = Integer.parseInt(Keyboard.readString());
            System.out.println("Choose the Column of the First Tile (0-3):");
            int y1 = Integer.parseInt(Keyboard.readString());
            //to use if player selects a tile that is already face-up
            while (_board[x1][y1].isFaceUp()) {
                System.out.println("Please pick a face-down card.");
                System.out.println("Choose the Row of the First Tile (0-3), again:");
                x1 = Integer.parseInt(Keyboard.readString());
                System.out.println("Choose the Column of the First Tile (0-3), again:");
                y1 = Integer.parseInt(Keyboard.readString());
            }
            _board[x1][y1].flip();
            System.out.println("Here is the selected tile!");
            System.out.println(printArr(_board));
            System.out.println("Choose the Row of the Second Tile (0-3):");
            int x2 = Integer.parseInt(Keyboard.readString());
            System.out.println("Choose the Column of the Second Tile (0-3):");
            int y2 = Integer.parseInt(Keyboard.readString());

            while (_board[x2][y2].isFaceUp()) {
                System.out.println("Please pick a face-down card.");
                System.out.println("Choose the Row of the First Tile (0-3), again:");
                x2 = Integer.parseInt(Keyboard.readString());
                System.out.println("Choose the Column of the First Tile (0-3), again:");
                y2 = Integer.parseInt(Keyboard.readString());
            }
            _board[x2][y2].flip();
            System.out.println("Here is the next selected tile!");
            System.out.println(printArr(_board));
            if (_board[x1][y1].equals(_board[x2][y2])){
                System.out.println("Nice Match");
                System.out.println(printArr(_board));
            }
            else{
                System.out.println("Better Luck Next Time!");
                _board[x2][y2].flip();
                _board[x1][y1].flip();
                System.out.println(printArr(_board));
            }
        }
    }

		
    //DO NOT MODIFY main()
    public static void main(String[] args){
	Concentration game = new Concentration();
	game.play();
    }

}//end class Concentration

