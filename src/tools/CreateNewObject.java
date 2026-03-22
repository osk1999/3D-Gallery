package tools;

import org.lwjgl.util.vector.Vector3f;

import displayManager.Loader;
import entities.Entity;
import models.RawModel;
import models.TexturedModel;
import objLoader.ObjectData;
import textures.ModelTexture;

public class CreateNewObject {
	
	public static Entity create(ObjectData obj, String textLoc, Vector3f pos, Vector3f rot, float scale, float ref, float sd) {
		Loader loader = new Loader();
		
		RawModel quad = loader.loadVAO(obj.getVertices(), obj.getTextureCoords(), obj.getNormalCoords(), obj.getIndices());
		ModelTexture texture = new ModelTexture(loader.LoadTexture(textLoc));
		texture.setReflectivity(ref);
		texture.setShineDamp(sd);
		TexturedModel texturedQuad = new TexturedModel(quad, texture);
		Entity newEntity = new Entity(texturedQuad, new Vector3f(pos.x, pos.y, pos.z), rot.x, rot.y, rot.z, scale);
		
		return newEntity;
	}
	
}
