package com.idcard.school.dao;

import java.util.List;
import com.idcard.school.model.IDCardWrapper;

public interface IDCardSystemDao{
	
	public boolean insertCQL(IDCardWrapper idCardWrapper);
	
	public IDCardWrapper selectOneCQL(IDCardWrapper idCardWrapper);
	
	public List<IDCardWrapper> selectAllCQL(List<String> listOfSerialno, String session, String university, String college,
			String degree);
	
	public IDCardWrapper updateCQL(IDCardWrapper idCardWrapper);
	
	public boolean deleteCQL(IDCardWrapper idCardWrapper);


}
