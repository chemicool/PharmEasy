package com.saurabh.pharmeasy.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.saurabh.pharmeasy.cache.DoctorPrescriptionCache;
import com.saurabh.pharmeasy.cache.PatientPrescriptionCache;
import com.saurabh.pharmeasy.dao.PrescriptionDao;
import com.saurabh.pharmeasy.dao.UserDao;
import com.saurabh.pharmeasy.model.Prescription;
import com.saurabh.pharmeasy.model.Role;
import com.saurabh.pharmeasy.model.User;

public class CreateService {
	public static User createUser(Integer id, String name, String role){
		if(role.equalsIgnoreCase(Role.Doctor.getRoleName())){
			User user = new User(id,name,Role.Doctor);
			UserDao.setUser(user);
			return user;
		}else{
			User usr = new User(id,name,Role.Patient);
			UserDao.setUser(usr);
			return usr;
		}
	}
	
	public static Prescription createPrescription(Integer id, Integer docId, Integer patientId,
			String jsonMedicineMap) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map = mapper.readValue(jsonMedicineMap, new TypeReference<Map<String,Integer>>(){});
		Prescription pr = new Prescription(id, docId, patientId, map);
		DoctorPrescriptionCache.addPrescription(docId, id);
		PatientPrescriptionCache.addPrescription(patientId, id);
		PrescriptionDao.setPrescription(pr);
		return pr;
	}
}
