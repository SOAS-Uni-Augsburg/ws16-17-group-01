
public class Thermostat {

	public static void main(String[] args) {
		float tMin = 15;
		float tMax = 20;
		double tCur = 18.0;
		float[] outsideTemp = new float[] {10, 25, 30};
		
		for(int i = 0; i<outsideTemp.length; i++){
			// determine if temp is ok, then do nothing (pass), otherwise heat or cool 
			System.out.print(i+1 + ". run: ");
			System.out.println("Mixed temp of "+ mixTemp(outsideTemp[i], tCur));
			
			if(mixTemp(outsideTemp[i], tCur)<tMin) 		{
				// heating
				while(mixTemp(outsideTemp[i], tCur)<tMin) tCur = heat(tCur); System.out.println("Heat to "+ tCur); 
			}
			else if(mixTemp(outsideTemp[i], tCur)>tMax)	{
				// cooling
				while(mixTemp(outsideTemp[i], tCur)>tMax) tCur = cool(tCur); System.out.println("Cool to "+ tCur); 
			}
			else if((mixTemp(outsideTemp[i], tCur)>tMin && (mixTemp(outsideTemp[i], tCur) <tMax))) {
				// keeping
				pass(tCur); System.out.println("Nice at "  + tCur); 
			}
		}
	}
	
	static double heat(Double temp){
		// Heat inside temp by 5 deg
		temp = temp + 5.0;
		return temp;
	}
	
	static double cool(Double temp){
		// heat inside temp by 5 deg
		temp = temp - 5.0;
		return temp;
	}
	
	static double pass(Double temp){
		// keep inside temp same, not necessary
		temp = temp + 0.0;
		return temp;
	}
	
	static double mixTemp(Float outTemp, Double inTemp){
		// calculate if mix of inside and outside temp
		double mixTemp = (outTemp + inTemp)/2;
		return mixTemp;
	}

}
