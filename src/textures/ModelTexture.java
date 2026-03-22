package textures;

public class ModelTexture {
	private int textureId;
	
	private float reflectivity = 0;
	private float shineDamp = 1;

	public ModelTexture(int id) {
		this.textureId = id;
	}
	
	public int getID() {
		return textureId;
	}
	
	public float getReflectivity() {
		return this.reflectivity;
	}
	
	public float getShineDamp() {
		return this.shineDamp;
	}
	
	public void setReflectivity(float nr) {
		reflectivity = nr;
	}
	
	public void setShineDamp(float nsd) {
		shineDamp = nsd;
	}
}
