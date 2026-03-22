package entities;

import org.lwjgl.util.vector.Vector3f;

public class Light {

	private Vector3f position;
	private Vector3f color;
	private float strength;
	
	public Light(Vector3f pos, Vector3f col) {
		this.position = pos;
		this.color = col;
	}
	
	public Vector3f getPosition() {
		return this.position;
	}
	public Vector3f getColor() {
		return this.color;
	}
	public float getStrenght() {
		return this.strength;
	}
	
	public void setPosition(Vector3f nPos) {
		position = nPos;
	}
	public void setColor(Vector3f nCol) {
		color = nCol;
	}
	public void setStrength(float ns) {
		strength = ns;
	}
	
	public void changeStrength(float s) {
		this.color.x *= s;
		this.color.y *= s;
		this.color.z *= s;
	}
}
