package com.saurabh.pharmeasy.model;

import java.util.Map;

public class Prescription {
	private Integer id;
	private Integer docId;
	private Integer patientId;
	public Prescription(Integer id, Integer docId, Integer patientId, Map<String, Integer> medicines) {
		super();
		this.id = id;
		this.docId = docId;
		this.patientId = patientId;
		this.medicines = medicines;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDocId() {
		return docId;
	}
	public void setDocId(Integer docId) {
		this.docId = docId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Map<String, Integer> getMedicines() {
		return medicines;
	}
	public void setMedicines(Map<String, Integer> medicines) {
		this.medicines = medicines;
	}
	private Map<String,Integer> medicines;
	
}
