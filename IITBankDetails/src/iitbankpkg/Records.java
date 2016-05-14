package iitbankpkg;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class Records extends BankRecords {

	static FileWriter fw = null;

	public Records() {
		try {
			fw = new FileWriter("Docs/Bankrecords.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static <bkrecords> void main(String[] args) throws IOException {

		// String timeStamp = new SimpleDateFormat("yyyy/MM/dd
		// HH:mm:ss").format(Calendar.getInstance().getTime());
		// System.out.println("Cur dt=" + timeStamp + "\nProgrammed by Sunakshi
		// Zutshi\n");
		new Records();
		readData();
		// salary
		// average.....................................................................
		if (bkrecords != null) {
			Comparator<BankRecords> Cbk = new Comparator<BankRecords>() {

				@Override
				public int compare(BankRecords o1, BankRecords o2) {
					return (int) (o1.getINCOME() - o2.getINCOME());
				}

			};
			Arrays.sort(bkrecords, Cbk);

			// 1.average income per location
			readAverageIncome();
		} else
			System.out.println("Error in finding Average income!");

		// Max/Min
		// age........................................................................
		if (bkrecords != null) {
			Comparator<BankRecords> Cbk1 = new Comparator<BankRecords>() {

	@Override
	public int compare(BankRecords o1, BankRecords o2) {

		return (int) (o1.getAGE() - o2.getAGE());
	}

	};Arrays.sort(bkrecords,Cbk1);readMaxMinAge();}else System.out.println("Error in finding Average income comparator!");

	// females
	// info..........................................................................
	if(bkrecords!=null){

	Comparator<BankRecords> Cbk2=new Comparator<BankRecords>(){

	@Override 
	public int compare(BankRecords o1,BankRecords o2)
	{if(o1.getSEX()==o2.getSEX())
		return 0;
	else 
		return 1;
	}

	};
	Arrays.sort(bkrecords,Cbk2);
	readFemaleInfo();
	}
	else System.out.println("Error in finding Average income comparator!");

	// male
	// info..........................................................................
	if(bkrecords!=null){
	Comparator<BankRecords> Cbk3=new Comparator<BankRecords>(){

	@Override public int compare(BankRecords o1,BankRecords o2){if(o1.getSEX()==o2.getSEX())return 0;else return 1;}

	};Arrays.sort(bkrecords,Cbk3);readMaleInfo();}else System.out.println("Error in finding Average income comparator!");

	try{fw.close();}catch(
	Exception e){e.printStackTrace();
	}

	}

	public static void readAverageIncome() {
		double INNER_CITYsum = 0, RURALsum = 0, SUBURBANsum = 0, TOWNsum = 0;

		int INNER_CITYcounter = 0;
		int RURALcounter = 0;
		int SUBURBANcounter = 0;
		int TOWNcounter = 0;

		if (bkrecords != null) {

			for (int i = 0; i < bkrecords.length; i++) {
				if (bkrecords[i].getREGION().equals("INNER_CITY")) {

					INNER_CITYsum += bkrecords[i].getINCOME();
					INNER_CITYcounter++;

				} else if (bkrecords[i].getREGION().equals("RURAL")) {

					RURALsum += bkrecords[i].getINCOME();

					RURALcounter++;
				} else if (bkrecords[i].getREGION().equals("SUBURBAN")) {

					SUBURBANsum += bkrecords[i].getINCOME();
					SUBURBANcounter++;

				} else if (bkrecords[i].getREGION().equals("TOWN")) {

					TOWNsum += bkrecords[i].getINCOME();
					TOWNcounter++;

				} else
					System.out.println("Error in finding/reading Average income!");

			}

		} else
			System.out.println("error in object compare");

		
		DecimalFormat df = new DecimalFormat("####0.00");
		String result1 = df.format(INNER_CITYsum / INNER_CITYcounter);
		String result2 = df.format(RURALsum / RURALcounter);
		String result3 = df.format(SUBURBANsum / SUBURBANcounter);
		String result4 = df.format(TOWNsum / TOWNcounter);
     System.out.println("Region average:Inner city:" + result1 + " Rural:" + result2 + " Suburban:" + result3 + " Town:"
		+ result4);

		try {

			fw.write("Region average:Inner city:" + result1 + " Rural:" + result2 + " Suburban:" + result3 + " Town:"
					+ result4);
		} catch (IOException e) {
			e.printStackTrace();
		}
	

	}

	public static void readMaxMinAge() {

		int INNER_CITYmin = 0, RURALmin = 0, SUBURBANmin = 0, TOWNmin = 0;
		int INNER_CITYmax = 0;
		int RURALmax = 0;
		int SUBURBANmax = 0;
		int TOWNmax = 0;
		if (bkrecords != null) {

			for (int i = 0; i < bkrecords.length; i++) {
				if (bkrecords[i].getREGION().equals("INNER_CITY")) {
					if (bkrecords[i].getAGE() > INNER_CITYmax) {
						INNER_CITYmax = bkrecords[i].getAGE();
					}

				} else if (bkrecords[i].getREGION().equals("RURAL")) {

					if (bkrecords[i].getAGE() > RURALmax) {
						RURALmax = bkrecords[i].getAGE();
					}

				} else if (bkrecords[i].getREGION().equals("SUBURBAN")) {
					if (bkrecords[i].getAGE() > SUBURBANmax) {
						SUBURBANmax = bkrecords[i].getAGE();
					}

				} else if (bkrecords[i].getREGION().equals("TOWN")) {
					if (bkrecords[i].getAGE() > TOWNmax) {
						TOWNmax = bkrecords[i].getAGE();
					}

				} else
					System.out.println("Error in finding/reading max age!");

			}

			for (int i = 0; i < bkrecords.length; i++) {
				if (bkrecords[i].getREGION().equals("INNER_CITY")) {
					int j = 0;
					if (bkrecords[j].getAGE() < INNER_CITYmax) {

						INNER_CITYmin = bkrecords[j].getAGE();
						j++;
					}

				} else if (bkrecords[i].getREGION().equals("RURAL")) {
					int j = 0;
					if (bkrecords[j].getAGE() < RURALmax) {
						RURALmin = bkrecords[j].getAGE();
						j++;
					}

				} else if (bkrecords[i].getREGION().equals("SUBURBAN")) {
					int j = 0;
					if (bkrecords[j].getAGE() < SUBURBANmax) {
						SUBURBANmin = bkrecords[j].getAGE();
						j++;
					}

				} else if (bkrecords[i].getREGION().equals("TOWN")) {
					int j = 0;
					if (bkrecords[j].getAGE() < TOWNmax) {
						TOWNmin = bkrecords[j].getAGE();
						j++;
					}

				} else
					System.out.println("Error in finding/reading min age!");
			}

			System.out.println("Max age's :" + INNER_CITYmax + +RURALmax + "\n" + SUBURBANmax + "\n" + TOWNmax + "\n"
					+ "min:(" + INNER_CITYmin + RURALmin + SUBURBANmin + TOWNmin + ")\n");

		}
	
				System.out.println("\nMax/Minimum Age:Inner city:(" + "minimum:" + INNER_CITYmin + "," + "max:" + INNER_CITYmax
						+ ")" + " Rural:(" + "minimum:" + RURALmin + "," + "max:" + RURALmax + ")" + " Suburban:(" + "minimum:"
						+ SUBURBANmin + "," + "max:" + SUBURBANmax + ")" + " Town: (" + "minimum:" + TOWNmin + "," + "max:"
						+ TOWNmax + ")");
				try {
					fw.write("\nMax/Minimum Age:Inner city:(" + "minimum:" + INNER_CITYmin + "," + "max:" + INNER_CITYmax
							+ ")" + " Rural:(" + "minimum:" + RURALmin + "," + "max:" + RURALmax + ")" + " Suburban:(" + "minimum:"
							+ SUBURBANmin + "," + "max:" + SUBURBANmax + ")" + " Town: (" + "minimum:" + TOWNmin + "," + "max:"
							+ TOWNmax + ")");
				} catch (IOException e) {
					e.printStackTrace();
				}

	}

	public static void readFemaleInfo() {

		int FemaleINNER_CITY = 0;
		int FemaleRURALcounter = 0;
		int FemaleSUBURBANcounter = 0;
		int FemaleTOWNcounter = 0;
		int i ;
		if (bkrecords != null) {
		for (i=0; i < bkrecords.length; i++) {
			if (bkrecords[i].getSEX().equals("FEMALE"))
			{
				if (bkrecords[i].getREGION().equals("INNER_CITY") && bkrecords[i].getMORTGAGE().equals("YES")&& bkrecords[i].getSAVE_ACT().equals("YES"))
				{
					FemaleINNER_CITY++;
				}
			}
			if (bkrecords[i].getSEX().equals("FEMALE"))
				{
				if (bkrecords[i].getREGION().equals("INNER_CITY") && bkrecords[i].getMORTGAGE().equals("YES")&& bkrecords[i].getSAVE_ACT().equals("YES")) 
				
				{
					FemaleRURALcounter++;
				}
				}
					if (bkrecords[i].getSEX().equals("FEMALE"))
						{
						if (bkrecords[i].getREGION().equals("INNER_CITY") && bkrecords[i].getMORTGAGE().equals("YES")&& bkrecords[i].getSAVE_ACT().equals("YES")) 
						
						{
							FemaleSUBURBANcounter++;
						}
						}
					if (bkrecords[i].getSEX().equals("FEMALE"))
					{
						if (bkrecords[i].getREGION().equals("INNER_CITY") && bkrecords[i].getMORTGAGE().equals("YES")
								&& bkrecords[i].getSAVE_ACT().equals("YES")) 
						{
							FemaleTOWNcounter++;
						}
					}
		
		}
		
		
	}
		System.out.println(FemaleINNER_CITY + FemaleRURALcounter + FemaleSUBURBANcounter + FemaleTOWNcounter);
	}

	public static void readMaleInfo() {

	}

}
