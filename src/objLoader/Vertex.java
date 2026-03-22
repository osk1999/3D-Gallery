package objLoader;

import org.lwjgl.util.vector.Vector3f;

public class Vertex {
	private static final int NO_INDEX = -1;
	
	private Vector3f position;
	private int textureIndex = NO_INDEX;
	private int normalIndex = NO_INDEX;
	private Vertex duplicateVert = null;
	private int index;
	private float length;
	
	public Vertex(int i, Vector3f p) {
		this.index = i;
		this.position = p;
		this.length = position.length();
	}
	
	public boolean isSet() {
		return textureIndex != NO_INDEX && normalIndex != NO_INDEX;
	}
	
	public boolean hasSameTextureAndNormal(int ti, int ni) {
		return textureIndex == ti && normalIndex == ni;
	}
	
	public void setPosition(Vector3f p){
		position = p;
	}
	
	public void setTextureIndex(int ti) {
		textureIndex = ti;
	}
	
	public void setNormalIndex(int ni) {
		normalIndex = ni;
	}
	
	public void setDuplicateVertex(Vertex v) {
		duplicateVert = v;
	}
	
	public void setIndex(int i) {
		index = i;
	}
	
	public void setLength(float l) {
		length = l;
	}
	
	public float getLength() {
		return this.length;
	}
	
	public Vector3f getPosition() {
		return this.position;
	}
	
	public int getTextureIndex() {
		return this.textureIndex;
	}
	
	public int getNormalIndex() {
		return this.normalIndex;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public Vertex getDuplicateVertex() {
		return this.duplicateVert;
	}
	
	public float getLenght() {
		return this.length;
	}
}
