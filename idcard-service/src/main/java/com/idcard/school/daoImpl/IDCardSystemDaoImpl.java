package com.idcard.school.daoImpl;

import java.nio.ByteBuffer;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.insert.Insert;
import com.idcard.school.dao.IDCardSystemDao;
import com.idcard.school.model.IDCardWrapper;

@Service
public class IDCardSystemDaoImpl implements IDCardSystemDao {

	private static Logger logger = LogManager.getLogger(IDCardSystemDaoImpl.class);

	@Autowired
	CassandraOperations cassandraOperations;

	private static final String KEYSPACE_NAME = "idcardsystem";
	private static final String TABLE_NAME = "idcard";
	private static final String serialno = "serialno";
	private static final String session = "session";
	private static final String university = "university";
	private static final String degree = "degree";
	private static final String college = "college";
	private static final String name = "name";
	private static final String fathername = "fathername";
	private static final String gender = "gender";
	private static final String dob = "dob";
	private static final String mobile = "mobile";
	private static final String email = "email";
	private static final String address = "address";
	private static final String photo = "photo";
	private static final String image = "image";

	@Override
	public boolean insertCQL(IDCardWrapper idCardWrapper) {
		logger.info("Insider the createIdcard method with entity value : {} ", idCardWrapper.toStringSize());
		ByteBuffer bufferphoto = ByteBuffer.wrap(idCardWrapper.getPhoto());
		ByteBuffer bufferimage = ByteBuffer.wrap(idCardWrapper.getImage());

		Insert insertQuery = QueryBuilder.insertInto(KEYSPACE_NAME, TABLE_NAME)
				.value(serialno, QueryBuilder.literal(idCardWrapper.getSerialNumber()))
				.value(session, QueryBuilder.literal(idCardWrapper.getSession()))
				.value(university, QueryBuilder.literal(idCardWrapper.getUniversityName()))
				.value(degree, QueryBuilder.literal(idCardWrapper.getDegree()))
				.value(college, QueryBuilder.literal(idCardWrapper.getCollegeName()))
				.value(name, QueryBuilder.literal(idCardWrapper.getName()))
				.value(fathername, QueryBuilder.literal(idCardWrapper.getFatherName()))
				.value(gender, QueryBuilder.literal(idCardWrapper.getGender()))
				.value(dob, QueryBuilder.literal(idCardWrapper.getDob()))
				.value(mobile, QueryBuilder.literal(idCardWrapper.getMobile()))
				.value(email, QueryBuilder.literal(idCardWrapper.getEmail()))
				.value(address, QueryBuilder.literal(idCardWrapper.getAddress()))
				.value(photo, QueryBuilder.literal(bufferphoto))
				.value(image, QueryBuilder.literal(bufferimage));

		// logger.info("CQL Query for insert : {}", insertQuery.asCql());
		ResultSet resultSet = cassandraOperations.execute(insertQuery.build());
		if (!resultSet.wasApplied()) {
			return false;
		}
		return true;
	}

	@Override
	public IDCardWrapper selectOneCQL(IDCardWrapper idCardWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IDCardWrapper> selectAllCQL(List<String> listOfSerialno, String session, String university,
			String college, String degree) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDCardWrapper updateCQL(IDCardWrapper idCardWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCQL(IDCardWrapper idCardWrapper) {
		// TODO Auto-generated method stub
		return false;
	}

}
