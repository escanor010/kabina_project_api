package Kabina.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kabina.Repository.ShelfRepository;
import Kabina.DTO.BusinessUnitShelves;
import Kabina.DTO.FloorShelves;
import Kabina.Model.Shelf;

@Service
public class ShelfService {

	@Autowired
	private ShelfRepository shelfRepository;
	
	public List<Shelf> getAllShelves(){
		return shelfRepository.findAll();
	}
	
	private Map<String,Object> classifyShelves() {
		List<Shelf> listShelves = shelfRepository.findAll();
		Map<String,Object> mapShelves = new HashMap<String , Object>();
		Map<Long,List<Shelf>> mapBusinessUnitShelves = new HashMap<Long,List<Shelf>>();
		Map<Long,List<Shelf>> mapFloorShelves = new HashMap<Long,List<Shelf>>();
		
		for (int i=0;i<listShelves.size();i++) {
		    long key  = listShelves.get(i).getBusinessUnit().getId();
		    if(mapBusinessUnitShelves.containsKey(key)){
		        List<Shelf> list = mapBusinessUnitShelves.get(key);
		        list.add(listShelves.get(i));
		    }else{
		    	List<Shelf> list = new ArrayList<Shelf>();
		        list.add(listShelves.get(i));
		        mapBusinessUnitShelves.put(key, list);
		    }
		}

		for (int i=0;i<listShelves.size();i++) {
		    long key  = listShelves.get(i).getFloor();
		    if(mapFloorShelves.containsKey(key)){
		        List<Shelf> list = mapFloorShelves.get(key);
		        list.add(listShelves.get(i));
		    }else{
		    	List<Shelf> list = new ArrayList<Shelf>();
		        list.add(listShelves.get(i));
		        mapFloorShelves.put(key, list);
		    }
		}
		
		mapShelves.put("BusinessUnit", mapBusinessUnitShelves);
		mapShelves.put("Floor", mapFloorShelves);
		return mapShelves;
	}
	
	public Map<String,Object> analyzeShelves(){
		List<FloorShelves> listFloorShelves = new ArrayList<>();
		List<BusinessUnitShelves> listBusinessUnitShelves = new ArrayList<>();
		Map<String,Object> mapShelves = classifyShelves();
		Map<Long,List<Shelf>> mapBusinessUnitShelves = (Map<Long, List<Shelf>>) mapShelves.get("BusinessUnit");
		Map<Long,List<Shelf>> mapFloorShelves = (Map<Long, List<Shelf>>) mapShelves.get("Floor");
		
		for (Map.Entry<Long,List<Shelf>> entry : mapBusinessUnitShelves.entrySet()) {  
			List<Shelf> list = entry.getValue();
			List<Shelf> availableShelves = new ArrayList<>();
			List<Shelf> bookedShelves = new ArrayList<>();
			long businessUnitId = list.get(0).getBusinessUnit().getId();
			String businessUnitName = list.get(0).getBusinessUnit().getName();

			for(int i=0;i<list.size();i++) {
				if(list.get(i).getUser_shelf() == null) {
					availableShelves.add(list.get(i));
				}
				else{
					bookedShelves.add(list.get(i));
				}
			}
			BusinessUnitShelves businessUnitShelves = new BusinessUnitShelves(businessUnitId,businessUnitName,availableShelves,bookedShelves);
			listBusinessUnitShelves.add(businessUnitShelves);
		}
			
		for (Map.Entry<Long,List<Shelf>> entry : mapFloorShelves.entrySet()) {  
			List<Shelf> list = entry.getValue();
			List<Shelf> availableShelves = new ArrayList<>();
			List<Shelf> bookedShelves = new ArrayList<>();
			
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getUser_shelf() == null) {
					availableShelves.add(list.get(i));
				}
				else {
					bookedShelves.add(list.get(i));
				}
			}
			FloorShelves floorShelves = new FloorShelves(entry.getKey(),availableShelves,bookedShelves);
			listFloorShelves.add(floorShelves);
		}
		
		Map<String,Object> mapResponse = new HashMap<String,Object>();
		mapResponse.put("FloorReport", listFloorShelves);
		mapResponse.put("BusinessUnitReport", listBusinessUnitShelves);
		return mapResponse;
	}

	public List<Shelf> getAllShelvesByUnitId(long id) {
		
		return shelfRepository.getAllShelvesByUnitId(id);
	}

}
