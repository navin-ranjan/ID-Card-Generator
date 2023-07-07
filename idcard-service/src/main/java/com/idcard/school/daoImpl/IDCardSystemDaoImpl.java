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
	public boolean insertCQL(String query) {
		return false;
	}

	@Override
	public IDCardWrapper selectOneCQL(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IDCardWrapper> selectAllCQL(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDCardWrapper updateCQL(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCQL(String query) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
