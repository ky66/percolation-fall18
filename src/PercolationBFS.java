import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast{

	public PercolationBFS(int n) {
		super(n);
	}
	

	public static void main(String[] args) {

	}
	
	@Override
	protected void dfs(int row, int col) {
		
		if (! inBounds(row,col)) {   //checks if it is inbounds
			throw new IndexOutOfBoundsException(String.format("(%d,%d) not in bounds", row,col));
		}

		
		int size = myGrid.length;   // n of the grid
		myGrid[row][col] = FULL; //This method will first make the cell at (row,col) as FULL

		Queue<Integer> qp = new LinkedList<>();  //creates a new Queue object
		
		
		qp.add(row*size + col);  //This adds the cell to the QUEUE object
		
        int[] rowDelta = {-1,1,0,0};  // allows us to move up down left and right in the upcoming forloop
        int[] colDelta = {0,0,-1,1};
        
        while (qp.size() != 0){    //like blobfill
            Integer p = qp.remove();
            row = p/size;   //derives the row value from the int in the Queue
            col = p%size; //derives the column value from the int in the Queue
            
            for(int k=0; k < rowDelta.length; k++){
            	int row1 = row + rowDelta[k];     //moves the row
            	int col1 = col + colDelta[k];  //moves the column
            	
            	if (inBounds(row1,col1) && !isFull(row1, col1) && isOpen(row1, col1)){
            		qp.add(row1*size + col1); //adds to the queue for the subsequent calls
            		myGrid[row1][col1] = FULL; //marks as full if it s open and not full
            		
            	}
            	
            }
        }
	}
}


