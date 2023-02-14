class Excel{
	Worksheet worksheet[];

	Excel(int num){
		this.worksheet = new Worksheet[num];
	}

	Worksheet setWorksheet(int index, Worksheet w){
		this.worksheet[index] = w;
		return this.worksheet[index];
	}

	Worksheet createWorksheet(int rows, int cols){
		return new Worksheet(rows,cols);
	}

	public static void main(String args[]){
		Excel sheet = new Excel(1);
		Worksheet myWorksheet = sheet.setWorksheet(0,sheet.createWorksheet(2,2));
		Computer stringComputer = new Computer(new StringComputer());
		Computer numComputer = new Computer(new NumericComputer());
		myWorksheet.setCell(0,0,"string 1",stringComputer);
		myWorksheet.setCell(0,1,"num 1",numComputer);
		myWorksheet.setCell(1,0,"string 2",stringComputer);
		myWorksheet.setCell(1,1,"num 2",numComputer);

		System.out.println("Original functionality: ");
		myWorksheet.display();
		myWorksheet.swapFunc(stringComputer, numComputer);
		System.out.println("Swapped functionality: ");
		myWorksheet.display();
	}
}