package ua.com.travel.editor;

import java.beans.PropertyEditorSupport;

import ua.com.travel.service.SleepingBagService;

public class SleepingEditor extends PropertyEditorSupport{

	private final SleepingBagService sleepingBagService;

	public SleepingEditor(SleepingBagService sleepingBagService) {
		super();
		this.sleepingBagService = sleepingBagService;
	}
	
	@Override
	public void setAsText (String text) throws IllegalArgumentException{
		setValue(sleepingBagService.findOne(Integer.parseInt(text)));
	}
}
