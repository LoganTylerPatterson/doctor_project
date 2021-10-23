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
	
	private String patientUrl;
	private String baseUrl;
	private Gson gson;
	private Gson gsonPretty;
	
	public JsonUtil() {
		patientUrl = System.getProperty("user.dir") + "src/application/patientdata/";
		baseUrl = System.getProperty("user.dir") + "/src/application/";
		gson = new Gson();
		gsonPretty = new GsonBuilder().setPrettyPrinting().create();
	}
	
	/**
	 * 
	 * @param filename desired name of the desired output file
	 * @return a Patient object with relevant fields filled
	 */
	public Patient getPatientObjFromJson(String filename) {
		try {
			Reader reader = new FileReader(patientUrl + filename);
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
			String url = patientUrl + filename + ".json";
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

	/**
	 *
	 */
	public ArrayList<String> getDoctorNames(){
		ArrayList<String> doctors = new ArrayList<>();
		JsonObject obj;
		try {
			String url = baseUrl + "user_registry.json";
			Reader reader = new FileReader(url);
			obj = gson.fromJson(reader, JsonObject.class);
			reader.close();
			String arr = obj.get("doctors").toString();
			Type type = new TypeToken<ArrayList<String>>(){}.getType();
			doctors = gson.fromJson(arr, type);
		} catch (FileNotFoundException e) {
			System.out.println("Could not get doctor names");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Issue Reading userRegistry file for doctors");
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return doctors;
	}

	public ArrayList<String> getNurseNames(){
		ArrayList<String> names = new ArrayList<>();
		JsonObject obj;
		try {
			String url = baseUrl + "user_registry.json";
			Reader reader = new FileReader(url);
			obj = gson.fromJson(reader, JsonObject.class);
			reader.close();
			String arr = obj.get("nurses").toString();
			Type type = new TypeToken<ArrayList<String>>(){}.getType();
			names = gson.fromJson(arr, type);
		} catch (FileNotFoundException e) {
			System.out.println("Could not get doctor names");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Issue Reading userRegistry file for doctors");
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return names;
	}

	public ArrayList<String> getPatientNames(){
		ArrayList<String> names = new ArrayList<>();
		JsonObject obj;
		try {
			String url = baseUrl + "user_registry.json";
			Reader reader = new FileReader(url);
			obj = gson.fromJson(reader, JsonObject.class);
			reader.close();
			String arr = obj.get("patients").toString();
			Type type = new TypeToken<ArrayList<String>>(){}.getType();
			names = gson.fromJson(arr, type);
		} catch (FileNotFoundException e) {
			System.out.println("Could not get doctor names");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Issue Reading userRegistry file for doctors");
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return names;
	}
	
}