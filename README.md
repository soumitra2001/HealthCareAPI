

<h1 align="center"> 🧑‍⚕️😷 HealthCareAPI 👨‍⚕️👩‍⚕️</h1>

Welcome to the HealthCareAPI project, a backend API system built using the Spring Boot framework and Hibernate for managing doctor and patient data. This API enables doctors to register patients and provides functionality for suggesting doctors based on a patient's symptoms and location.


## Table of Contents

* Project Description
* Entities
* API Endpoints
* Suggesting Doctors
* Usage
* Contribution

## Project Description
The HealthCareAPI is a backend system designed to support doctors and patients by providing essential functionalities through APIs. These functionalities include adding doctors and patients to the platform, registering patient symptoms, and suggesting doctors based on the patient's symptoms and location.

## Entities
### Doctor's Entity
In the database, the doctor's entity includes the following fields:

* Name (at least 3 characters)
* City (max 20 characters, limited to Delhi, Noida, Faridabad)
* Email (a valid email address)
* Phone number (at least 10 digits)
* Speciality (Orthopedic, Gynecology, Dermatology, ENT specialist)

### Patient's Entity
In the database, the patient's entity includes the following fields:

* Name (at least 3 characters)
* City (max 20 characters, any value)
* Email (a valid email address)
* Phone number (at least 10 digits)
* Symptom (Arthritis, Back Pain, Tissue injuries, Dysmenorrhea, Skin infection, skin burn, Ear pain)

## API Endpoints
The HealthCareAPI provides the following API endpoints:

* `POST /api/doctors`: Add a doctor to the platform.
* `DELETE /api/doctors/{doctorId}`: Remove a doctor from the platform.
* `POST /api/patients`: Add a patient and their symptom to the platform.
* `DELETE /api/patients/{patientId}`: Remove a patient from the platform.
* `POST /api/suggest-doctor/{patientId}`: Suggest doctors based on the patient's symptom and location.

## Suggesting Doctors
The `POST /api/suggest-doctor/{patientId}` API suggests doctors based on the patient's symptom and location. It ensures that the suggested doctor's speciality matches the patient's symptom. Edge cases are handled as follows:

* If there are no doctors in the patient's location (outside Delhi, Noida, Faridabad), the response is "We are still waiting to expand to your location."
* If there are no doctors for the patient's symptom in the patient's location, the response is "There isn't any doctor present at your location for your symptom."

## Usage
To deploy and use the HealthCareAPI, follow these steps:

1) Clone this repository to your local machine.
```bash
  git clone https://github.com/soumitra2001/HealthCareAPI.git

```
2) onfigure the application's database connection in the application.properties file.

3) Build and run the application using Spring Boot.

4) Access the API endpoints using a tool like Postman or integrate them into your mobile or web portal.

6) Enjoy using the HealthCareAPI!

## Contribution
Contributions to this project are welcome! If you have suggestions, bug reports, or would like to add new features, please open an issue or submit a pull request. We appreciate your input and collaboration.

## 

Thank you for exploring the HealthCareAPI project! If you have any questions or feedback, please feel free to reach out. This API system is designed to facilitate the management of doctor and patient data effectively and efficiently.

