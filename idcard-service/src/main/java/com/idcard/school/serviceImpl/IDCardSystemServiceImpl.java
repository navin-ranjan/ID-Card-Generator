package com.idcard.school.serviceImpl;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.idcard.school.model.IDCardWrapper;
import com.idcard.school.service.IDCardSystemService;

@Service
public class IDCardSystemServiceImpl implements IDCardSystemService{

	@Override
	public IDCardWrapper createIdcard(IDCardWrapper idCardWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getIdcard(String serialNo, String session, String university, String college, String degree) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getListOfIdcard(List<String> listOfSerialno, String session, String university, String college,
			String degree) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, BufferedImage> getBufferdListOfIdcard(List<String> listOfSerialno, String session,
			String university, String college, String degree) {
		// TODO Auto-generated method stub
		return null;
	}

}
