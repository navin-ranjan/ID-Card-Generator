package com.idcard.school.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;

import com.idcard.school.dao.IDCardSystemDao;
import com.idcard.school.model.IDCardWrapper;


public class IDCardSystemDaoImpl implements IDCardSystemDao{
	

	@Override
	public IDCardWrapper createIdcard(IDCardWrapper idCardWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getIdcard(String serialNo, Map<String, String> filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, byte[]> getByteListOfIdcard(List<String> listOfSerialno, Map<String, String> filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
