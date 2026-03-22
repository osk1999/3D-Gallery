package entities;

import org.lwjgl.input.Keyboard;

import org.lwjgl.util.vector.Vector3f;

public class Camera {
	private Vector3f position = new Vector3f(0, 0, 25);
	private float pitch = 0;
	private float yaw = 0;
	private float roll = 0;
	
	public void moveCam() {		
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			yaw -= 0.75f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			yaw += 0.75f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			if (position.z < 35 && position.z > -400 && position.x > -150 && position.x < 150) {
				position.z -= Math.cos(Math.toRadians(yaw)) * 0.075f; //0.05f for both
				position.x += (float) Math.sin(Math.toRadians(yaw)) * 0.075f;
			}
			else {
				position = new Vector3f(0, 0, 25);
				yaw = 0;
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			if (position.z < 35 && position.z > -400 && position.x > -150 && position.x < 150) {
				position.z += Math.cos(Math.toRadians(yaw)) * 0.075f;
				position.x -= (float) Math.sin(Math.toRadians(yaw)) * 0.075f;
			}
			else {
				position = new Vector3f(0, 0, 25);
				yaw = 0;
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
			if (pitch < 25f) {
				pitch += 0.5f;
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_E)) {
			if (pitch > -30f) {
				pitch -= 0.5f;
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
				position.y += 0.075f; 
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			if (position.y > -3) {
				position.y -= 0.075f; 
			}
		}
	}
	
	public Vector3f getPosition() {
		return position;
	}
	public void setPosition(Vector3f position) {
		this.position = position;
	}
	public float getPitch() {
		return pitch;
	}
	public void setPitch(float pitch) {
		this.pitch = pitch;
	}
	public float getYaw() {
		return yaw;
	}
	public void setYaw(float yaw) {
		this.yaw = yaw;
	}
	public float getRoll() {
		return roll;
	}
	public void setRoll(float roll) {
		this.roll = roll;
	}
}
