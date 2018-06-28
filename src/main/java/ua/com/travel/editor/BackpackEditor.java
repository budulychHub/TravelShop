package ua.com.travel.editor;

import java.beans.PropertyEditorSupport;

import ua.com.travel.service.BackpackService;

public class BackpackEditor extends PropertyEditorSupport{

	private final BackpackService backpackService;

	public BackpackEditor(BackpackService backpackService) {
		super();
		this.backpackService = backpackService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(backpackService.findOne(Integer.parseInt(text)));
	}
}
