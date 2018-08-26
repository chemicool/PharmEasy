package com.saurabh.pharmeasy.cache;

import java.util.HashMap;
import java.util.Map;

import com.saurabh.pharmeasy.model.Prescription;

public class PrescriptionCache {
	private static Map<Integer, Prescription> prescriptionMap;
	public static void loadCache(){
		prescriptionMap = new HashMap<Integer,Prescription>();
	}
	public static Prescription getPrescription(Integer prescriptionId){
		return prescriptionMap.get(prescriptionId);
	}
	public static void putPrescription(Integer prescriptionId, Prescription prescription){
		if(prescriptionMap==null) loadCache();
		prescriptionMap.put(prescriptionId, prescription);
	}
}
