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
		
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(String.format("(%d,%d) not in bounds", row,col));
		}

		
		int size = myGrid.length;   // n of the grid
		dfs(row,col); //This method will first make the cell at (row,col) as FULL

		Queue<Integer> qp = new LinkedList<>();  //creates a new Queue object
		
		
		qp.add(row*size + col);  //This adds the cell to the QUEUE object
		
//        int[] rowDelta = {-1,1,0,0};
//        int[] colDelta = {0,0,-1,1};
//        
        while (qp.size() != 0){
            Integer p = qp.remove();
            row = p/size;
            col = p%size;
            

				if (inBounds(row-1,col) && !isFull(row-1, col) && isOpen(row-1, col)) {
					dfs(row-1,col);
					qp.add(myGrid[row-1][col]);
				}
				
				if (inBounds(row+1,col) && !isFull(row+1, col) && isOpen(row+1, col)) {
					dfs(row+1,col); 
					qp.add(myGrid[row+1][col]);
				}
				
				
				if (inBounds(row,col-1) && !isFull(row, col-1) && isOpen(row, col-1)) {
					dfs(row,col-1);  
					qp.add(myGrid[row][col-1]);
				}
			
				if (inBounds(row,col+1) && !isFull(row, col+1) && isOpen(row, col+1)) {
					dfs(row,col+1);  
					qp.add(myGrid[row][col+1]);;
				}
            }
		
		
		
	}
}
