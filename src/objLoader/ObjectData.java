package objLoader;

public class ObjectData {
	private float[] vertices;
	private float[] textureCoords;
	private float[] normalCoords;
	private int[] indices;
	
	public ObjectData(float[] v, float[] tc, float[] nc, int[] i) {
		this.vertices = v;
		this.textureCoords = tc;
		this.normalCoords = nc;
		this.indices = i;
	}
	
	public float[] getVertices() {
		return vertices;
	}
	public void setVertices(float[] vertices) {
		this.vertices = vertices;
	}
	public float[] getTextureCoords() {
		return textureCoords;
	}
	public void setTextureCoords(float[] textureCoords) {
		this.textureCoords = textureCoords;
	}
	public float[] getNormalCoords() {
		return normalCoords;
	}
	public void setNormalCoords(float[] normalCoords) {
		this.normalCoords = normalCoords;
	}
	public int[] getIndices() {
		return indices;
	}
	public void setIndices(int[] indices) {
		this.indices = indices;
	}
}
