package application;

import application.model.*;


import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * @author Logan Patterson
 * @date 09/29/2021
 * @purpose helper class to abstract away the details of writing to and from the filesystem
 * this is how we handle file management and get rid of the need for a relational db
 *
 */
public class JsonUtil {
	
	private String userUrl;
	public String baseUrl;
	private String ext;
	private Gson gson;
	private Gson gsonPretty;
	
	public JsonUtil() {
		ext = ".json";
		userUrl = System.getProperty("user.dir") + "/src/application/userData/";
		baseUrl = System.getProperty("user.dir") + "/src/application/";
		gson = new Gson();
		gsonPretty = new GsonBuilder().setPrettyPrinting().create();
	}
	
	public Doctor getDoctorObjFromJson(String filename) {
		try {
			Reader reader = new FileReader(userUrl + filename + ext);
			Doctor doctor = gson.fromJson(reader, Doctor.class);
			reader.close();
			return doctor;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Problem reading Doctor " + filename + ext + ", returning empty doctor");
			return new Doctor();
		}
	}
	
	public boolean writeDoctorObjToJson(Doctor doc, String filename) {
		try {
			String url = userUrl + filename + ext;
			FileWriter writer = new FileWriter(url);
			gsonPretty.toJson(doc, writer);
			writer.flush();
			writer.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Nurse getNurseObjFromJson(String filename) {
		try {
			Reader reader = new FileReader(userUrl + filename + ext);
			Nurse nurse = gson.fromJson(reader, Nurse.class);
			reader.close();
			return nurse;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Problem reading Nurse data " + filename + ", returning empty Nurse");
			return new Nurse();
		}
	}
	
	public boolean writeNurseObjToJson(Nurse nurse, String filename) {
		try {
			String url = userUrl + filename + ext;
			FileWriter writer = new FileWriter(url);
			gsonPretty.toJson(nurse, writer);
			writer.flush();
			writer.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 
	 * @param filename desired name of the desired output file
	 * @return a Patient object with relevant fields filled
	 */
	public Patient getPatientObjFromJson(String filename) {
		try {
			Reader reader = new FileReader(userUrl + filename + ext);
			Patient patient = gson.fromJson(reader, Patient.class);
			reader.close();
			return patient;
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Issue reading patient data, returning empty patient");
			return new Patient();
		}
	}
	
	
	/**
	 * 
	 * @param patient Patient object with all CORRECT data
	 * @param filename desired name of the desired output file
	 * @return a boolean value as to whether the file was written
	 */
	public boolean writePatientToJsonFile(Patient patient, String filename) {
		try {
			String url = userUrl + filename + ext;
			FileWriter writer = new FileWriter(url);
			gsonPretty.toJson(patient, writer);
			writer.flush();
			writer.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean writeUserRegistryToFile(UserRegistry reg){
		try {
			String url = baseUrl + "user_registry.json";
			FileWriter writer = new FileWriter(url);
			gsonPretty.toJson(reg, writer);
			writer.flush();
			writer.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}


	public UserRegistry getUserRegistry(){
		//Comment for github
		try {
			String url = baseUrl + "user_registry.json";
			Reader reader = new FileReader(url);
			UserRegistry reg = gson.fromJson(reader, UserRegistry.class);
			reader.close();
			return reg;
		} catch (Exception e){
			System.out.println("getUserRegistry(): could not retrieve registry");
			e.printStackTrace();
			return new UserRegistry();
		}
	}
}