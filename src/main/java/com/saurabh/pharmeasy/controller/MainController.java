package com.saurabh.pharmeasy.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saurabh.pharmeasy.model.Prescription;
import com.saurabh.pharmeasy.model.User;
import com.saurabh.pharmeasy.service.CreateService;
import com.saurabh.pharmeasy.service.GetPrescriptionService;

@Controller
@RequestMapping("/assignmnet")
public class MainController {
	@RequestMapping(value="/createUser")
	@ResponseBody
	public static User createUser(@RequestParam int id,@RequestParam  String name,@RequestParam  String role){
		return CreateService.createUser(id, name, role);
	}
	
	@RequestMapping(value="/createPrescription")
	@ResponseBody
	public static Prescription createPrescription(@RequestParam int id, @RequestParam int docId, @RequestParam int patientId, 
			@RequestParam String jsonMedicineMap) throws JsonParseException, JsonMappingException, IOException{
		return CreateService.createPrescription(id, docId, patientId, jsonMedicineMap);
	}
	
	@RequestMapping(value="/getPrescriptions")
	@ResponseBody
	public static List<Prescription> getPrescriptions(@RequestParam int userId){
		return GetPrescriptionService.getPrescriptions(userId);
	}
}
