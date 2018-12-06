
public class PercolationUF implements IPercolate  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private final int VTOP;
	private final int VBOTTOM;
	private boolean[][] myGrid;
	private IUnionFind myFinder;
	private int order;
	
	PercolationUF(int size, IUnionFind finder){
		order = size;
		myGrid = new boolean[size][size]; //creates a new mygrid of size n x n
		VTOP = size*size;
		VBOTTOM = size*size + 1; 
		myFinder = finder;
		myFinder.initialize(size*size + 2);  

	}
	
	public int getindex(int row, int col) {
		return  row*order + col;
	}


	@Override
	public void open(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(String.format("(%d,%d) not in bounds", row,col));
		}
		
		if (row == 0) {
			myFinder.union(getindex(row,col), VTOP);
		}
		
		if (row == order-1) {
			myFinder.union(getindex(row,col), VBOTTOM);
		}
		
		else if (myGrid[row][col] == false){
			if (inBounds(row-1,col) && myGrid[row-1][col]== false) {
				myFinder.union(getindex(row,col), getindex(row-1,col));
			}
			
		else if (inBounds(row+1,col) && myGrid[row+1][col]== false) {
			myFinder.union(getindex(row,col), getindex(row+1,col));
			}
		
		else if (inBounds(row,col-1) && myGrid[row][col-1]== false) {
			myFinder.union(getindex(row,col), getindex(row,col-1));
			
		}
		
		else if (inBounds(row,col+1) && myGrid[row+1][col+1]== false) {
			
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
			return true;
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
		if (myFinder.connected(VBOTTOM, getindex(row,col))){
			return true;
		}
		
		return false;
	}

	@Override
	public boolean percolates() {
		if (myFinder.connected(VBOTTOM, VTOP)){
			return true;
		}
		return false;
	}

	@Override
	public int numberOfOpenSites() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	protected boolean inBounds(int row, int col) {
		if (row < 0 || row >= myGrid.length) return false;
		if (col < 0 || col >= myGrid[0].length) return false;
		return true;
	}


}
