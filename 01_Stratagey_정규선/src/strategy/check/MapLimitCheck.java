package strategy.check;

public class MapLimitCheck {
	final int MAX_VALUE = 100;
	final int MIN_VALUE = -100;
	
	public int check(int value){
		if ((value > MIN_VALUE) && (value < MAX_VALUE))
			return value;
		else{
			System.out.println("�� ������ ������ϴ�.");
			if(value > 0) 	value = MAX_VALUE;
			else 			value = MIN_VALUE;
		}
		return value;
	}
}
