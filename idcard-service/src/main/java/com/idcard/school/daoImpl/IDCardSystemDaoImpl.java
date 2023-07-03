package com.idcard.school.daoImpl;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;

import com.idcard.school.dao.IDCardSystemDao;
import com.idcard.school.model.IDCardWrapper;


public class IDCardSystemDaoImpl implements IDCardSystemDao{
	
	@Autowired
	CassandraOperations cassandraOperations;

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
