

import java.util.Scanner;


public class mainclass 
{

	public static void main(String args[])
	{	Scanner myScanner = new Scanner(System.in);

	//Erzeugen von Anfangsbenzinwrt und Zielkilometerzahl
	int anfangsbenzinwert=10+(int)(Math.round(Math.random()*90));
	int zielkilometer=Math.round(anfangsbenzinwert*(21+(int)(Math.random()*4)));


	//Spielerauto erzeugen
	System.out.println("Herzlich willkommen zu AutoRace 1.0!!");
	System.out.println(" ");
	System.out.println("Bitte gebe einen Namen für dein Auto ein:");
	auto spielerauto = new auto(anfangsbenzinwert,0,11,myScanner.next());

	//Gegnerische Autos mit zufälligen Geschwindigkeiten erzeugen
	auto autos[]=new auto[11];
	for (int i=0;i<10;i++)
	{
		autos[i]=new auto(anfangsbenzinwert,10+(int)(Math.random()*120),i+1,"Auto "+ i);
	}
	autos[10]=spielerauto;
	//Autos Nummern geben


	String[] namen=new String[11];
	for (int i=0;i<11;i++)
	{
		namen[i]=autos[i].name;
	}
	System.out.println("Der Benzinstand aller Autos beträgt "+autos[2].benzin+" Liter");
	System.out.println("Es gewinnt das Auto, dass zuerst "+zielkilometer+" km zurückgelegt hat.");
	//Prüfe ob schon jemand im Ziel ist; Falls ja -> Sieger
	while((spielerauto.kilometer < zielkilometer) && (autos[0].kilometer<zielkilometer)&&(autos[1].kilometer<zielkilometer)&&(autos[2].kilometer<zielkilometer)&&(autos[3].kilometer<zielkilometer)&&(autos[4].kilometer<zielkilometer)&&(autos[5].kilometer<zielkilometer)&&(autos[6].kilometer<zielkilometer)&&(autos[7].kilometer<zielkilometer)&&(autos[8].kilometer<zielkilometer)&&(autos[9].kilometer<zielkilometer))
	{
		//Geschwindigkeit für die nächste Stunde eingeben
		System.out.println("Bitte gebe eine Geschwindigkeit für dein Auto an, mit der es die nächste Stunde fahren soll (Zwischen 10 und 130):");

		int[] erlaubt2 = {10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130};
		spielerauto.geschwindigkeit=letUserChoose(erlaubt2,myScanner);



		if ((zielkilometer-spielerauto.kilometer)> spielerauto.geschwindigkeit)
		{
			//Prüfe ob das Benzin ausreicht für 1 Stunde fahren
			//Falls ja -> fahren; falls nein -> zieleinfahrt?	
			if (spielerauto.benzin-(0.000483*(spielerauto.geschwindigkeit)*(spielerauto.geschwindigkeit) - 0.0326*(spielerauto.geschwindigkeit) + 2.1714 + 66/(spielerauto.geschwindigkeit))*spielerauto.geschwindigkeit/100 >= 0)
			{
				System.out.println(" ");
				System.out.println("Dein Auto fährt 1 Stunde mit "+spielerauto.geschwindigkeit+" km/h.");
				spielerauto.fahren();
				spielerauto.runden();
				spielerauto.gesamtkilometer();
				System.out.println("Du hast noch "+spielerauto.benzin+" Liter im Tank.");
				System.out.println("Du hast bisher eine Gesamtstrecke von "+spielerauto.kilometer+" km zurückgelegt.");

				System.out.println("Es fehlen noch "+(zielkilometer-spielerauto.kilometer)+" Kilometer.");

				System.out.println(" ");
			}
			else {
				System.out.println("Du hast nich genug Benzin im Tank um 1 Stunde mit dieser Geschwindigkeit zu fahren.");
				//System.out.println("Mit dieser Geschwindigkeit könntest du es bis ins Ziel schaffen, aber leider ist dein Tank vorher leer.");
				System.out.println("Dein Auto bleibt mitten auf der Strecke liegen. ");
				//INKORREKT ! System.out.println("Dein Auto bleibt "+(zielkilometer-spielerauto.benzin/((0.000483*(spielerauto.geschwindigkeit)*(spielerauto.geschwindigkeit) - 0.0326*(spielerauto.geschwindigkeit) + 2.1714 + 66/(spielerauto.geschwindigkeit))/100))+" km vor dem Ziel stehen.");
				System.out.println(" ");
				System.out.println("Du hast verloren!");
				System.exit(0);
			}
		}
		else 
		{	


			//Zieleinfahrt
			//Prüfe ob das der spieler ins ziel kommen kann
			if (spielerauto.benzin-(0.000483*(spielerauto.geschwindigkeit)*(spielerauto.geschwindigkeit) - 0.0326*(spielerauto.geschwindigkeit) + 2.1714 + 66/(spielerauto.geschwindigkeit))*(zielkilometer-spielerauto.kilometer)/100 >= 0)
			{
				spielerauto.fahrenbisinsziel(zielkilometer);
			}


			else
			{
				System.out.println("Du hast nich genug Benzin im Tank um 1 Stunde mit dieser Geschwindigkeit zu fahren.");
				//System.out.println("Mit dieser Geschwindigkeit könntest du es bis ins Ziel schaffen, aber leider ist dein Tank vorher leer.");
				System.out.println("Dein Auto bleibt mitten auf der Strecke liegen. ");
				//System.out.println("Dein Auto bleibt "+zielkilometer-spielerauto.benzin/((0.000483*(spielerauto.geschwindigkeit)*(spielerauto.geschwindigkeit) - 0.0326*(spielerauto.geschwindigkeit) + 2.1714 + 66/(spielerauto.geschwindigkeit))/100)+" km vor dem Ziel stehen.")
				System.out.println(" ");
				System.out.println("Du hast verloren!");
				System.exit(0);
			}

		}



		// Gegnerische Autos fahren lassen
		System.out.println("Die anderen Autos fahren 1 Stunde.");
		System.out.println(" ");

		for (int k=0;k<10;k++)
		{

			if ((zielkilometer-autos[k].kilometer)> autos[k].geschwindigkeit)
			{
				if (autos[k].benzin-(0.000483*(autos[k].geschwindigkeit)*(autos[k].geschwindigkeit) - 0.0326*(autos[k].geschwindigkeit) + 2.1714 + 66/(autos[k].geschwindigkeit))*autos[k].geschwindigkeit/100 > 0)

				{
					autos[k].fahren();
					autos[k].runden();
					autos[k].gesamtkilometer();

				}
				}
				else 
				{

					{
						//Zieleinfahrt
						//Prüfe ob das der spieler ins ziel kommen kann
						if (autos[k].benzin-(0.000483*(autos[k].geschwindigkeit)*(autos[k].geschwindigkeit) - 0.0326*(autos[k].geschwindigkeit) + 2.1714 + 66/(autos[k].geschwindigkeit))*(zielkilometer-autos[k].kilometer)/100 >= 0)
						{
							autos[k].fahrtbisinsziel(zielkilometer);
						}
					}

				}
			
		}
	}
	//SIEGER
	double[] zeiten=new double[11];
	for(int j=0;j<11;j++)
	{
		zeiten[j]=autos[j].zeit;
	}
	int[] kilometerstand=new int[11];
	for(int i=0;i<11;i++)
	{
		kilometerstand[i]=autos[i].kilometer;
	}

	arraysortieren.main(kilometerstand,namen,zeiten);
	if (spielerauto.kilometer>kilometerstand[9])
	{
		System.out.println("Gratulation, du warst der Schnellste!");
		System.out.println("Hier die Ergebnistabelle:");

	}
	else
	{
		System.out.println("Schade, aber du warst leider nicht der Schnellste!");
		System.out.println("Hier die Ergebnistabelle:");
	}
	for (int h =0;h<11; h++)
	{
		if (autos[h].kilometer >= zielkilometer)
		{
			autos[h].zeit=autos[h].zeit -(double)((autos[h].kilometer-zielkilometer)/autos[h].geschwindigkeit);
			autos[h].zeitrunden();
		}
	}
	/*
			if (spielerauto.kilometer >= zielkilometer)
			{

				System.out.println("Du hast die Strecke in "+spielerauto.zeit+" Stunden absolviert.");
				System.out.println("Hier die schnellsten der anderen Autos:");
				System.out.println(" ");
			}
			else {
				System.out.println("Leider warst du nicht schnell genug...");
			}



					System.out.println("Auto "+(h+1)+" fuhr die Strecke in "+autos[h].zeit+" Stunden.");
				}
				//else???
			}
	 */
	table2(kilometerstand,namen,zeiten);
	}



















	public static void table2(int[] kilometerstand,String[] namen,double[] zeiten)
	{
		System.out.println("Name \t Kilometerstand\tZeit");

		for (int i=10;i>0;i--)
		{
			System.out.println(namen[i] + "\t"+kilometerstand[i]+"\t"+zeiten[i]+"h");
		}
	}










































	private static int letUserChoose(int[] allowed, Scanner myScanner){
		System.out.print("Geschwindigkeit in km/h: ");
		boolean correct;
		int chosen;
		do {
			String temp = myScanner.next();
			chosen = justAnInt(temp);

			correct = false;
			for (int i : allowed) {
				if (chosen == i){
					correct = true;	
				}
			}

			if (!correct){
				System.out.println("wrong input! try again...");
				System.out.println();
				System.out.print("Geschwindikeit in km/h: ");
			}
		} while (!correct);
		return chosen;
	}
	private static int justAnInt(String string){
		int filtered;
		String temp2 = "";
		for (int i = 0; i < string.length(); i++){
			if ((int) string.charAt(i) >= 48 && (int) string.charAt(i) <= 57){
				temp2 += string.charAt(i);	
			}
		}
		if (temp2 == ""){
			filtered = -1;
		} else {
			filtered = Integer.parseInt(temp2);
		}
		return filtered;
	}



	//Tabelle erstellen....

}


