package map_assets;

public class Box {

	private int indexLine;
	private int indexColumn;
	private boolean isEmpty;
	private Entity contentBox = new Entity();
	
	/**
	 * Constructor.
	 * @param indexLine
	 * @param indexColumn
	 */
	public Box(int indexLine, int indexColumn) {
		this.indexLine = indexLine;
		this.indexColumn = indexColumn;
		this.isEmpty = true;
		this.contentBox.tag = " ";
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
	public Entity getContentBox() {
		return contentBox;
	}
	public void setContentBox(Entity contentBox) {
		this.contentBox = contentBox;
	}

	@Override
	public String toString() {
		return "Box[" + indexLine + ", " + indexColumn + "]";
	}
	
}
