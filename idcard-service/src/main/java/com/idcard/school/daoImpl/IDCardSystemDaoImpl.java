package com.idcard.school.daoImpl;

import java.nio.ByteBuffer;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.cql.Statement;
import com.datastax.oss.driver.api.core.cql.StatementBuilder;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.insert.Insert;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import com.idcard.school.dao.IDCardSystemDao;
import com.idcard.school.model.IDCardWrapper;

import io.netty.util.internal.StringUtil;

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
		try {

			Select select = QueryBuilder.selectFrom(KEYSPACE_NAME, TABLE_NAME).all().whereColumn(serialno)
					.isEqualTo(QueryBuilder.literal(idCardWrapper.getSerialNumber()));
			if (!StringUtil.isNullOrEmpty(idCardWrapper.getSession())) {
				select = select.whereColumn(session).isEqualTo(QueryBuilder.literal(idCardWrapper.getSession()));
			}
			if (!StringUtil.isNullOrEmpty(idCardWrapper.getUniversityName())) {
				select = select.whereColumn(university)
						.isEqualTo(QueryBuilder.literal(idCardWrapper.getUniversityName()));
			}
			if (!StringUtil.isNullOrEmpty(idCardWrapper.getCollegeName())) {
				select = select.whereColumn(college).isEqualTo(QueryBuilder.literal(idCardWrapper.getCollegeName()));
			}
			if (!StringUtil.isNullOrEmpty(idCardWrapper.getDegree())) {
				select = select.whereColumn(degree).isEqualTo(QueryBuilder.literal(idCardWrapper.getDegree()));
			}
			logger.info("Select CQL Query : {}", select.asCql());
			ResultSet resultSet = cassandraOperations.execute(select.build());

			if (resultSet.wasApplied()) {
				for(Row row:resultSet){
					idCardWrapper.setPhoto(row.getBytesUnsafe(photo).array());
					idCardWrapper.setImage(row.getBytesUnsafe(image).array());
					idCardWrapper.setAddress(row.getString(address));
					idCardWrapper.setDob(row.getString(dob));
					idCardWrapper.setEmail(row.getString(email));
					idCardWrapper.setFatherName(row.getString(fathername));
					idCardWrapper.setGender(row.getString(gender));
					idCardWrapper.setMobile(row.getString(mobile));
					idCardWrapper.setName(row.getString(name));
				}
				logger.info("Data found image size : {}",idCardWrapper.getImage().length);
				return idCardWrapper;
			}		

		} catch (Exception e) {
			logger.error("Data not available in database : {}",e.getMessage());
		}

		return new IDCardWrapper();
	}

	@Override
	public List<IDCardWrapper> selectAllCQL(List<String> listOfSerialno, String sessionString, String universityName, String collegeString, String degreeString) {
		try {

			Select select = QueryBuilder.selectFrom(KEYSPACE_NAME, TABLE_NAME).all().whereColumn(serialno)
			.in(QueryBuilder.literal(listOfSerialno));
			if (!StringUtil.isNullOrEmpty(sessionString)) {
				select = select.whereColumn(session).isEqualTo(QueryBuilder.literal(sessionString));
			}
			if (!StringUtil.isNullOrEmpty(universityName)) {
				select = select.whereColumn(university).isEqualTo(QueryBuilder.literal(universityName));
			}
			if (!StringUtil.isNullOrEmpty(collegeString)) {
				select = select.whereColumn(college).isEqualTo(QueryBuilder.literal(collegeString));
			}
			if (!StringUtil.isNullOrEmpty(degreeString)) {
				select = select.whereColumn(degree).isEqualTo(QueryBuilder.literal(degreeString));
			}
			String selectQuery =select.asCql().replace("[", "").replace("]","");
			
			SimpleStatement statement=SimpleStatement.newInstance(selectQuery);
			logger.info("Select CQL Query : {}", selectQuery);
			ResultSet resultSet = cassandraOperations.execute(statement);
			List<IDCardWrapper> resultOfIdcard=new ArrayList<>();

			if (resultSet.wasApplied()) {
				for(Row row:resultSet){
					IDCardWrapper idCardWrapper=new IDCardWrapper();
					idCardWrapper.setUniversityName(universityName);
					idCardWrapper.setCollegeName(collegeString);
					idCardWrapper.setSession(sessionString);
					idCardWrapper.setDegree(degreeString);
					idCardWrapper.setPhoto(row.getBytesUnsafe(photo).array());
					idCardWrapper.setImage(row.getBytesUnsafe(image).array());
					idCardWrapper.setAddress(row.getString(address));
					idCardWrapper.setDob(row.getString(dob));
					idCardWrapper.setEmail(row.getString(email));
					idCardWrapper.setFatherName(row.getString(fathername));
					idCardWrapper.setGender(row.getString(gender));
					idCardWrapper.setMobile(row.getString(mobile));
					idCardWrapper.setName(row.getString(name));
					resultOfIdcard.add(idCardWrapper);
				}
				logger.info("Data found No. of row :{}",resultOfIdcard.size());
				return resultOfIdcard;
			}		

		} catch (Exception e) {
			logger.error("error found in select all query : {}",e.getMessage());
		}

		return new ArrayList<IDCardWrapper>();
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
