package com.cryptocurrency.backend.services;

import com.cryptocurrency.entity.objects.Cryptocurrency;
import com.cryptocurrency.nomics.objects.Cryptocurrency;

public class ToEntity {
	
	public void toEntity(Cryptocurrency entity, Cryptocurrency obj) {
	    
	    entity.setDescription(obj.getDescription());
	    entity.setExecutionDate(obj.getExecutionDate());
	    entity.setElement(obj.getElement());
	    entity.setCoccole(obj.getCoccole());
	    //Variable that is not recived by api
	    entity.setMario("PROVA MARIO"));
	}

}
