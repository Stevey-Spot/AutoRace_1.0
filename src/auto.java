

public class auto {
	public  double benzin;
	public  int geschwindigkeit;
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
		benzin=benzin-(0.000483*(geschwindigkeit)*(geschwindigkeit) - 0.0326*(geschwindigkeit) + 2.1714 + 66/(geschwindigkeit))*geschwindigkeit/100;
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
		System.out.println("Dein Auto fährt 1 Stunde mit "+geschwindigkeit+" km/h.");
		zeit++;
		zeit=zeit -((zielkilometer-kilometer*1.000)/geschwindigkeit);
		zeitrunden();
		sonderfall(zielkilometer);
		runden();
		kilometersonderfall(zielkilometer);

		System.out.println("Du hast noch "+benzin+" Liter im Tank.");
		System.out.println("Du hast bisher eine Gesamtstrecke von "+kilometer+" km zurückgelegt.");
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

}
