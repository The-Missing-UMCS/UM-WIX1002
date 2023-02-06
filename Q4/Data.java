package PastYear2020.Q4;

public class Data {
	private String queue;
	private String start;
	private String exitTime;
	private String exitStatus;
	
	public void setQueue(String queue) {
		this.queue = queue;
	}
	
	public void setStart(String start) {
		this.start = start;
	}
	
	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}
	
	public void setExitStatus(String exitStatus) {
		this.exitStatus = exitStatus;
	}
	
	public String getQueue() {
		return String.format("Y (%s)", this.queue);
	}
	
	public String getStart() {
		return String.format("Y (%s)", this.start);
	}
	
	public String getExit() {
		if(exitStatus == null) {
			return exitStatus;
		}
		
		if (!exitStatus.equals("1")) 
			return "Error: Exit Status " + exitStatus;
			
		return exitTime;
	}
}
