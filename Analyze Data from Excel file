//Darko Stanisic-20074106-CMPE212
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class assign2 {

public static void main(String[] args) {
		readTheFile();
		for(int column=1; column<8; column++) {					//returns 7 separate files for each motor, each column represents a motor
			writeTheFile(column);
		}
	}

static double[][] readTheFile() {								//reads the .csv file and loads data into an array
	double[][] data;											//variable that contains the data from the given .csv file
	data = new double[1000][8];									//data values from the .csv file placed in this global variable 
	Scanner scanIn = null;
	int Row = 0;
	String InputLine = "";
	try {
		scanIn = new Scanner (new BufferedReader(new FileReader ("Logger.csv")));
		while(scanIn.hasNextLine()) {
			InputLine = scanIn.nextLine();
			String[] Inarray = InputLine.split(",");			//split the values in the array by ","
			for(int i=0;i<8;i++) {
				data[Row][i]= Double.parseDouble(Inarray[i]);
			}
			Row++;
		}
	}
	catch (FileNotFoundException e) {							//if file being called cannot be found, let the person know
		System.out.println("No File Found");
	}
	return data;												//return the array of data from the .csv file given
}
	
public static double[] analyzeData(int row, int column) {		//return new string[] that is used for writethefile 
		double[][] data =  readTheFile();						//stores all the data from excel file into array data;									
		double start=0;								
		double finish=0;
		double current=0;
		start =  data[row][0];									//already checked that current>1 in writethefile, so set start to the first instance 
		while (data[row][column] > 1) {							//when current is above 1 amp, means motor is in use
			current += data[row][column];				
			row++;										
		}
		finish =  data[row-1][0];								//subtract 1 because row is increased in while loop so want to access previous row
		current = current / (finish-start+1);					//calculates the average current over the period
		double[] thearray = {start, finish, current};
			return thearray;									//return new string[] that is used in writethefile
	}
	
static void writeTheFile(int column) {							//create the files for each motor and load the files with the information
			String filename= "Motor"+column+".csv";				//different name for each motor file being created
			double[][] data = readTheFile();									
			PrintWriter outputStream = null;
			try{
				outputStream =  new PrintWriter(new FileOutputStream(filename));
			  	}	
			catch (FileNotFoundException e){					//if error creating files return error opening file
				System.out.println("Error opening file");
				System.exit(0);
				}
			System.out.println("Writing to file: Motor" + column);//let person know that it is working successfully 
			outputStream.println("start (sec), finish (sec), current (amps)");
			int counter=0;										//keeps track of number of times each motor being used
			for(int row=1; row<999; row++) {					//time is stored in the rows of the file
				if (data[row][column]>1) {						//if current is above 1 amp, means that motor is being used
					double[] values = new double[3];
					values = analyzeData(row, column);			//re-distribute values from analyzeData into an array of values for easy use
					double start = (int) values[0];				//cast double value to int since it is time in seconds 
					double finish = (int) values[1];			//cast double value to int since it is time in seconds 
					double current = values [2];
					outputStream.print(start + "," + finish + ",");				
					outputStream.format("%.2f", current);
					if(current>8) {								//when current is larger than 8 amps add that current is exceeded
						outputStream.print("," + "***Currrent Exceeded***" + ",");
					}
					outputStream.print("\n");
					row= (int) finish;
					counter++;		
				}	
			}
			if(counter==0) {									//if motor is never used, add that it is not used
				outputStream.print("Not Used.");
			}
		outputStream.close();
		System.out.println("End of program" + "\n");			//let the person reading know that program executed successfully 
	}

}
