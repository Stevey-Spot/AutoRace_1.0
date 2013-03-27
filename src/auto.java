

public class auto {
	public double benzin;
	public int geschwindigkeit;
	public int kilometer;
	public double zeit;
	public int nummer;
	public String name;


	public auto(int benzin_, int gesch_, int nummer_,String name_)
	{
		benzin=benzin_;
		geschwindigkeit=gesch_;
		kilometer=0;
		zeit =0;
		nummer =nummer_;
		name=name_;
	}

	public void fahren()
	{
		benzin = benzin - benzinVerbrauch(geschwindigkeit);
		zeit++;
	}
	public void runden()
	{
		benzin = benzin*100;
		benzin = Math.round(benzin);
		benzin = benzin/100;
	}
	public void gesamtkilometer()
	{
		kilometer = kilometer+geschwindigkeit;
	}
	public void kilometersonderfall(int zielkilometer)
	{
		kilometer= zielkilometer;
	}
	public void zeitrunden()
	{
		zeit= zeit*1000;
		zeit = Math.round(zeit);
		zeit = zeit /1000;
	}
	public void sonderfall(int zielkilometer)
	{

		benzin=benzin-(0.000483*(geschwindigkeit)*(geschwindigkeit) - 0.0326*(geschwindigkeit) + 2.1714 + 66/(geschwindigkeit))*(zielkilometer-kilometer)/100.0;
	}
	public void fahrenbisinsziel(int zielkilometer)
	{
		System.out.println("Dein Auto faehrt 1 Stunde mit "+geschwindigkeit+" km/h.");
		zeit++;
		zeit=zeit -((zielkilometer-kilometer*1.000)/geschwindigkeit);
		zeitrunden();
		sonderfall(zielkilometer);
		runden();
		kilometersonderfall(zielkilometer);

		System.out.println("Du hast noch "+benzin+" Liter im Tank.");
		System.out.println("Du hast bisher eine Gesamtstrecke von "+kilometer+" km zurueckgelegt.");
		System.out.println("Du bist im Ziel !!");

		System.out.println(" ");

	}
	public void fahrtbisinsziel(int zielkilometer)
	{
		zeit++;
		zeit=zeit -((zielkilometer-kilometer*1.000)/geschwindigkeit);
		zeitrunden();
		sonderfall(zielkilometer);
		runden();
		kilometersonderfall(zielkilometer);

	}

	public void showProgress (int zielkilometer){
		//Sonst bekommt man Probleme mit den Datenformaten
		double zielkilometer_ = (double) zielkilometer;
		//Wie lange soll die modellierte Strecke sein?
		double modelstreckenlaenge = 70;

		System.out.print(name + "\t");

		// road behind car
		double quotient = kilometer/zielkilometer_;
		double made = (quotient*modelstreckenlaenge);
		double notMade = modelstreckenlaenge - made;
		for (int i = 0; i < made; i++){
			System.out.print("I");
		}
		// print > for a moving car and * for one with no gas.
		if (benzin > 0){
			System.out.print(">");
		} else {
			System.out.print("*");
		}

		//road in front of car
		for (int i = 0; i < notMade; i++){
			System.out.print("-");
		}
		System.out.println();
	}

	public double benzinVerbrauch (){
		return benzinVerbrauch(this.geschwindigkeit);
	}


	public double benzinVerbrauch (int geschwindigkeit){
		double benzinVerbrauch = (0.000483*(geschwindigkeit)*(geschwindigkeit) - 0.0326*(geschwindigkeit) + 2.1714 + 66/(geschwindigkeit))*geschwindigkeit/100.0;
		return benzinVerbrauch;
	}

}
