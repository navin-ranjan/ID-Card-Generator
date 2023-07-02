package com.idcard.school.dao;

import java.util.List;
import java.util.Map;

import com.idcard.school.model.IDCardWrapper;

public interface IDCardSystemDao{
	
	public IDCardWrapper createIdcard(IDCardWrapper idCardWrapper);
	
	public byte [] getIdcard(String serialNo, Map<String,String> filter);	
	
	public Map<String, byte []> getByteListOfIdcard(List<String> listOfSerialno, Map<String,String> filter); 


}
