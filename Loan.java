package Names.csv;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File myFile = new File("C:\\Users\\JoyXi\\Downloads\\names.csv");
			Scanner myReader = new Scanner(myFile);
			String row;
			//String row2;
			int containZ = 0;
			int startX = 0;
			String sex = "";
			String name = "";
			int year = 0;
			int y1920 = 0;
			int John = 0;
			int count = 0;
			int largestCount = 0;
			String mostPopularName = "";
			int allNameLength = 0;
			int allRows = 0;
			int hasA = 0;
			int hasE = 0;
			int hasI = 0;
			int hasO = 0;
			int hasU = 0;
			int hasY = 0;
			int earliest = 1999;
			int latest = 1950;
			int prevCount = 0;
			int prevYear = 1880;
			int F =0;
			int M = 0;
			int totalYearCount = 0;
			String prevName = "";
			myReader.nextLine();
			
			while (myReader.hasNextLine()) {
				row = myReader.nextLine();
				name = row.substring(0,row.indexOf(","));
				row = row.substring(row.indexOf(",")+1);
				sex = row.substring(0,row.indexOf(","));
				row = row.substring(row.indexOf(",")+1);
				count = Integer.parseInt(row.substring(0,row.indexOf(",")));
				row = row.substring(row.indexOf(",")+1);
				year = Integer.parseInt(row);
				
				if (name.substring(0,1).equals("X")) {
					startX += count;
				}
				if (name.contains("Z")||name.contains("z")) {
					containZ += count;
				}
				if (year == 2000 && sex.equals("F")) {
					if (count > largestCount) {
						largestCount = count;
						mostPopularName = name;
					}
				}
				if (sex.equals("M") && name.equals("John")) {
					John += count;
				}
				if (year == 1920) {
					y1920 += count;
				}
				if (name.contains("A") || name.contains("a")) {
					hasA ++; 
				}
				if (name.contains("E") || name.contains("e")) {
					hasE ++; 
				}
				if (name.contains("I") || name.contains("i")) {
					hasI ++; 
				}
				if (name.contains("O") || name.contains("o")) {
					hasO ++; 
				}
				if (name.contains("U") || name.contains("u")) {
					hasU ++; 
				}
				if (name.contains("Y") || name.contains("y")) {
					hasY ++; 
				}
				allNameLength += name.length();
				allRows ++;
				
				if (earliest > year) {
					earliest = year;
				}
				if (year > latest) {
					latest = year;
				}
				
			}
			System.out.println("Most Popular Names by Year:");

			for (int yr = 1820; yr <= 2021; yr++) {
			    int highestCount = 0;
			     mostPopularName = "";

			    // Reopen the file to find the most popular name for the current year
			    Scanner yearReader = new Scanner(new File("C:\\Users\\JoyXi\\Downloads\\names.csv"));
			    yearReader.nextLine(); // Skip header

			    while (yearReader.hasNextLine()) {
			        row = yearReader.nextLine();
			        name = row.substring(0, row.indexOf(","));
			        row = row.substring(row.indexOf(",") + 1);
			        sex = row.substring(0,row.indexOf(","));
					row = row.substring(row.indexOf(",")+1);
			        count = Integer.parseInt(row.substring(0, row.indexOf(",")));
			        year = Integer.parseInt(row.substring(row.indexOf(",") + 1));

			        if (year == yr) {
			            if (count > highestCount) {
			                highestCount = count;
			                mostPopularName = name;
			            }
			            if (sex.equals("F")) {
			            	F++;
			            }
			            if (sex.equals("M")){
			            	M++;
			            }
			            totalYearCount += count;
			        }
			    }

			    if (!mostPopularName.isEmpty()) {
			        System.out.println(yr + ": " + mostPopularName);
			        System.out.println("M: " + M + " F: " + F);
			        System.out.println("Total people born in " + yr + ": " + totalYearCount);
			    }

			    yearReader.close(); 
			}

			myReader.close();
			
			
			System.out.println("Start x: " + startX);
			System.out.println("Contain z: " + containZ);
			System.out.println("Most Popular Name: " + mostPopularName + " " + largestCount);
			System.out.println("Johns: " + John);
			System.out.println("Year 1920: " + y1920);
			System.out.println("Average name length: " + allNameLength/allRows);
			if (hasA > hasO && hasA > hasE && hasA > hasI && hasA > hasU && hasA > hasY) {
				System.out.println("Most common vowel: A");
			}
			else if (hasO > hasA && hasO > hasE && hasO > hasI && hasO > hasU && hasO > hasY) {
				System.out.println("Most common vowel: O");
			}
			else if (hasE > hasA && hasE > hasO && hasE > hasI && hasE > hasU && hasE > hasY) {
				System.out.println("Most common vowel: E");
			}
			else if (hasI > hasA && hasI > hasE && hasI > hasO && hasI > hasU && hasI > hasY) {
				System.out.println("Most common vowel: I");
			}
			else if (hasU > hasA && hasU > hasE && hasU > hasI && hasU > hasO && hasU > hasY) {
				System.out.println("Most common vowel: U");
			}
			else if (hasY > hasA && hasY > hasE && hasY > hasI && hasY > hasU && hasY > hasO) {
				System.out.println("Most common vowel: O");
			}
			else {
				System.out.println("error");
			}	
			System.out.println("Earliest year " + earliest);
			System.out.println("Latest year " + latest);
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
