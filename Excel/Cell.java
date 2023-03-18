class Cell{
	String value;
	Computer computer;

	Cell(String value, Computer computer){
		this.value = value;
		this.computer = computer;
	}

	String getValue(){
		return this.value;
	}

	void setComputer(Computer comp){
		this.computer = comp;
	}

	void compute(){
		value = computer.compute(value);
	}
}