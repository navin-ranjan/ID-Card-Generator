package com.idcard.school.rest;

//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
//@FeignClient(name = "IDCardSystemRest", url = "${idcard-service.url}", path = "/idcard", primary = false)
public interface IDCardSystemRest {

	@GetMapping("/name")
	public String home();
}
