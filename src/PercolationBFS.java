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
		
		
		qp.add(row*size + col);  //This adds the cell to the QUEUE object
		
//        int[] rowDelta = {-1,1,0,0};
//        int[] colDelta = {0,0,-1,1};
//        
        while (qp.size() != 0){
            Integer p = qp.remove();
            row = p/size;
            col = p%size;
            

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
		
		
		
	}
}
