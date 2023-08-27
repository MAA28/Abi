class Main {
	public static void main(String[] args) {
			Patient patient1 = new Patient("Malte", 17, "1312");
			Patient patient2 = new Patient("Lütian", 17, "1234");
			Patient patient3 = new Patient("Jannes1", 18, "1776");
			Patient patient4 = new Patient("Jannes2", 18, "4321");
			Patient patient5 = new Patient("Jannes3", 18, "5869");
			Patient patient6 = new Patient("Jannes4", 18, "0000");

			patient1.set_next_patient(patient2);
			patient1.set_next_patient(patient3);
			patient1.set_next_patient(patient4);
			patient1.set_next_patient(patient5);
			patient1.set_next_patient(patient6);
			
			Patient patient = patient1;
			System.out.println("Nächster Patient: " + patient.get_name() + " (Alter: " + patient.get_age() + " Versicherungsnummer: " + patient.get_social_security_number() + ")");
			patient = patient.get_next_patient();
			System.out.println("Nächster Patient: " + patient.get_name() + " (Alter: " + patient.get_age() + " Versicherungsnummer: " + patient.get_social_security_number() + ")");
			patient = patient.get_next_patient();
			System.out.println("Nächster Patient: " + patient.get_name() + " (Alter: " + patient.get_age() + " Versicherungsnummer: " + patient.get_social_security_number() + ")");
			
			String social_security_number = "4321";
			Patient social_security_number_test = patient1.find_patient_by_social_security_number(social_security_number);
			System.out.println("Patient mit der Sozialversicherungsnummer " + social_security_number + ": " + social_security_number_test.get_name() + " (Alter: " + social_security_number_test.get_age() + " Versicherungsnummer: " + social_security_number_test.get_social_security_number() + ")");


	}		
}

class Patient {
	private String name;
	private int age;
	private String social_security_number;

	private Patient next_patient = null;

	Patient(String name, int age, String social_security_number) {
		this.name = name;
		this.age = age;
		this.social_security_number = social_security_number;
	}

	public String get_name() {
		return name;
	}

	public int get_age() {
		return age;
	}

	public String get_social_security_number() {
		return social_security_number;
	}

	public Patient get_next_patient() {
		return next_patient;
	}

	public void set_next_patient(Patient next_patient) {
		if(this.next_patient == null)
			this.next_patient = next_patient;
		else
			this.next_patient.set_next_patient(next_patient); 
	}

	public Patient find_patient_by_social_security_number(String social_security_number) {
		if (this.social_security_number == social_security_number) 
			return this;
		else if (this.next_patient != null) 
			return this.next_patient.find_patient_by_social_security_number(social_security_number);
		else 
			return null;
	}
}