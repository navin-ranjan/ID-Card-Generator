package com.idcard.school.restImpl;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idcard.school.model.IDCardWrapper;
import com.idcard.school.rest.IDCardSystemRest;
import com.idcard.school.service.IDCardSystemService;

import io.netty.util.internal.StringUtil;

@RestController
@RequestMapping(path = "/idcard")
@Primary
public class IDCardSystemRestImpl implements IDCardSystemRest {
	
	private Logger logger= LogManager.getLogger(IDCardSystemRestImpl.class);
	
	private static final byte [] Empty_Byte=null;
	private static final IDCardWrapper Empty_IDCard_Data=null;
	
	@Autowired
	private IDCardSystemService idService;

	@Override
	public String home() {
		logger.info("Insider the home method");
		return "welcome to Idcard project ... !";
	}

	@Override
	public IDCardWrapper createIdcard(IDCardWrapper idCardWrapper) {
		logger.info("Insider the createIdcard method with entity value : {} ", idCardWrapper.toString());
			if(!StringUtil.isNullOrEmpty(idCardWrapper.getName())&& !StringUtil.isNullOrEmpty(idCardWrapper.getSerialNumber())) {
				validateFatherName(idCardWrapper.getFatherName());
				validateGender(idCardWrapper.getGender());
				validateDOB(idCardWrapper.getDob());
				validateDegree(idCardWrapper.getDegree());
				validateSession(idCardWrapper.getSession());
				validateMobile(idCardWrapper.getMobile());
				validateUniversityandCollege(idCardWrapper.getUniversityName(),idCardWrapper.getCollegeName());
				validateAddress(idCardWrapper.getAddress());
				return idService.createIdcard(idCardWrapper);
			} else {
				logger.error("name: {} and serialno : {} not valid",idCardWrapper.getName(),idCardWrapper.getSerialNumber());
				
			}
		return Empty_IDCard_Data;
	}

	@Override
	public byte[] getIdcard(String serialNo, String session, String university, String college, String degree) {
		validateParam(session,university,college,degree);
		return null;
	}

	
	@Override
	public byte[] getListOfIdcard(List<String> listOfSerialno, String session, String university, String college,String degree) {
		validateParam(session,university,college,degree);
		return Empty_Byte;
	}

	@Override
	public Map<String, BufferedImage> getBufferdListOfIdcard(List<String> listOfSerialno, String session, String university, String college,
			String degree) {
		validateParam(session,university,college,degree);
		return null;
	}
	
	private void validateParam(String session, String university, String college, String degree) {
		validateSession(session);
		validateDegree(degree);
		validateUniversityandCollege(university,college);		
		
	}

	
	private void validateAddress(String address) {
		// TODO Auto-generated method stub
		
	}

	private void validateUniversityandCollege(String universityName, String collegeName) {
		// TODO Auto-generated method stub
		
	}
	
	private void validateMobile(String mobile) {
		// TODO Auto-generated method stub
		
	}

	private void validateDegree(String degree) {
		// TODO Auto-generated method stub
		
	}

	private void validateSession(String session) {
		// TODO Auto-generated method stub
		
	}

	private void validateDOB(String dob) {
		// TODO Auto-generated method stub
		
	}

	private void validateGender(String gender) {
		// TODO Auto-generated method stub
		
	}

	private void validateFatherName(String fatherName) {
		// TODO Auto-generated method stub
		
	}

}
