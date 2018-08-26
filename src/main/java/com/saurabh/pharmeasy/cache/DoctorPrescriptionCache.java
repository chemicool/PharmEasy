package com.saurabh.pharmeasy.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DoctorPrescriptionCache {
	public static void loadCache(){
		doctorPrescriptionMap = new HashMap<Integer,List<Integer>>();
		//to be implemented with db config available 
	}
	private static Map<Integer,List<Integer>> doctorPrescriptionMap;
	public static void addPrescription(Integer doctorId, Integer prescriptionId){
		if(doctorPrescriptionMap==null) loadCache();
		if(doctorPrescriptionMap.get(doctorId)==null){
			List<Integer> list = new LinkedList<Integer>();
			list.add(prescriptionId);
			doctorPrescriptionMap.put(doctorId, list);
		}else{
			List<Integer> ls = doctorPrescriptionMap.get(doctorId);
			ls.add(prescriptionId);
			doctorPrescriptionMap.put(doctorId, ls);
		}
	}
	public static List<Integer> getPrescriptionIds(Integer doctorId){
		return doctorPrescriptionMap.get(doctorId);
	}
}
