package ntou.cs.java2015.yuhang;
public class DynamicBonus implements Bonus{
	@Override
	public int getBonus (int salary){
		return (int)(salary * .1);
	}
}
