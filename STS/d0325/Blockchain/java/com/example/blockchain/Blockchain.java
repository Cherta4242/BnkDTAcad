package com.example.blockchain;

import lombok.Data;

@Data
public class Blockchain {

	public static String blcPassword(String password) {
		String pwd = "";
		
		for(int i=0; i < password.length(); i++) {
			switch(password.charAt(i)) {
				case 'a':
				case 'h':
				case 'i':
				case 'n':
					pwd += password.charAt(i) + "!ar";
					break;
				case 'b':
				case 'm':
				case 'j':
				case 'v':
					pwd += password.charAt(i) + "/en";
					break;
				case 'c':
				case 'l':
				case 'k':
				case 'r':
					pwd += password.charAt(i) + "!lu";
					break;
				case 'd':
				case 's':
				case 'q':
				case 'u':
					pwd += password.charAt(i) + "/1n2";
					break;
				case 'e':
				case 'o':
				case 'p':
				case 't':
					pwd += password.charAt(i) + "!cj";
					break;
				case 'f':
				case 'x':
				case 'w':
					pwd += password.charAt(i) + "/of";
					break;
				case 'g':
				case 'y':
				case 'z':
					pwd += password.charAt(i) + "!311";
					break;
				case '1':
				case '2':
					pwd += password.charAt(i) + "/u6";
					break;
				case '3':
				case '9':
					pwd += password.charAt(i) + "!12";
					break;
				case '8':
				case '6':
				case '4':
					pwd += password.charAt(i) + "/82";
					break;
				case '5':
					pwd += password.charAt(i) + "!00";
					break;
				case '7':
					pwd += password.charAt(i) + "/skdi";
					break;
				default:
					pwd += password.charAt(i) + "?";
			}
			
		}
		
		
		return pwd;
	}
}
