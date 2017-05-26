public class SudokuSolver {

	public static void main(String[] args) {
		//create a sudokuBoard
		int[][] board = new int[9][9];
		//initialize board
		board=setInitialBoard(board);
		System.out.println("The initial sudoku board is : ");
		printSudokuBoard(board);
		//solve the sudoku board
		sudokuSolver(board);
	}
	
	//checks when the board is fully solved
	public static boolean checkIfFull(int[][] board)
	{
		for(int x=0;x<9;++x)
			for(int y=0;y<9;++y)
				if(board[x][y]==0)
					return false;
		return true;
	}
	
	//initialize list of possibilities for each cell in the board
	public static int[] possibleEntries(int[][] board,int i,int j)
	{
		//create the possibility list of size 10 so that numbers 1 to 9 could be placed
		int[] possibilityArray = new int[10];
		
		//initialize all values of possibility array to 0
		for(int x=0;x<possibilityArray.length;++x)
			possibilityArray[x]=0;
		
		//we are traversing horizontally keeping i as constant
		//if the value is already present in the board, set those cells in probabilityArray as 1
		// later these 1 values will be taken as values to be skipped.
		//board cells having zero values will be considered as next probable value
		for(int y=0;y<9;++y)
			if(board[i][y]!=0)
				possibilityArray[board[i][y]]=1;
		
		//similarly we are traversing vertically keeping j as constant
		for(int x=0;x<9;++x)
			if(board[x][j]!=0)
				possibilityArray[board[x][j]]=1;
		
		//operate on squares of three x three
		//reinitialize k and l values every time to iterate on small 3 x 3 squares only
		int k=0;
		int l=0;
		if(i>=0 && i<=2)
			k=0;
		else if(i>=3 && i<=5)
			k=3;
		else
			k=6;
		
		if(j>=0 && j<=2)
			l=0;
		else if(j>=3 && j<=5)
			l=3;
		else
			l=6;
		
		//iterate inside smaller 3 x 3 square to set available values in possibility array cell value to 1
		for(int x=k;x<(k+3);++x)
			for(int y=l;y<(l+3);++y)
				if(board[x][y]!=0)
					possibilityArray[board[x][y]]=1;
		
		//place legitimate values into possibility array for every cell (i,j)
		for(int x=1;x<10;++x)
			if(possibilityArray[x]==0)
				possibilityArray[x]=x;
			else
				possibilityArray[x]=0;
		return possibilityArray;
	}
	
	public static void sudokuSolver(int[][] board)
	{
		int i=0;
		int j=0;
		int[] possibilities = new int[10];
		//when board is full, no more solving required
		//print the board and return;
		if(checkIfFull(board))
		{
			System.out.println("Sudoku problem solved successfully!!");
			printSudokuBoard(board);
			return;
		}
		else
		{
			for(int x=0;x<9;++x)
				for(int y=0;y<9;++y)
				{
					if(board[x][y]==0)
					{
						i=x;
						j=y;
						break;
					}
				}
			//for a certain cell, all possible values are extracted
			possibilities = possibleEntries(board, i, j);
			
			//go through all the possibilities
			//and place them one by one and call sudokuSolver again
			for(int x=1;x<possibilities.length;++x)
			{
				if(possibilities[x]!=0)
				{
					board[i][j]=possibilities[x];
					sudokuSolver(board);
				}
			}
			//if we run out of possibilities
			//that implies the value firstly set was wrong
			//so we backtrack and set the boardValues to 0
			board[i][j]=0;
			
		}
	}
	
	public static void printSudokuBoardValues(int[][] board)
	{
		System.out.println("Printing sudoku Board values : ");
		for(int x=0;x<9;++x)
			for(int y=0;y<9;++y)
			{
				System.out.println(" Board Value ["+x+"]["+y+"] : "+board[x][y]);
			}
	}
	
	public static int[][] setInitialBoard(int[][] board)
	{
		board[0][0]=0;
		board[0][1]=0;
		board[0][2]=0;
		board[0][3]=3;
		board[0][4]=0;
		board[0][5]=0;
		board[0][6]=2;
		board[0][7]=0;
		board[0][8]=0;
		board[1][0]=0;
		board[1][1]=0;
		board[1][2]=0;
		board[1][3]=0;
		board[1][4]=0;
		board[1][5]=8;
		board[1][6]=0;
		board[1][7]=0;
		board[1][8]=0;	
		board[2][0]=0;
		board[2][1]=7;
		board[2][2]=8;
		board[2][3]=0;
		board[2][4]=6;
		board[2][5]=0;
		board[2][6]=3;
		board[2][7]=4;
		board[2][8]=0;
		board[3][0]=0;
		board[3][1]=4;
		board[3][2]=2;
		board[3][3]=5;
		board[3][4]=1;
		board[3][5]=0;
		board[3][6]=0;
		board[3][7]=0;
		board[3][8]=0;
		board[4][0]=1;
		board[4][1]=0;
		board[4][2]=6;
		board[4][3]=0;
		board[4][4]=0;
		board[4][5]=0;
		board[4][6]=4;
		board[4][7]=0;
		board[4][8]=9;
		board[5][0]=0;
		board[5][1]=0;
		board[5][2]=0;
		board[5][3]=0;
		board[5][4]=8;
		board[5][5]=6;
		board[5][6]=1;
		board[5][7]=5;
		board[5][8]=0;
		board[6][0]=0;
		board[6][1]=3;
		board[6][2]=5;
		board[6][3]=0;
		board[6][4]=9;
		board[6][5]=0;
		board[6][6]=7;
		board[6][7]=6;
		board[6][8]=0;
		board[7][0]=0;
		board[7][1]=0;
		board[7][2]=0;
		board[7][3]=7;
		board[7][4]=0;
		board[7][5]=0;
		board[7][6]=0;
		board[7][7]=0;
		board[7][8]=0;
		board[8][0]=0;
		board[8][1]=0;
		board[8][2]=9;
		board[8][3]=0;
		board[8][4]=0;
		board[8][5]=5;
		board[8][6]=0;
		board[8][7]=0;
		board[8][8]=0;	
		
		return board;
	}
	
	public static void printSudokuBoard(int[][] board)
	{
		System.out.println("---------------------");
		for(int x=0;x<9;++x)
		{
			if(x==3 || x==6)
				System.out.println("---------------------");
			for(int y=0;y<9;++y)
			{
				if(y==3 || y==6)
					System.out.print("| ");
				System.out.print(board[x][y]+" ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}

}
