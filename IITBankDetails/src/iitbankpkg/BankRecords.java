package iitbankpkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

/**
 * 
 * Class Bank Records implements the interface Clients. 1.This class reads the
 * data from a bank-Detail_withHeaders.csv file, 2.the data is manipulated using
 * the getters/setters. 3.The console output shows first 25 records for various
 * fields to the console via your getters. Records for the following fields: ID,
 * AGE, SEX, REGION, INCOME, and MORTGAGE.Include headings in the print detail.
 */
public class BankRecords implements Client {

	/**
	 * Instance fields used in the Bank record generation
	 */
	public String ID, SEX, REGION, MARRIED, CAR, SAVE_ACT, CURRENT_ACT, MORTGAGE, PEP;
	public int CHILDREN, AGE;
	public double INCOME;
	/**
	 * created objects for processing & handling data
	 */
	static List<List<String>> IITbankdetails = new ArrayList<>();
	static BankRecords bkrecords[] = new BankRecords[600];
	

	/**
	 * Constructors
	 */
	public BankRecords() {

	}

	public BankRecords(String iD, int aGE, String sEX, String rEGION, double iNCOME, String mORTGAGE) {
		super();
		ID = iD;
		AGE = aGE;
		SEX = sEX;
		REGION = rEGION;
		INCOME = iNCOME;
		MORTGAGE = mORTGAGE;

	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getSEX() {
		return SEX;
	}

	public void setSEX(String sEX) {
		SEX = sEX;
	}

	public String getREGION() {
		return REGION;
	}

	public void setREGION(String rEGION) {
		REGION = rEGION;
	}

	public String getMARRIED() {
		return MARRIED;
	}

	public void setMARRIED(String mARRIED) {
		MARRIED = mARRIED;
	}

	public String getCAR() {
		return CAR;
	}

	public void setCAR(String cAR) {
		CAR = cAR;
	}

	public String getSAVE_ACT() {
		return SAVE_ACT;
	}

	public void setSAVE_ACT(String sAVE_ACT) {
		SAVE_ACT = sAVE_ACT;
	}

	public String getCURRENT_ACT() {
		return CURRENT_ACT;
	}

	public void setCURRENT_ACT(String cURRENT_ACT) {
		CURRENT_ACT = cURRENT_ACT;
	}

	public String getMORTGAGE() {
		return MORTGAGE;
	}

	public void setMORTGAGE(String mORTGAGE) {
		MORTGAGE = mORTGAGE;
	}

	public String getPEP() {
		return PEP;
	}

	public void setPEP(String pEP) {
		PEP = pEP;
	}

	public int getAGE() {
		return AGE;
	}

	public void setAGE(int aGE) {
		AGE = aGE;
	}

	public int getCHILDREN() {
		return CHILDREN;
	}

	public void setCHILDREN(int cHILDREN) {
		CHILDREN = cHILDREN;
	}

	public double getINCOME() {
		return INCOME;
	}

	public void setINCOME(double iNCOME) {
		INCOME = iNCOME;
	}

	@SuppressWarnings("resource")
	/**
	 * Method name: readData() This method reads data from the csv file and adds
	 * the content to a array list IITbankdetails.
	 */
	public static void readData() {
		String line = "";
		String splitter = ",";

		try {
			BufferedReader stream = new BufferedReader(new FileReader("Docs/bank-Detail.csv"));

			while ((line = stream.readLine()) != null) {
				IITbankdetails.add(Arrays.asList(line.split(splitter)));

			}

		} catch (IOException e) {

			System.out.println("File not found!\n"+e.getMessage());
			return;
			//System.out.println("File not found");
		}
		processData();

	}

	/**
	 * Method name: processData() 1.This method loops through every row in the
	 * array list IITbankdetails. 2.Setters assign the value to the required
	 * instance fields which are then stored in array of objects of class
	 * BankRecords.
	 */
	public static void processData() {
		int counter = 0;
		for (List<String> rowdata : IITbankdetails) {
			bkrecords[counter] = new BankRecords();
			bkrecords[counter].setID(rowdata.get(0));
			bkrecords[counter].setAGE(Integer.parseInt(rowdata.get(1)));
			bkrecords[counter].setSEX(rowdata.get(2));
			bkrecords[counter].setREGION(rowdata.get(3));
			bkrecords[counter].setINCOME(Double.parseDouble(rowdata.get(4)));
			bkrecords[counter].setMORTGAGE(rowdata.get(5));
			counter++;
		}

		//printData();

	}

	/**
	 * Method name: printData() 1.This method loops till required records count
	 * 2.Getters get the value to the required instance fields from the object,
	 * the result is displayed with headers on the console.
	 */
	public static void printData() {
		int pcounter;
		int recordGenerationlimit = 25;
		System.out.println("\n");
		System.out.println(
				"                     IIT Bank Top " + recordGenerationlimit + " Records for Loan Consideration   ");
		System.out.println("\n");
		System.out.println(
				".............................................................................................");
		System.out.println(
				" ID             AGE              SEX             REGION               INCOME         MORTGAGE");
		System.out.println(
				".............................................................................................");
		for (pcounter = 0; pcounter < recordGenerationlimit; pcounter++) {
			System.out.println(bkrecords[pcounter].getID() + "\t\t" + bkrecords[pcounter].getAGE() + "\t\t"
					+ bkrecords[pcounter].getSEX() + "\t\t" + bkrecords[pcounter].getREGION() + "    \t\t"
					+ bkrecords[pcounter].getINCOME() + "\t\t" + bkrecords[pcounter].getMORTGAGE());

		}
		System.out.println(
				".............................................................................................");

	}
//
//	/**
//	 * Method name: main() 1.The main method calls the method readData() 2.Name
//	 * and timestamp
//	 * 
//	 * @param args main takes no argument value
//	 * 
//	 */

//	public static void main(String[] args) {
//		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
//		System.out.println("Cur dt=" + timeStamp + "\nProgrammed by Sunakshi Zutshi\n");
//		readData();
//
//	}
}
