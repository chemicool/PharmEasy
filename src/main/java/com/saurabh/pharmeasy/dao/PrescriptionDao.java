package com.saurabh.pharmeasy.dao;

import com.saurabh.pharmeasy.cache.PrescriptionCache;
import com.saurabh.pharmeasy.model.Prescription;

public class PrescriptionDao {
	public static void setPrescription(Prescription prescription){
		PrescriptionCache.putPrescription(prescription.getId(), prescription);
	}
}
