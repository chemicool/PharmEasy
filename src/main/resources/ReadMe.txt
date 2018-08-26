This webapp is submitted as the solution to the problem provided by PharmEasy in Assignment round.

Problem Statement:

There are 2 types of users/roles:
1.    Patient
2.    Doctor
The Patient has medical records and prescriptions.
Patient can view only their medical records and prescriptions. 
Doctors can view only the prescriptions they have created. 
Create the web services which can store and retrieve the prescriptions for the above use case.

Assumptions:
1. Prescriptions are in map format with medicine names corresponding to their dose quantity.For example:
{
	"Paracetamol":2,
	"Crocin":1
}
	

Framework:
This webapp uses Spring MVC and Jackson. For persisting data, we are using hashMaps, though we have Dao
classes which can be extended to add data persistance in DB as well. In that case, these HashMaps can be
used as cache.

APIs:
createUser: 
URL: host:port/PharmEasy/assignment/createUser?id={id}&name={name}&role={role}
Parameters: id: integer id
			name: string
			role: string, either Doctor or Patient in any case.
Response: User json

createPrescription:
URL: host:port/PharmEasy/assignment/createPrescription?id={id}&docId={DocId}&patientId={patientId}&
				jsonMedicineMap={medicineMap}
Parameters: id: integer
			docId: integer, id of Doctor writing prescription
			patientId: integer, id of Patient 
			jsonMedicineMap: json string
Response: Prescription json

getPrescription:
URL: host:port/PharmEasy/assignment/getPrescriptions?userId={userId}
Parameters: userId: Integer id of user(Doctor/Patient)
Response: List of Prescriptions in json