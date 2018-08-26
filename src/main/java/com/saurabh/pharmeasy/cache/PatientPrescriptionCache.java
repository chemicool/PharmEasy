package com.saurabh.pharmeasy.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PatientPrescriptionCache {
	public static void loadCache(){
		patientPrescriptionMap = new HashMap<Integer,List<Integer>>();
		//to be implemented with db config available 
	}
	private static Map<Integer,List<Integer>> patientPrescriptionMap;
	public static void addPrescription(Integer patientId, Integer prescriptionId){
		if(patientPrescriptionMap==null) loadCache();
		if(patientPrescriptionMap.get(patientId)==null){
			List<Integer> list = new LinkedList<Integer>();
			list.add(prescriptionId);
			patientPrescriptionMap.put(patientId, list);
		}else{
			List<Integer> ls = patientPrescriptionMap.get(patientId);
			ls.add(prescriptionId);
			patientPrescriptionMap.put(patientId, ls);
		}
	}
	public static List<Integer> getPrescriptionIds(Integer patientId){
		return patientPrescriptionMap.get(patientId);
	}
}
