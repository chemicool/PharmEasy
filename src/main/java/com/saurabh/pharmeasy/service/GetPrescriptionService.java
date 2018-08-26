package com.saurabh.pharmeasy.service;

import java.util.List;
import java.util.stream.Collectors;

import com.saurabh.pharmeasy.cache.DoctorPrescriptionCache;
import com.saurabh.pharmeasy.cache.PatientPrescriptionCache;
import com.saurabh.pharmeasy.cache.PrescriptionCache;
import com.saurabh.pharmeasy.cache.UserCache;
import com.saurabh.pharmeasy.model.Prescription;
import com.saurabh.pharmeasy.model.Role;
import com.saurabh.pharmeasy.model.User;

public class GetPrescriptionService {
	public static List<Prescription> getPrescriptions(Integer userId){
		User user = UserCache.getUser(userId);
		if(user.getRole().getRoleName().equalsIgnoreCase(Role.Doctor.getRoleName())){
			List<Integer> prescriptionIds = DoctorPrescriptionCache.getPrescriptionIds(userId);
			return prescriptionIds.stream().map(i->PrescriptionCache.getPrescription(i)).collect(Collectors.toList());
		}else{
			List<Integer> prIds = PatientPrescriptionCache.getPrescriptionIds(userId);
			return prIds.stream().map(i->PrescriptionCache.getPrescription(i)).collect(Collectors.toList());
		}
	}
}
