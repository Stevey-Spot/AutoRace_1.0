
public class arraysortieren {
	public static void main(int[] kilometerstand,String[] namen,double[] zeiten)
	{
		int temp;
		String temp2;
		double temp3;

		boolean fixed=false;
		while (fixed==false)
		{
			fixed=true;
			for (int i=0;i<10;i++)
			{
				if (kilometerstand[i]>kilometerstand[i+1])
				{
					temp=kilometerstand[i];
					temp2=namen[i];
					temp3=zeiten[i];
					
					kilometerstand[i]=kilometerstand[i+1];
					namen[i]=namen[i+1];
					zeiten[i]=zeiten[i+1];
					
					kilometerstand[i+1]=temp;
					namen[i+1]=temp2;
					zeiten[i+1]=temp3;
					fixed=false;
				}
			}
		}
	}

}
