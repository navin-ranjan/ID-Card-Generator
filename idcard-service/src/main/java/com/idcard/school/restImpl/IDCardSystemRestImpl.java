package com.idcard.school.restImpl;

import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.insert.Insert;
import com.datastax.oss.driver.api.querybuilder.insert.JsonInsert;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import com.datastax.oss.driver.api.querybuilder.term.Term;
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
	
	@Autowired
	private static CassandraOperations cassandraOperations;
	
	public static void main(String[] args) {
				
		// to select data query		
		List<String> values = Arrays.asList("value1", "value2", "value3");		
		Select query=QueryBuilder.selectFrom("idcardsystem", "idcard").all().whereColumn("name").isEqualTo(QueryBuilder.literal("navin"))
				;
		query=query.whereColumn("id").in(QueryBuilder.literal(values));
		System.out.println(query.build());
		
		try {
			//cassandraOperations.insert(query.build());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//to data insert query
		byte[] data = new byte[]{0x01, 0x02, 0x03};
		ByteBuffer buffer = ByteBuffer.wrap(data);
		Insert insertQuery = QueryBuilder.insertInto("keyspace_name", "table_name")
                .value("column1", QueryBuilder.literal("value1"))
                .value("column2", QueryBuilder.literal(42))
                .value("column3", QueryBuilder.literal(true))
                .value("column5", QueryBuilder.literal(buffer));
		
//		byte[] data = new byte[]{0x01, 0x02, 0x03};
//
//        // Convert the byte array to a ByteBuffer
//        ByteBuffer buffer = ByteBuffer.wrap(data);
		System.out.println(insertQuery.asCql());
	}

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
