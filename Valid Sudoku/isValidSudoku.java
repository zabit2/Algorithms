package com.practice.algo;

public class isValidSudoku {

	public static void main(String[] args) {
		System.out.println("The initial board is : ");
		int[][] board = new int[9][9];
		board = initialiseBoard(board);
		printBoard(board);
		System.out.println(isValidBoard(board)?"This is a Valid Sudoku":"This is an invalid Sudoku");
	}
	
	public static int[][] initialiseBoard(int[][] board)
	{
		
		board[0][3]=3;
		board[0][6]=2;
		board[1][5]=8;
		board[2][1]=7;
		board[2][2]=8;
		board[2][4]=6;
		board[2][6]=3;
		board[2][7]=4;
		board[3][1]=4;
		board[3][2]=2;
		board[3][3]=5;
		board[3][4]=1;
		board[4][0]=1;
		board[4][2]=6;
		board[4][6]=4;
		board[4][8]=9;
		board[5][4]=8;
		board[5][5]=6;
		board[5][6]=1;
		board[5][7]=5;
		board[6][1]=3;
		board[6][2]=5;
		board[6][4]=9;
		board[6][6]=7;
		board[6][7]=6;
		board[7][3]=7;
		board[8][2]=9;
		board[8][5]=5;
		
		return board;
	}
	
	public static void printBoard(int[][] board)
	{
		System.out.println("---------------------");
		for(int i=0;i<9;++i)
		{
			if(i==3||i==6)
				System.out.println("---------------------");
			for(int j=0;j<9;++j)
			{
				if(j==3||j==6)
					System.out.print("| ");
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}
	
	
	public static boolean isValidBoard(int[][] board)
	{
		for(int i=0;i<9;++i)
			for(int j=0;j<9;++j)
				if(forEachcell(board, i, j))
					continue;
				else
					return false;
		return true;
	}
	
	public static boolean forEachcell(int[][] board,int i,int j)
	{
		int cellValue = board[i][j];

		//for column level
		for(int y=0;y<9;++y)
			if(y!=j && board[i][y]!=0 && board[i][y]==cellValue)
				return false;
		
		//for row level
		for(int x=0;x<9;++x)
			if(x!=i && board[x][j]!=0 && board[x][j]==cellValue)
				return false;

		
		
		// for 3 x 3 grid level
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
		
		for(int x=k;x<(k+3);++x)
			for(int y=l;y<(l+3);++y)
				if(x!=i && y!=j && board[x][y]!=0 && board[x][y]==cellValue)
					return false;

		return true;
	}
	

}
