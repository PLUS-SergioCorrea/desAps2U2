package model;

public class Location {
	
	private String id;
	private int iteration;
	private String creDate;
	private String modDate;
	private String username;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getIteration() {
		return iteration;
	}
	public void setIteration(int iteration) {
		this.iteration = iteration;
	}
	public String getCreDate() {
		return creDate;
	}
	public void setCreDate(String creDate) {
		this.creDate = creDate;
	}
	public String getModDate() {
		return modDate;
	}
	public void setModDate(String modDate) {
		this.modDate = modDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Location(String id, int iteration, String creDate, String modDate, String username) {
		super();
		this.id = id;
		this.iteration = iteration;
		this.creDate = creDate;
		this.modDate = modDate;
		this.username = username;
	}
	public Location() {
		this("",0,"","","");
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Location [id=" + id + ", iteration=" + iteration + ", creDate=" + creDate + ", modDate=" + modDate
				+ ", username=" + username + "]";
	}
	
	
	

}
