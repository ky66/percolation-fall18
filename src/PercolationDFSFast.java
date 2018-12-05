
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
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(String.format("(%d,%d) not in bounds", row,col));
		}

		
		
		if (row == 0) {   //checks if the cell is in the top row and then fills it accordingly
			dfs(row,col);
		}
		
		//The next if statements check if the cell is adjacent to a full cell and then it opens it up. 
		else if (inBounds(row-1,col) && myGrid[row-1][col] == FULL) {
			myGrid[row][col] = FULL;
			dfs(row,col);
		}
		
		else if (inBounds(row+1,col) && myGrid[row+1][col] == FULL) {
			myGrid[row][col] = FULL;
			dfs(row,col);
		}
		
		
		else if (inBounds(row,col-1) && myGrid[row][col-1] == FULL) {
			myGrid[row][col] = FULL;
			dfs(row,col);
		}
	
		else if (inBounds(row,col+1) && myGrid[row][col+1] == FULL) {
			myGrid[row][col] = FULL;
			dfs(row,col);
		}
		


}
}
