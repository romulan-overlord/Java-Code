class Worksheet{
	int rows = 0, cols = 0;
	Cell cell_arr[][];

	Worksheet(int rows, int cols){
		this.cell_arr = new Cell[rows][cols];
		this.rows = rows;
		this.cols = cols;
	}

	void setCell(int row, int col, String value, Computer computer){
		this.cell_arr[row][col] = new Cell(value, computer);
	}

	void display(){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				System.out.print("Cell " + i + ", " + j + ": ");
				cell_arr[i][j].compute();
			}
			System.out.println();
		}
	}

	void swapFunc(Computer strComp, Computer numComp){
		cell_arr[0][0].setComputer(numComp);
		cell_arr[0][1].setComputer(strComp);
	}
}