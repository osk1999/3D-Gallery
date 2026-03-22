package tools;

import java.util.ArrayList;

import org.lwjgl.util.vector.Vector3f;

import displayManager.Renderer;
import entities.Entity;
import entities.Light;
import objLoader.ObjectData;
import objLoader.loadOBJ;
import shaders.StaticShader;

public class SpawnGallery {
	
	private static ArrayList<Entity> entities = new ArrayList<Entity>();
	private static ArrayList<Light> lights = new ArrayList<Light>();
	
	public static void createGallery() {
		// Section 1 - Head(L) Goober(R)
		ObjectData rex_head_objdata = loadOBJ.loadObjFromFile("obj_files/rex_head/rhead");
		Entity rex_head = CreateNewObject.create(rex_head_objdata, "obj_files/rex_head/RexHeadBaked", 
				new Vector3f(10, 0, 0f), new Vector3f(0, 180, 0), 1f, 0, 0);
		entities.add(rex_head);
		
		ObjectData rex_goober_objdata = loadOBJ.loadObjFromFile("obj_files/rex_goober/goober");
		Entity rex_goober = CreateNewObject.create(rex_goober_objdata, "obj_files/rex_goober/GooberTexture", 
				new Vector3f(-10f, 0, 0f), new Vector3f(0, 180, 0), 1f, 0, 0);
		entities.add(rex_goober);
		
		
		//Section 2 - 5(L) 5(R)
		//L
		ObjectData rBlame_objdata = loadOBJ.loadObjFromFile("obj_files/rex_fighting_game/blame");
		Entity rBlame = CreateNewObject.create(rBlame_objdata, "obj_files/rex_fighting_game/BlameBaked", new Vector3f(-20f, -1f, -25f), new Vector3f(0, 235, 0), 1, 0, 0);
		entities.add(rBlame);
		
		ObjectData rCyberpunk_objdata = loadOBJ.loadObjFromFile("obj_files/rex_fighting_game/cyberpunk");
		Entity rCyberpunk = CreateNewObject.create(rCyberpunk_objdata, "obj_files/rex_fighting_game/CyberpunkBaked", new Vector3f(-15f, -1f, -30f), new Vector3f(0, 235, 0), 1, 0, 0);
		entities.add(rCyberpunk);
		
		ObjectData rGuts_objdata = loadOBJ.loadObjFromFile("obj_files/rex_fighting_game/guts");
		Entity rGuts = CreateNewObject.create(rGuts_objdata, "obj_files/rex_fighting_game/GutsBaked", new Vector3f(-10f, -1f, -35f), new Vector3f(0, 235, 0), 1, 0, 0);
		entities.add(rGuts);
		
		ObjectData rHotline_objdata = loadOBJ.loadObjFromFile("obj_files/rex_fighting_game/hotline");
		Entity rHotline = CreateNewObject.create(rHotline_objdata, "obj_files/rex_fighting_game/HotlineBaked", 
				new Vector3f(-5f, -1f, -40f), new Vector3f(0, 235, 0), 1, 0, 0);
		entities.add(rHotline);
		
		
		//R
		ObjectData rUltrakill_objdata = loadOBJ.loadObjFromFile("obj_files/rex_fighting_game/ultrakill");
		Entity rUltrakill = CreateNewObject.create(rUltrakill_objdata, "obj_files/rex_fighting_game/UltrakillBaked", 
				new Vector3f(20f, -1f, -25f), new Vector3f(0, -225f, 0f), 1, 0, 0);
		entities.add(rUltrakill);
		
		ObjectData rJojo_objdata = loadOBJ.loadObjFromFile("obj_files/rex_fighting_game/jojos");
		Entity rJojo = CreateNewObject.create(rJojo_objdata, "obj_files/rex_fighting_game/JojoBaked", 
				new Vector3f(15f, -1f, -32.5f), new Vector3f(0, -225f, 0f), 1, 0, 0);
		entities.add(rJojo);
		
		ObjectData rNier_objdata = loadOBJ.loadObjFromFile("obj_files/rex_fighting_game/nier");
		Entity rNier = CreateNewObject.create(rNier_objdata, "obj_files/rex_fighting_game/NierBaked", 
				new Vector3f(10f, -1f, -40f), new Vector3f(0, -225f, 0f), 1, 0, 0);
		entities.add(rNier);
		
		ObjectData rInvincible_objdata = loadOBJ.loadObjFromFile("obj_files/rex_fighting_game/invincible");
		Entity rInvincible = CreateNewObject.create(rInvincible_objdata, "obj_files/rex_fighting_game/InvincibleBaked", 
				new Vector3f(5f, -1f, -47.5f), new Vector3f(0, -225f, 0f), 1, 0, 0);
		entities.add(rInvincible);
		
		
		//Section 3 - Cuthand (L) Jester head (R)
		ObjectData rCuthand_objdata = loadOBJ.loadObjFromFile("obj_files/cuthand/cuthand");
		Entity rCuthand = CreateNewObject.create(rCuthand_objdata, "obj_files/cuthand/CuthandBaked", 
				new Vector3f(-15f, 0f, -70f), new Vector3f(0, 0, 180), 0.3f, 0, 0);
		entities.add(rCuthand);
		
		ObjectData rJesterhead_objdata = loadOBJ.loadObjFromFile("obj_files/jester_head/jester");
		Entity rJesterhead = CreateNewObject.create(rJesterhead_objdata, "obj_files/jester_head/JesterHeadBake", 
				new Vector3f(15f, 3f, -70f), new Vector3f(0, 0, 0), 3, 0, 0);
		entities.add(rJesterhead);
		
		
		//Section 4 - DreamSScape (L) City of stars (R)
		ObjectData rDS_water_objdata = loadOBJ.loadObjFromFile("obj_files/game_cutscene/water");
		Entity rDS_water = CreateNewObject.create(rDS_water_objdata, "obj_files/game_cutscene/WaterBaked", 
				new Vector3f(-30f, -3f, -125f), new Vector3f(0, 0, 0), 1, 0, 0);
		entities.add(rDS_water);
		
		ObjectData rDS_moongod_objdata = loadOBJ.loadObjFromFile("obj_files/game_cutscene/moon_god");
		Entity rDS_moongod = CreateNewObject.create(rDS_moongod_objdata, "obj_files/game_cutscene/MoonGodBaked", 
				new Vector3f(-30f, 10f, -135f), new Vector3f(25f, 0f, 0f), 0.1f, 0, 0);
		entities.add(rDS_moongod);
		
		ObjectData rDS_Mc_objdata = loadOBJ.loadObjFromFile("obj_files/game_cutscene/mc");
		Entity rDS_Mc = CreateNewObject.create(rDS_Mc_objdata, "obj_files/game_cutscene/McBaked", 
				new Vector3f(-30f, 0.5f, -115f), new Vector3f(0, 0, 0), 0.5f, 0, 0);
		entities.add(rDS_Mc);
		
		ObjectData rDs_Sky_objdata = loadOBJ.loadObjFromFile("obj_files/game_cutscene/sky");
		Entity rDS_Sky = CreateNewObject.create(rDs_Sky_objdata, "obj_files/game_cutscene/SkyBaked", 
				new Vector3f(-30f, 0.5f, -125f), new Vector3f(0, 90, 0), 0.75f, 0, 0);
		entities.add(rDS_Sky);
		
		ObjectData COS_Set_objdata = loadOBJ.loadObjFromFile("obj_files/city_of_stars/CityOfStars");
		Entity COS_Set = CreateNewObject.create(COS_Set_objdata, "obj_files/city_of_stars/CityoStarsBaked", 
				new Vector3f(30f, 0f, -125f), new Vector3f(0f, -90f, 0f), 0.5f, 0, 0);
		entities.add(COS_Set);
		
		ObjectData COS_Bg_objdata = loadOBJ.loadObjFromFile("obj_files/city_of_stars/CityOfStarsBg");
		Entity COS_Bg = CreateNewObject.create(COS_Bg_objdata, "obj_files/city_of_stars/CityoStarsBgBaked", 
				new Vector3f(60f, 25f, -125f), new Vector3f(0, -90f, 0f), 0.5f, 0, 0);
		entities.add(COS_Bg);
		
		
		//Section 5 - Dessendre (L) Sword of lumiere (L) Monolith (Front)
		ObjectData E33_Mon_objdata = loadOBJ.loadObjFromFile("obj_files/e33/disaster_expedition");
		Entity E33_Mon = CreateNewObject.create(E33_Mon_objdata, "obj_files/e33/deBaked", 
				new Vector3f(0f, 0f, -500f), new Vector3f(0, 0, 0), 3, 0, 0);
		entities.add(E33_Mon);
		
		ObjectData E33_Dessendre_objdata = loadOBJ.loadObjFromFile("obj_files/e33/dessandre_family");
		Entity E33_Dessendre = CreateNewObject.create(E33_Dessendre_objdata, "obj_files/e33/DessendreBaked", 
				new Vector3f(-50f, 0f, -300f), new Vector3f(0, 45f, 0), 3, 0, 0);
		entities.add(E33_Dessendre);
		
		ObjectData E33_Lumiere_objdata = loadOBJ.loadObjFromFile("obj_files/e33/sword_of_lumiere");
		Entity E33_Lumiere = CreateNewObject.create(E33_Lumiere_objdata, "obj_files/e33/SwordBaked", 
				new Vector3f(150f, 0f, -300f), new Vector3f(0, -90f, 0), 3, 0, 0);
		entities.add(E33_Lumiere);
		
		ObjectData floor_objdata = loadOBJ.loadObjFromFile("obj_files/floor");
		Entity floor = CreateNewObject.create(floor_objdata, "obj_files/FloorBakedHighres", 
				new Vector3f(0, -3.5f, 0f), new Vector3f(0, 0, 0), 0.85f, 0, 0);
		entities.add(floor);
		
		loadLights();
	}
	
	public static void loadLights() {
		
		//load light representation 3d models
		ObjectData light_objdata = loadOBJ.loadObjFromFile("obj_files/light");
		
		Entity light1 = CreateNewObject.create(light_objdata, "obj_files/LightBaked", 
				new Vector3f(-10, 15, 0), new Vector3f(0, 0, 0), 1, 0, 0);
		entities.add(light1);
		
		Entity light2 = CreateNewObject.create(light_objdata, "obj_files/LightBaked", 
				new Vector3f(10, 15, 0), new Vector3f(0, 20, 0), 1, 0, 0);
		entities.add(light2);
		
		Entity light3 = CreateNewObject.create(light_objdata, "obj_files/LightBaked", 
				new Vector3f(-15, 17.5f, -30), new Vector3f(0, 230, 0), 1, 0, 0);
		entities.add(light3);
		
		Entity light4 = CreateNewObject.create(light_objdata, "obj_files/LightBaked", 
				new Vector3f(15, 17.5f, -30), new Vector3f(0, 10, 0), 1, 0, 0);
		entities.add(light4);
		
		Entity light5 = CreateNewObject.create(light_objdata, "obj_files/LightBaked", 
				new Vector3f(-15, 15f, -70), new Vector3f(0, 10, 0), 1, 0, 0);
		entities.add(light5);
		
		Entity light6 = CreateNewObject.create(light_objdata, "obj_files/LightBaked", 
				new Vector3f(15, 15f, -70), new Vector3f(0, 10, 0), 1, 0, 0);
		entities.add(light6);
		
		Entity light7= CreateNewObject.create(light_objdata, "obj_files/LightBaked", 
				new Vector3f(-30, 25f, -125), new Vector3f(0, 10, 0), 1, 0, 0);
		entities.add(light7);
		
		Entity light8= CreateNewObject.create(light_objdata, "obj_files/LightBaked", 
				new Vector3f(0, 225f, -500), new Vector3f(0, 10, 0), 6.5f, 0, 0);
		entities.add(light8);
		
		Entity light9= CreateNewObject.create(light_objdata, "obj_files/LightBaked", 
				new Vector3f(-50, 65f, -300), new Vector3f(0, 10, 0), 3, 0, 0);
		entities.add(light9);
		
		Entity light10= CreateNewObject.create(light_objdata, "obj_files/LightBaked", 
				new Vector3f(165, 100f, -300), new Vector3f(0, 10, 0), 3, 0, 0);
		entities.add(light10);
		
		
		//load real lights
		Light rLight1 = new Light(new Vector3f(-10, 10, 0), new Vector3f(1f, 1f, 1f));
		rLight1.changeStrength(20f);
		lights.add(rLight1);
		
		Light rLight2 = new Light(new Vector3f(10, 10, 0), new Vector3f(1f, 1f, 1f));
		rLight2.changeStrength(20f);
		lights.add(rLight2);
		
		Light rLight3 = new Light(new Vector3f(-15, 12.5f, -30), new Vector3f(1f, 1f, 1f));
		rLight3.changeStrength(10f);
		lights.add(rLight3);
		
		Light rLight4 = new Light(new Vector3f(15, 12.5f, -30), new Vector3f(1f, 1f, 1f));
		rLight4.changeStrength(10f);
		lights.add(rLight4);
		
		Light rLight5 = new Light(new Vector3f(-15, 10f, -70), new Vector3f(1f, 1f, 1f));
		rLight5.changeStrength(5f);
		lights.add(rLight5);
		
		Light rLight6 = new Light(new Vector3f(15, 10f, -70), new Vector3f(1f, 1f, 1f));
		rLight6.changeStrength(10f);
		lights.add(rLight6);
		
		Light rLight7 = new Light(new Vector3f(-30, 20f, -125), new Vector3f(1f, 1f, 1f));
		rLight7.changeStrength(20f);
		lights.add(rLight7);
		
		Light rLightCityOfStars = new Light(new Vector3f(30, 15f, -112.5f), new Vector3f(1f, 1f, 0.65f));
		rLightCityOfStars.changeStrength(15f);
		lights.add(rLightCityOfStars);
		
		Light rLightCityOfStarsBg = new Light(new Vector3f(50, 15f, -125f), new Vector3f(1f, 0.65f, 1f));
		rLightCityOfStarsBg.changeStrength(5f);
		lights.add(rLightCityOfStarsBg);
		
		Light rLight8 = new Light(new Vector3f(0, 200f, -500), new Vector3f(1f, 1f, 1f));
		rLight8.changeStrength(750f);
		lights.add(rLight8);
		
		Light e33MonolithExtraLight = new Light(new Vector3f(0, 100f, -415), new Vector3f(1f, 1f, 0.75f));
		e33MonolithExtraLight.changeStrength(350f);
		lights.add(e33MonolithExtraLight);
		
		Light rLight9 = new Light(new Vector3f(-50, 45f, -300), new Vector3f(1f, 1f, 1f));
		rLight9.changeStrength(100f);
		lights.add(rLight9);
		
		Light rLight10 = new Light(new Vector3f(165, 80, -300), new Vector3f(1f, 1f, 1f));
		rLight10.changeStrength(100f);
		lights.add(rLight10);
		
		Light lumiereSwordExtra = new Light(new Vector3f(150, 15, -300), new Vector3f(1f, 1f, 0.65f));
		lumiereSwordExtra.changeStrength(100f);
		lights.add(lumiereSwordExtra);
	}
	
	public static void renderGallery(Renderer renderer, StaticShader shader) {
		shader.loadLights(lights);
		
		for(Entity entity : entities) {
			renderer.render(entity, shader);
		}
	}
}
