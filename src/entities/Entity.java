package entities;

import org.lwjgl.util.vector.Vector3f;

import models.TexturedModel;

public class Entity {
	
	private TexturedModel model;
	private Vector3f translate;
	private float roX, roY, roZ;
	private float scale;
	
	public Entity(TexturedModel m, Vector3f t, float rx, float ry, float rz, float s) {
		this.model = m;
		this.translate = t;
		this.roX = rx;
		this.roY = ry;
		this.roZ = rz;
		this.scale = s;
	}
	
	public void changePosition(Vector3f newPos) {
		this.translate.x += newPos.x;
		this.translate.y += newPos.y;
		this.translate.z += newPos.z;
	}
	
	public void changeRotation(Vector3f newRot) {
		this.roX += newRot.x;
		this.roY += newRot.y;
		this.roZ += newRot.z;
	}

	public TexturedModel getModel() {
		return model;
	}

	public void setModel(TexturedModel model) {
		this.model = model;
	}

	public Vector3f getTranslate() {
		return translate;
	}

	public void setTranslate(Vector3f translate) {
		this.translate = translate;
	}

	public float getRoX() {
		return roX;
	}

	public void setRoX(float roX) {
		this.roX = roX;
	}

	public float getRoY() {
		return roY;
	}

	public void setRoY(float roY) {
		this.roY = roY;
	}

	public float getRoZ() {
		return roZ;
	}

	public void setRoZ(float roZ) {
		this.roZ = roZ;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}
	
	
}
