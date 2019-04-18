class Engineer extends Employee {
	String workZone;
	String project;
	
	Engineer(String name, int employeeNum, String workZone, String project) {
		super(name, employeeNum);
		this.department = "Engineering";
		
		this.workZone = workZone;
		this.project = project;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Engineer) {
			Engineer engineer = (Engineer)obj;
			if (
				super.equals(engineer) &&
				this.workZone.equals(engineer.workZone) &&
				this.project.equals(engineer.project)
			) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format(
			"%s\n" +
			"Location: %s, Zone: %s",
			super.toString(), this.department, this.workZone
		);
	}
}