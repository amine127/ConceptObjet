package assets;

public class Box {

	private int indexLine;
	private int indexColumn;
	private boolean isEmpty;
	private String contentBox;
	
	/**
	 * Constructor.
	 * @param indexLine
	 * @param indexColumn
	 * @param isEmpty
	 */
	public Box(int indexLine, int indexColumn, boolean isEmpty) {
		this.indexLine = indexLine;
		this.indexColumn = indexColumn;
		this.isEmpty = isEmpty;
		this.contentBox = " ";
	}

	public int getIndexLine() {
		return indexLine;
	}
	public int getIndexColumn() {
		return indexColumn;
	}
	public boolean getIsEmpty() {
		return isEmpty;
	}
	public void setIsEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	public String getContentBox() {
		return contentBox;
	}
	public void setContentBox(String contentBox) {
		this.contentBox = contentBox;
	}

	@Override
	public String toString() {
		return "Box[" + indexLine + ", " + indexColumn + "]";
	}
}
