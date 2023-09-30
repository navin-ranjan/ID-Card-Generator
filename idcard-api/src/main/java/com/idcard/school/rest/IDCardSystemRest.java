package com.idcard.school.rest;

import javax.print.DocFlavor.BYTE_ARRAY;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.idcard.school.model.ResponseWrapper;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@ResponseBody
@FeignClient(name = "IDCardSystemRest", url = "${idcard-service.url}", path = "/idcard", primary = false)
//@Api(tags = { "ID Card Generator " })
@SwaggerDefinition(tags = { @Tag(name = "IDcardSystem", description = "Rest APIs of IDCardSystem") })
public interface IDCardSystemRest {

	@GetMapping(path = "ping")
	public String home();

	@ApiOperation(value = "To create Student IDCard ", response =Object.class, tags = "createIdcard", extensions = {
			@Extension(properties = { @ExtensionProperty(name = "x-auth-type", value = "None") }) })
	@PostMapping(path = "createIdcard", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseWrapper createIdcard(
			@ApiParam(value = "to pass student serial number") @NonNull @RequestParam(required = true, name = "serialNo") String serialNo,
			@ApiParam(value = "to pass student Name") @NonNull @RequestParam(required = true, name = "name") String name,
			@ApiParam(value = "to pass student Father name") @NonNull @RequestParam(required = true, name = "fatherName") String fatherName,
			@ApiParam(value = "to pass student Gender") @NonNull @RequestParam(required = true, name = "gender") String gender,
			@ApiParam(value = "to pass student dob") @NonNull @RequestParam(required = true, name = "dob") String dob,
			@ApiParam(value = "to pass student email") @NonNull @RequestParam(required = true, name = "email") String email,
			@ApiParam(value = "to pass student mobile number") @NonNull @RequestParam(required = true, name = "mobileNumber") String mobileNumber,
			@ApiParam(value = "to pass college session") @RequestParam(required = false, name = "session") String session,
			@ApiParam(value = "to pass student university Name") @RequestParam(required = false, name = "university") String university,
			@ApiParam(value = "to pass student college Name") @RequestParam(required = false, name = "college") String college,
			@ApiParam(value = "to pass student degree Name") @RequestParam(required = false, name = "degree") String degree,
			@ApiParam(value = "to pass student address") @RequestParam( name = "address") String address,
			@RequestPart("photo") @ApiParam(value="upload passport size photo", required=true) MultipartFile photo)
			throws Exception;


	@ApiOperation(value = "To get Student IDCard ", response = BYTE_ARRAY.class, tags = "getIdcard", extensions = {
			@Extension(properties = { @ExtensionProperty(name = "x-auth-type", value = "None") }) })
	@GetMapping(path = "getIdcard", produces = { MediaType.APPLICATION_OCTET_STREAM_VALUE })
	public byte[] getIdcard(
			@ApiParam(value = "to pass student serial number") @NonNull @RequestParam(required = true, name = "serialNo") String serialNo,
			@ApiParam(value = "to pass college session") @RequestParam(required = false, name = "session") String session,
			@ApiParam(value = "to pass student university Name") @RequestParam(required = false, name = "university") String university,
			@ApiParam(value = "to pass student college Name") @RequestParam(required = false, name = "college") String college,
			@ApiParam(value = "to pass student degree Name") @RequestParam(required = false, name = "degree") String degree);

	
}
