
public class PercolationUF implements IPercolate  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private final int VTOP;
	private final int VBOTTOM;
	
	PercolationUF(int size, IUnionFind finder){
		int [][] myGrid = new int[size][size];
		VTOP = finder.initialize(size*size + 2);
	}

	@Override
	public void open(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(String.format("(%d,%d) not in bounds", row,col));
		}
		
		
	}

	@Override
	public boolean isOpen(int row, int col) {
		// TODO Auto-generated method stub
		
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(String.format("(%d,%d) not in bounds", row,col));
		}
		return false;
	}

	@Override
	public boolean isFull(int row, int col) {
		// TODO Auto-generated method stub
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(String.format("(%d,%d) not in bounds", row,col));
		}
		return false;
	}

	@Override
	public boolean percolates() {
		// TODO Auto-generated method stub
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
