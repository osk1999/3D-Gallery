package objLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class loadOBJ {
	public static ObjectData loadObjFromFile(String filename) {
		List<Vertex> vertexArray = new ArrayList<Vertex>();
		List<Vector2f> textureArray = new ArrayList<Vector2f>();
		List<Vector3f> normalArray = new ArrayList<Vector3f>();
		List<Integer> indicesArray = new ArrayList<Integer>();
		
		FileReader fr = null;
		File readFile = new File("res/"+filename+".obj");
		try {
			fr = new FileReader(readFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try (BufferedReader reader = new BufferedReader(fr)) {
			String line = "";
			while(true) {
				try {
					line = reader.readLine();
					String[] currVertInfo = line.split(" ");
					
					if(line.startsWith("v ")) {
						Vector3f vecPos = new Vector3f((float) Float.valueOf(currVertInfo[1]),
								(float) Float.valueOf(currVertInfo[2]),
								(float) Float.valueOf(currVertInfo[3]));
						Vertex newVert = new Vertex(vertexArray.size(), vecPos);
						vertexArray.add(newVert);
					}
					else if (line.startsWith("vt ")) {
						Vector2f texturePos = new Vector2f((float) Float.valueOf(currVertInfo[1]),
								(float) Float.valueOf(currVertInfo[2]));
						textureArray.add(texturePos);
					}
					else if (line.startsWith("vn ")) {
						Vector3f normalPos = new Vector3f((float) Float.valueOf(currVertInfo[1]),
								(float) Float.valueOf(currVertInfo[2]),
								(float) Float.valueOf(currVertInfo[3]));
						normalArray.add(normalPos);
					}
					else if(line.startsWith("f ")) {
						break;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			while(line != null) {
				if (line.startsWith("f ")) {
					String[] currFaceInfo = line.split(" ");
					String[] vert1 = currFaceInfo[1].split("/");
					String[] vert2 = currFaceInfo[2].split("/");
					String[] vert3 = currFaceInfo[3].split("/");
					processVertex(vert1, vertexArray, indicesArray);
					processVertex(vert2, vertexArray, indicesArray);
					processVertex(vert3, vertexArray, indicesArray);
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		removeUnusedVertices(vertexArray);
		float[] finVertCoords = new float[vertexArray.size() * 3];
		float[] finTextCoords = new float[vertexArray.size() * 2];
		float[] finNormCoords = new float[vertexArray.size() * 3];
		int[] finIndices = indicesListToArray(indicesArray);
		
		PopulateArrays(finVertCoords, finTextCoords, finNormCoords, 
				vertexArray, textureArray, normalArray);
		
		ObjectData finalObjData = new ObjectData(finVertCoords, finTextCoords, finNormCoords, finIndices);
		
		return finalObjData; 
	}
	
	public static void processVertex(String[] vertI, List<Vertex> vertexArray, List<Integer> indices) {
		int index = Integer.parseInt(vertI[0]) - 1;
		Vertex currVert = vertexArray.get(index);
		int textureIndex = Integer.parseInt(vertI[1]) - 1;
		int normalIndex = Integer.parseInt(vertI[2]) - 1;
		if(!currVert.isSet()) {
			currVert.setTextureIndex(textureIndex);
			currVert.setNormalIndex(normalIndex);
			indices.add(index);
		}
		else {
			resolveSetVertex(currVert, textureIndex, normalIndex, indices, vertexArray);
		}
	}
	
	public static void resolveSetVertex(Vertex vert, int newTI, int newNI, List<Integer> ind, List<Vertex> vArr) {
		if(vert.hasSameTextureAndNormal(newTI, newNI)) {
			ind.add(vert.getIndex());
		}
		else {
			Vertex newVert = vert.getDuplicateVertex();
			if (newVert != null) {
				resolveSetVertex(newVert, newTI, newNI, ind, vArr);
			}
			else {
				Vertex dupeVert = new Vertex(vArr.size(), vert.getPosition());
				dupeVert.setTextureIndex(newTI);
				dupeVert.setNormalIndex(newNI);
				vert.setDuplicateVertex(dupeVert);
				vArr.add(dupeVert);
				ind.add(dupeVert.getIndex());
			}
		}
	}
	
	public static void removeUnusedVertices(List<Vertex> vArr) {
		for (Vertex v : vArr) {
			if (!v.isSet()) {
				v.setTextureIndex(0);
				v.setNormalIndex(0);
			}
		}
	}
	
	public static int[] indicesListToArray(List<Integer> ind) {
		int[] indArr = new int[ind.size()];
		for (int i = 0; i < indArr.length; i++) {
			indArr[i] = ind.get(i);
		}
		
		return indArr;
	}
	
	public static void PopulateArrays(float[] v, float[] t, float[] n, 
			List<Vertex> vArr, List<Vector2f> tArr, List<Vector3f> nArr) {
		for(int i = 0; i < vArr.size(); i++) {
			Vertex currVert = vArr.get(i);
			
			v[i * 3] = currVert.getPosition().x;
			v[i * 3 + 1] = currVert.getPosition().y;
			v[i * 3 + 2] = currVert.getPosition().z;
			
			t[i * 2] = tArr.get(currVert.getTextureIndex()).x;
			t[i * 2 + 1] = 1 - tArr.get(currVert.getTextureIndex()).y;
			
			n[i * 3] = nArr.get(currVert.getNormalIndex()).x;
			n[i * 3 + 1] = nArr.get(currVert.getNormalIndex()).y;
			n[i * 3 + 2] = nArr.get(currVert.getNormalIndex()).z;
		}
	}

}
