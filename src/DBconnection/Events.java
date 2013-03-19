package DBconnection;

public class Events {
	private int avtaleID;
	private String avtaleNavn;
	private String avtaleLeder;
	private TimeInterval tid;
	private boolean isActive;
	private String beskrivelse;
	private String sted;
	
	public Events(int avtaleID, String avtaleNavn, String avtaleLeder, TimeInterval tid, boolean isActive, String beskrivelse, String sted){
		this.avtaleID = avtaleID;
		this.avtaleNavn = avtaleNavn;
		this.avtaleLeder = avtaleLeder;
		this.tid = tid;
		this.isActive = isActive;
		this.beskrivelse = beskrivelse;
		this.sted = sted;
	}
	
	public int getAvtaleID(){
		return this.avtaleID;
	}
	public String getAvtaleNavn(){
		return this.avtaleNavn;
	}
	public String getAvtaleLeder(){
		return this.avtaleLeder;
	}
	public TimeInterval getTid(){
		return this.tid;
	}
	public boolean getIsActive(){
		return this.isActive;
	}
	public String getBeskrivelse(){
		return this.beskrivelse;
	}
	public String getSted(){
		return this.sted;
	}
}
