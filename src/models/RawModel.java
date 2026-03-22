package models;

public class RawModel {
	private int vaoID;
	private int vertexCount;
	
	public RawModel(int id, int vc) {
		this.vaoID = id;
		this.vertexCount = vc;
	}
	
	public int getVaoID() {
		return vaoID;
	}
	
	public int getVertCount() {
		return vertexCount;
	}
}
