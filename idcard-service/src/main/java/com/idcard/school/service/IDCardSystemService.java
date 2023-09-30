package com.idcard.school.service;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

import com.idcard.school.model.IDCardWrapper;
import com.idcard.school.model.ResponseWrapper;

public interface IDCardSystemService {
	
	public ResponseWrapper createIdcard(IDCardWrapper idCardWrapper);
	
	public byte [] getIdcard(String serialNo, String session, String university, String college, String degree);
	
	public Map<String, byte[]> getListOfIdcard(List<String> listOfSerialno, String session, String university, String college, String degree); 
	
	public Map<String, BufferedImage> getBufferdListOfIdcard(List<String> listOfSerialno, String session, String university, String college, String degree); 

}
