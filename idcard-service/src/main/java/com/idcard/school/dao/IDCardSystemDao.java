package com.idcard.school.dao;

import java.util.List;
import java.util.Map;

import com.idcard.school.model.IDCardWrapper;

public interface IDCardSystemDao{
	
	public boolean insertCQL(String query);
	
	public IDCardWrapper selectOneCQL(String query);
	
	public List<IDCardWrapper> selectAllCQL(String query);
	
	public IDCardWrapper updateCQL(String query);
	
	public boolean deleteCQL(String query);


}
