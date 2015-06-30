package models;

import java.util.TreeMap;

public class MaterialCatalog {

	private TreeMap<String,Material> materialMap;
	
	public MaterialCatalog() {
		materialMap = new TreeMap<String,Material>();
	}
	
	
	public void addMaterial(Material newMaterial){
		materialMap.put(newMaterial.getID(), newMaterial);
	}
	
	public TreeMap<String,Material> getMap() {
		return materialMap;
	}
	
	public Material findMaterial(String title) throws MaterialNotFoundExcepton {

		title = title.trim();

		for (Material nextMaterial : materialMap.values()) {
			
			if (nextMaterial.getTitle().equals(title)) {
				return nextMaterial;
			}
		}

		throw new MaterialNotFoundExcepton();
	}
	
	public int getNumberOfMaterials(){
		return materialMap.size();
	}
}
