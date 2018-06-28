package ua.com.travel.editor;

import java.beans.PropertyEditorSupport;

import ua.com.travel.service.ProviderService;

public class ProviderEditor extends PropertyEditorSupport{

	
	private final ProviderService providerService;

	public ProviderEditor(ProviderService providerService) {
		super();
		this.providerService = providerService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException{
		setValue(providerService.findOne(Integer.parseInt(text)));
	}
}
