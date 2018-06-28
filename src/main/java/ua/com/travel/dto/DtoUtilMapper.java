package ua.com.travel.dto;

import java.util.ArrayList;
import java.util.List;

import ua.com.travel.entity.Backpack;
import ua.com.travel.entity.Map;
import ua.com.travel.entity.Provider;
import ua.com.travel.entity.SleepingBag;
import ua.com.travel.entity.Tent;

public class DtoUtilMapper {


	public static List<BackpackDto> backpackToBackpackDto (List<Backpack> backpacks){
		List<BackpackDto> backpackDtos = new ArrayList<BackpackDto>();
		for (Backpack backpack : backpacks) {
			backpackDtos.add(new BackpackDto(backpack.getBrand(),
					backpack.getVolume(), backpack.getWeight(),
					backpack.getPrice()));
		}
		return backpackDtos;
	}

	
	public static List<MapDto> mapToMapDtos (List<Map> maps){
		List<MapDto> mapDtos= new ArrayList<MapDto>();
		for (Map map: maps) {
			mapDtos.add(new MapDto(map.getNameLacality(),
					map.getScale(), map.getPrice()));
		}
		return mapDtos;
	}

	
	public static List<ProviderDto> providerToProviderDtos (List<Provider> providers){
		List<ProviderDto> providerDtos = new ArrayList<ProviderDto>();
		for (Provider provider : providers) {
			providerDtos.add(new ProviderDto(provider.getName(),
					provider.getEmail(), provider.getPhone()));
		}
		return providerDtos;
		
	}
	
	
	public static List<SleepingBagDto> sleepingBagToSleepingBagDtos (List<SleepingBag> sleepingBags){
		List<SleepingBagDto> sleepingBagDtos = new ArrayList<SleepingBagDto>();
		for (SleepingBag sleepingBag : sleepingBags) {
			sleepingBagDtos.add(new SleepingBagDto(sleepingBag.getBrand(),
					sleepingBag.getWeight(), sleepingBag.getHeight(),
					sleepingBag.getPrice()));
		}
		return sleepingBagDtos;
	}
	
	public static List<TentDto> tentToTentDtos (List<Tent> tents){
		List<TentDto> tentDtos = new ArrayList<TentDto>();
		for (Tent tent : tents) {
			tentDtos.add(new TentDto(tent.getBrand(),
					tent.getCopacity(), tent.getWeight(),
					tent.getPrice()));
		}
		return tentDtos;
	}
	 
	
	
	
	
	
	
	
	
	
}
