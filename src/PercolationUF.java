
public class PercolationUF implements IPercolate  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private final int VTOP; //instance variable VTOP is the virtual tap on top of the grid
	private final int VBOTTOM; //the most bottom one we created to see if it goes through
	private boolean[][] myGrid; //the boolean grid we want
	private IUnionFind myFinder;  //our myFinder object
	private int order; //gets initialized to size later on
	
	PercolationUF(int size, IUnionFind finder){
		order = size;
		myGrid = new boolean[size][size]; //creates a new mygrid of size n x n
		VTOP = size*size;    //just initialized to a unique object
		VBOTTOM = size*size + 1;    //just initialized to a unique object
		myFinder = finder;
		myFinder.initialize(size*size + 2);  

	}
	
	public int getindex(int row, int col) {
		return  row*order + col;  //gives the number for each grid
	}


	@Override
	public void open(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(String.format("(%d,%d) not in bounds", row,col));
		} //checks if it is out of bounds or not
		
		if (row == 0) {
			myFinder.union(getindex(row,col), VTOP);
		} //if it is in the top row, union  it with VTOP
		
		if (row == order-1) {
			myFinder.union(getindex(row,col), VBOTTOM);
		}  //if it is in the top row, union  it with VBOTTOM
		
		if (myGrid[row][col] == false){
			myGrid[row][col] = true; //opens the cell
			if (inBounds(row-1,col) && myGrid[row-1][col]== true) {
				myFinder.union(getindex(row,col), getindex(row-1,col)); //checks the neighbors
			}
			
		if (inBounds(row+1,col) && myGrid[row+1][col]== true) { //same for other neighbors
			myFinder.union(getindex(row,col), getindex(row+1,col));
			}
		
		if (inBounds(row,col-1) && myGrid[row][col-1]== true) {
			myFinder.union(getindex(row,col), getindex(row,col-1));
			
		}
		
		if (inBounds(row,col+1) && myGrid[row][col+1]== true) {
			
			myFinder.union(getindex(row,col), getindex(row,col+1));
			
		}
			
			
		}

	}

	@Override
	public boolean isOpen(int row, int col) {
		// TODO Auto-generated method stub
		
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(String.format("(%d,%d) not in bounds", row,col));
		}
		
		else if (myGrid[row][col] == true) {
			return true; //isOpen checks if the cell is True(open) or not
		}
		
		else {
			return false;
		}
		
	}

	@Override
	public boolean isFull(int row, int col) {
		// TODO Auto-generated method stub
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(String.format("(%d,%d) not in bounds", row,col));
		}
		if (myFinder.connected(VTOP, getindex(row,col))){
			return true; //checks if it is connected to TOP or not
		}
		
		return false;
	}

	@Override
	public boolean percolates() {
		if (myFinder.connected(VBOTTOM, VTOP)){
			return true;
		} //if the VTOP and bottom connected it goes throgh
		return false;
	}

	@Override
	public int numberOfOpenSites() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	protected boolean inBounds(int row, int col) { //helper method to check if row and col are inbounds
		if (row < 0 || row >= myGrid.length) return false;
		if (col < 0 || col >= myGrid[0].length) return false;
		return true;
	}


}
