package com.proj.demo;

class StringService{

	boolean isUpper(char x){
		int ascii = (int)x;
		if(ascii >= 65 && ascii <= 90)
			return true;
		return false;
	}

	boolean isLower(char x){
		int ascii = (int)x;
		if(ascii >= 97 && ascii <= 122)
			return true;
		return false;
	}

	//this function assumes str has no numbers or special characters.
	public String caseFlip(String str, boolean toLower){
		char x;
		String nstr = "";
		for(int i = 0; i < str.length(); i++){
			x = str.charAt(i);
			if(toLower){
				if(isUpper(x)){
					x = (char)((int)x + 32);
				}
			} else if(isLower(x)){
				x = (char)((int)x - 32);
			}
		
			nstr += x;
		}
		return nstr;
	}

	int getAlphaIndex(char x){
		if(isUpper(x)){
			return (int)x - 64;
		} else {
			return (int)x - 96;
		}
	}

	char getcharFromIndex(char x, int index){
		if(isUpper(x)){
			return (char)(index + 64);
		} else
			return (char)(index + 96);
	}

	//this function assumes str has no numbers or special characters because the wraparound was not specified for other cases
	public String encoder(String str, int shift){
		char x;
		String nstr = "";
		int index = 0;
		for(int i = 0; i < str.length(); i++){
			x = str.charAt(i);
			index = getAlphaIndex(x);
			index = index + shift +26;
			index = index % 26;
			x = getcharFromIndex(x, index);
			nstr += x;
		}
		return nstr;
	}

	boolean searchMark(String line, String mark){
		int i = 0;
		while(i < line.length()){
			if(line.charAt(i) == mark.charAt(0)){
				for(int j = 1; j < mark.length(); j++){
					i++;
					if(line.charAt(i) == mark.charAt(j)){
						if(j == mark.length() - 1)
							return true;
						continue;
					}
					break;
				}
			} else i++;
		}
		return false;
	}

	//builds each line by using \n as delimiter, the serches that line for the mark. If mark is not present, adds it to the final output.
	public String blackListLines(String str, String mark){
		char x = '\n', y='a';
		String nstr="", line = "";
		int i = -1;
		boolean flag = false;
		while(i < str.length()){
			if(x == '\n'){
				while(i + 1< str.length() && str.charAt(i + 1) != '\n'){
					i++;
					y = str.charAt(i);
					line += y;
					flag = true;
				}
				if(!searchMark(line, mark))
					nstr += line + "\n";
				line = "";
			}
			if(!flag){
				i++;
			}
			if(i < str.length())
				x = str.charAt(i);
			flag = false;
		}
		//doing this to avoid using String.substring
		if(nstr.length() > 0){
			if(nstr.charAt(nstr.length() - 1) == '\n'){
				line = "";
				for(i = 0; i < nstr.length() - 1; i++)
					line += nstr.charAt(i);
			}
		}
		return line;
	}

	boolean isRange(char x){
		int index = (int)x;
		if(index >=32 && index <= 126)
			return true;
		return false;
	}

	public String char2Ascii(String str){
		char x;
		String nstr = "", line = "";
		for(int i = 0; i < str.length(); i++){
			x = str.charAt(i);
			if(isRange(x)){
				if(i < str.length() - 1)
					nstr = nstr + (int)x + " ";
				else
					nstr = nstr + (int)x;
			}
		}
		//this fixes the possible addition of an extra white space to the final output if the last character does not belong to the ascii range accepted.
		if(nstr.length() > 0){
			if(nstr.charAt(nstr.length() - 1) == ' '){
				line = "";
				for(int i = 0; i < nstr.length() - 1; i++)
					line += nstr.charAt(i);
			}
		}
		return nstr;
	}

	//breaks the multiline string into lines, adds lines to a buffer while adding prefix to the beginning of the line.
	public String addPrefix(String str, String prefix){
		char x = '\n', y='a';
		String nstr = "", line = prefix;
		int i = -1;
		boolean flag = false;
		while(i < str.length()){
			if(x == '\n'){
				while(i + 1< str.length() && str.charAt(i + 1) != '\n'){
					i++;
					y = str.charAt(i);
					line += y;
					flag = true;
				}
				nstr += line + "\n";
				line = prefix;
			}
			if(!flag){
				i++;
			}
			if(i < str.length())
				x = str.charAt(i);
			flag = false;
		}
		//doing this to avoid using String.substring
		if(nstr.charAt(nstr.length() - 1) == '\n'){
			line = "";
			for(i = 0; i < nstr.length() - 1; i++)
				line += nstr.charAt(i);
		}
		return line;
	}

}