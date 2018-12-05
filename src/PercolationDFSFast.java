
public class PercolationDFSFast extends PercolationDFS  {

	public PercolationDFSFast(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override    //This overrides this method from the parent class to make it faster
	protected void updateOnOpen(int row, int col) {
		if (row == 0) {   //checks if the cell is in the top row and then fills it accordingly
			dfs(0,col);
		}
		
		//The next if statements check if the cell is adjacent to a full cell and then it opens it up. 
		if (myGrid[row-1][col] == FULL) {
			dfs(row,col);
		}
		
		if (myGrid[row+1][col] == FULL) {
			dfs(row,col);
		}
		
		
		if (myGrid[row][col-1] == FULL) {
			dfs(row,col);
		}
	
		if (myGrid[row][col+1] == FULL) {
			dfs(row,col);
		}
		

		for (int k = 0; k < myGrid[0].length; k++)
			
			
			dfs(0, k);
	}

}
