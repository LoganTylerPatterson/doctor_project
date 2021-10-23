package application.model;

public class Evaluation {
	private String bloodPressure;
	private String pulse;
	private String respirationRate;
	private int temperature;
	
	public Evaluation() {}
	
	public String getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public String getPulse() {
		return pulse;
	}
	public void setPulse(String pulse) {
		this.pulse = pulse;
	}
	public String getRespirationRate() {
		return respirationRate;
	}
	public void setRespirationRate(String respirationRate) {
		this.respirationRate = respirationRate;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	
}
