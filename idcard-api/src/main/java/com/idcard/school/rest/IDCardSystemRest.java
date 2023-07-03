package com.idcard.school.rest;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.BYTE_ARRAY;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idcard.school.model.IDCardWrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@ResponseBody
@FeignClient(name = "IDCardSystemRest", url = "${idcard-service.url}", path = "/idcard", primary = false)
@Api(tags = { "IDCardSystemRest" })
@SwaggerDefinition(tags = { @Tag(name = "IDcardSystem", description = "Rest APIs of IDCardSystem") })
public interface IDCardSystemRest {

	@GetMapping(path = "home")
	public String home();

	@ApiOperation(value = "To create Student IDCard ", response = Map.class, tags = "createIdcard", extensions = {
			@Extension(properties = { @ExtensionProperty(name = "x-auth-type", value = "None") }) })
	@PostMapping(path = "createIdcard", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public IDCardWrapper createIdcard(
			@ApiParam(value = "to pass idcard wrapper") @NonNull @RequestBody(required = true) IDCardWrapper idCardWrapper) throws Exception;

	@ApiOperation(value = "To get Student IDCard ", response = BYTE_ARRAY.class, tags = "getIdcard", extensions = {
			@Extension(properties = { @ExtensionProperty(name = "x-auth-type", value = "None") }) })
	@GetMapping(path = "getIdcard", produces = { MediaType.APPLICATION_OCTET_STREAM_VALUE })
	public byte[] getIdcard(
			@ApiParam(value = "to pass student serial number") @NonNull @RequestParam(required = true, name = "serialNo") String serialNo,
			@ApiParam(value = "to pass college session") @RequestParam(required = false, name = "session") String session,
			@ApiParam(value = "to pass student university Name") @RequestParam(required = false, name = "university") String university,
			@ApiParam(value = "to pass student college Name") @RequestParam(required = false, name = "college") String college,
			@ApiParam(value = "to pass student degree Name") @RequestParam(required = false, name = "degree") String degree);

	@ApiOperation(value = "To get List of Student IDCard by session, serialno and college", response = BYTE_ARRAY.class, tags = "getListOfIdcard", extensions = {
			@Extension(properties = { @ExtensionProperty(name = "x-auth-type", value = "None") }) })
	@GetMapping(path = "getListOfIdcard", produces = { MediaType.APPLICATION_OCTET_STREAM_VALUE })
	public byte[] getListOfIdcard(
			@ApiParam(value = "to pass list of student serial number") @RequestBody(required = false) List<String> listOfSerialno,
			@ApiParam(value = "to pass college session") @NonNull @RequestParam(required = true, name = "session") String session,
			@ApiParam(value = "to pass student university Name") @NonNull @RequestParam(required = true, name = "university") String university,
			@ApiParam(value = "to pass student college Name") @NonNull @RequestParam(required = true, name = "college") String college,
			@ApiParam(value = "to pass student degree Name") @NonNull @RequestParam(required = true, name = "degree") String degree);

	@ApiOperation(value = "To get List of Student IDCard by session, serialno and college", response = Map.class, tags = "getBufferdListOfIdcard", extensions = {
			@Extension(properties = { @ExtensionProperty(name = "x-auth-type", value = "None") }) })
	@GetMapping(path = "getBufferdListOfIdcard", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Map<String, BufferedImage> getBufferdListOfIdcard(
			@ApiParam(value = "to pass list of student serial number") @RequestBody(required = false) List<String> listOfSerialno,
			@ApiParam(value = "to pass college session") @NonNull @RequestParam(required = true, name = "session") String session,
			@ApiParam(value = "to pass student university Name") @NonNull @RequestParam(required = true, name = "university") String university,
			@ApiParam(value = "to pass student college Name") @NonNull @RequestParam(required = true, name = "college") String college,
			@ApiParam(value = "to pass student degree Name") @NonNull @RequestParam(required = true, name = "degree") String degree);

}
