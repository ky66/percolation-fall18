import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast{

	public PercolationBFS(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	protected void dfs(int row, int col) {
		
		int size = myGrid.length;   // n of the grid
		myGrid[row][col] = FULL; //This method will first make the cell at (row,col) as FULL

		
		Queue<Integer> qp = new LinkedList<>();  
		
		qp.add(myGrid[row][col]);  //This adds the cell to the QUEUE object
		
        while (qp.size() != 0){
            Integer p = qp.remove();

				if (myGrid[row-1][col] != FULL) {
					myGrid[row-1][col] = FULL; 
					qp.add(myGrid[row-1][col]);
				}
				
				if (myGrid[row+1][col] != FULL) {
					myGrid[row+1][col] = FULL; 
					qp.add(myGrid[row+1][col]);
				}
				
				
				if (myGrid[row][col-1] != FULL) {
					myGrid[row][col-1] = FULL; 
					qp.add(myGrid[row][col-1]);
				}
			
				if (myGrid[row][col+1] != FULL) {
					myGrid[row][col+1] = FULL; 
					qp.add(myGrid[row][col+1]);;
				}
            }
		
		
		
		
		
		
		
		
		
		
		// out of bounds?
		if (! inBounds(row,col)) return;
		
		// full or NOT open, don't process
		if (isFull(row, col) || !isOpen(row, col))
			return;
		
		myGrid[row][col] = FULL;
		dfs(row - 1, col);
		dfs(row, col - 1);
		dfs(row, col + 1);
		dfs(row + 1, col);
	}
}
