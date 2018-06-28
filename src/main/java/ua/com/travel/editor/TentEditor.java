package ua.com.travel.editor;

import java.beans.PropertyEditorSupport;

import ua.com.travel.service.TentService;

public class TentEditor extends PropertyEditorSupport{

	
	private final TentService tentService;

	public TentEditor(TentService tentService) {
		super();
		this.tentService = tentService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(tentService.findOne(Integer.parseInt(text)));
	}
}
