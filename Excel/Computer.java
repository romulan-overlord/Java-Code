class Computer{
	Computable computer;

	Computer(Computable computer){
		this.computer = computer;
	}

	String compute(String value){
		return computer.compute(value);
	}
}