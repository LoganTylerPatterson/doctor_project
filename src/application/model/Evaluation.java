package application.model;

public class Evaluation {
	private String bloodPressure;
	private String pulse;
	private String respirationRate;
	private String temperature;
	private String eyesNotes;
	private String earsNotes;
	private String heartNotes;
	private String reflexesNotes;
	private boolean reflexesAbnormal;

	public Evaluation(String bloodPressure, String pulse, String respirationRate, String temperature,
					  String eyesNotes, String earsNotes, String heartNotes, String noseNotes, String reflexesNotes, String throatNotes,
					  String breathingNotes, boolean eyesAbnormal, boolean earsAbnormal, boolean heartAbnormal,
					  boolean noseAbnormal, boolean throatAbnormal, boolean breathingAbnormal, boolean reflexesAbnormal) {
		this.bloodPressure = bloodPressure;
		this.pulse = pulse;
		this.respirationRate = respirationRate;
		this.temperature = temperature;
		this.eyesNotes = eyesNotes;
		this.earsNotes = earsNotes;
		this.heartNotes = heartNotes;
		this.noseNotes = noseNotes;
		this.throatNotes = throatNotes;
		this.breathingNotes = breathingNotes;
		this.eyesAbnormal = eyesAbnormal;
		this.earsAbnormal = earsAbnormal;
		this.heartAbnormal = heartAbnormal;
		this.noseAbnormal = noseAbnormal;
		this.throatAbnormal = throatAbnormal;
		this.breathingAbnormal = breathingAbnormal;
		this.reflexesNotes = reflexesNotes;
		this.reflexesAbnormal = reflexesAbnormal;
	}

	private String noseNotes;
	private String throatNotes;
	private String breathingNotes;
	private boolean eyesAbnormal;
	private boolean earsAbnormal;
	private boolean heartAbnormal;
	private boolean noseAbnormal;
	private boolean throatAbnormal;
	private boolean breathingAbnormal;
	
	public Evaluation() {
		this.bloodPressure = "";
		this.pulse = "";
		this.respirationRate = "";
		this.temperature = "";
		this.eyesNotes = "";
		this.earsNotes = "";
		this.heartNotes = "";
		this.noseNotes = "";
		this.throatNotes = "";
		this.breathingNotes = "";
		this.eyesAbnormal = false;
		this.earsAbnormal = false;
		this.heartAbnormal = false;
		this.noseAbnormal = false;
		this.throatAbnormal = false;
		this.breathingAbnormal = false;
		this.reflexesAbnormal = false;
	}
	
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
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getEyesNotes() {
		return eyesNotes;
	}

	public void setEyesNotes(String eyesNotes) {
		this.eyesNotes = eyesNotes;
	}

	public String getEarsNotes() {
		return earsNotes;
	}

	public void setEarsNotes(String earsNotes) {
		this.earsNotes = earsNotes;
	}

	public String getHeartNotes() {
		return heartNotes;
	}

	public void setHeartNotes(String heartNotes) {
		this.heartNotes = heartNotes;
	}

	public String getNoseNotes() {
		return noseNotes;
	}

	public void setNoseNotes(String noseNotes) {
		this.noseNotes = noseNotes;
	}

	public String getThroatNotes() {
		return throatNotes;
	}

	public void setThroatNotes(String throatNotes) {
		this.throatNotes = throatNotes;
	}

	public String getBreathingNotes() {
		return breathingNotes;
	}

	public void setReflexesNotes(String reflexesNotes) {
		this.reflexesNotes = reflexesNotes;
	}

	public String getReflexesNotes() {
		return reflexesNotes;
	}

	public void setBreathingNotes(String breathingNotes) {
		this.breathingNotes = breathingNotes;
	}

	public boolean isEyesAbnormal() {
		return eyesAbnormal;
	}

	public void setEyesAbnormal(boolean eyesAbnormal) {
		this.eyesAbnormal = eyesAbnormal;
	}

	public boolean isEarsAbnormal() {
		return earsAbnormal;
	}

	public void setEarsAbnormal(boolean earsAbnormal) {
		this.earsAbnormal = earsAbnormal;
	}

	public boolean isHeartAbnormal() {
		return heartAbnormal;
	}

	public void setHeartAbnormal(boolean heartAbnormal) {
		this.heartAbnormal = heartAbnormal;
	}

	public boolean isNoseAbnormal() {
		return noseAbnormal;
	}

	public void setNoseAbnormal(boolean noseAbnormal) {
		this.noseAbnormal = noseAbnormal;
	}

	public boolean isThroatAbnormal() {
		return throatAbnormal;
	}

	public void setThroatAbnormal(boolean throatAbnormal) {
		this.throatAbnormal = throatAbnormal;
	}

	public boolean isBreathingAbnormal() {
		return breathingAbnormal;
	}

	public void setBreathingAbnormal(boolean breathingAbnormal) {
		this.breathingAbnormal = breathingAbnormal;
	}

	public boolean isReflexesAbnormal() {
		return breathingAbnormal;
	}

	public void setReflexesAbnormal(boolean breathingAbnormal) {
		this.breathingAbnormal = breathingAbnormal;
	}
}
