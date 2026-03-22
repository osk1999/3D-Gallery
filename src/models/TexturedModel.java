package models;

import textures.ModelTexture;

public class TexturedModel {
	private RawModel model;
	private ModelTexture texture;
	
	public TexturedModel(RawModel m, ModelTexture t) {
		this.model = m;
		this.texture = t;
	}
	
	public RawModel getRawModel() {
		return model;
	}
	
	public ModelTexture getTexture() {
		return texture;
	}
}
