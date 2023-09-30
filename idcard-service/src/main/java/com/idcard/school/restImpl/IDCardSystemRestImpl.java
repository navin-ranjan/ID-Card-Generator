package com.idcard.school.restImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.idcard.school.model.IDCardWrapper;
import com.idcard.school.model.ResponseWrapper;
import com.idcard.school.rest.IDCardSystemRest;
import com.idcard.school.service.IDCardSystemService;

import io.netty.util.internal.StringUtil;

@RestController
@RequestMapping(path = "/idcard")
@Primary
public class IDCardSystemRestImpl implements IDCardSystemRest {

	private Logger logger = LogManager.getLogger(IDCardSystemRestImpl.class);

	private static final byte[] Empty_Byte = null;

	@Autowired
	private IDCardSystemService idService;

	@Override
	public String home() {
		logger.info("Insider the home method");
		return "ok";
	}

	@Override
	public ResponseWrapper createIdcard(String serialNo, String name, String fatherName, String gender, String dob,
			String email, String mobileNumber, String session, String university, String college, String degree,
			String address, MultipartFile photo) throws Exception {
		if (!StringUtil.isNullOrEmpty(name) && !StringUtil.isNullOrEmpty(serialNo) && photo != null) {
			IDCardWrapper idCardWrapper = new IDCardWrapper(serialNo, name, fatherName, gender, dob, university,
					college, degree, session, address, mobileNumber, email, photo.getBytes());
			logger.info("Insider the createIdcard method with entity value : {}", idCardWrapper.toStringSize());
			return idService.createIdcard(idCardWrapper);
		} else {
			logger.error("name: {}, serialno : {} not valid", name, serialNo);

		}
		return new ResponseWrapper();
	}

	@Override
	public byte[] getIdcard(String serialNo, String session, String university, String college, String degree) {
		logger.info(
				"Insider the getIdcard method  serialNo : {}, session : {}, university : {}, college : {}, degree : {}",
				serialNo, session, university, college, degree);
		if (!StringUtil.isNullOrEmpty(serialNo)) {
			return idService.getIdcard(serialNo, session, university, college, degree);
		} else
			logger.error("serialno : {}", serialNo);

		return Empty_Byte;
	}	

}
