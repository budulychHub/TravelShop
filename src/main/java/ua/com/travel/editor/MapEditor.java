package ua.com.travel.editor;

import java.beans.PropertyEditorSupport;

import ua.com.travel.service.MapService;

public class MapEditor extends PropertyEditorSupport {

	
	private final MapService mapService;

	public MapEditor(MapService mapService) {
		super();
		this.mapService = mapService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(mapService.findOne(Integer.parseInt(text)));
	}
}
