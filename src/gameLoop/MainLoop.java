package gameLoop;

import org.lwjgl.opengl.Display;
import displayManager.DisplayManager;
import displayManager.Loader;
import displayManager.Renderer;
import entities.Camera;
import shaders.StaticShader;
import tools.SpawnGallery;

public class MainLoop {
	
	public static void main(String[] args) {
		DisplayManager.createDisplay();
		Camera camera = new Camera();
		
		Loader loader = new Loader();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);
		
		SpawnGallery.createGallery();

		while(!Display.isCloseRequested()) {		
			camera.moveCam();
			renderer.prepare();
			shader.start();

			shader.loadViewMatrix(camera); 
			
			SpawnGallery.renderGallery(renderer, shader);
			
			shader.stop();
			DisplayManager.updateDisplay();
		}
		
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
	
}
