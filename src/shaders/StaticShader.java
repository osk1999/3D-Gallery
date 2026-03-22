package shaders;

import java.util.ArrayList;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;
import entities.Light;
import tools.MathHelp;

public class StaticShader extends ShaderProgram {

	private static final String VERTEX_FILE = "src/shaders/vertexShader.txt";
	private static final String FRAGMENT_FILE = "src/shaders/fragmentShader.txt";
	
	private int transformMatrixLocation;
	private int projectionMatrixLocation;
	private int viewMatrixLocation;
	
	private int locLightNumPos;
	private int locLightPos;
	private int locLightCol;
	
	private int locReflectivity;
	private int locShineDamp;
	
	public StaticShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttributes(0, "position");
		super.bindAttributes(1, "textureCoords");
		super.bindAttributes(2, "normalData");
	}

	@Override
	protected void getAllUniformLocations() {
		transformMatrixLocation = super.getUniformLocation("transformMatrix");
		projectionMatrixLocation = super.getUniformLocation("projectionMatrix");
		viewMatrixLocation = super.getUniformLocation("viewMatrix");
		locLightPos = super.getUniformLocation("lightPosition");
		locLightCol = super.getUniformLocation("lightColors");
		locReflectivity = super.getUniformLocation("reflectivity");
		locShineDamp = super.getUniformLocation("shineDamp");
		locLightNumPos = super.getUniformLocation("lightNum");
	}
	
	public void loadSpecularData(float r, float sd) {
		super.loadFloat(locReflectivity, r);
		super.loadFloat(locShineDamp, sd);
	}
	
	public void loadLights(ArrayList<Light> lights) {
		int lightNum = lights.size();
		super.loadInt(locLightNumPos, lightNum);
		
		Vector3f[] lightPosArr = new Vector3f[lightNum];
		Vector3f[] lightColArr = new Vector3f[lightNum];
		
		for(int i = 0; i < lightNum; i++) {
			lightPosArr[i] = lights.get(i).getPosition();
			lightColArr[i] = lights.get(i).getColor();
		}
		
		super.loadVector3Arr(locLightPos, lightPosArr);
		super.loadVector3Arr(locLightCol, lightColArr);
	}
	
	public void loadTransformMatrix(Matrix4f matrix) {
		super.loadMatrix(transformMatrixLocation, matrix);
	}
	
	public void loadProjectionMatrix(Matrix4f matrix) {
		super.loadMatrix(projectionMatrixLocation, matrix);
	}
	
	public void loadViewMatrix(Camera cam) {
		Matrix4f viewMatrix = MathHelp.createViewMatrix(cam);
		super.loadMatrix(viewMatrixLocation, viewMatrix);
	}
}
