package ntou.cs.java2015.yuhang;
public class CrapsSimulation{
	static final int COUTINUE=0,LOSE=1,WIN=2;
	static final int SIZE=22,GAMES=1000;
	public void crapsSimulation(){
		int gameStatus,sum,roll;
		int myPoint=0;
		int length=0;
		int wins[],losses[];
		int winSum=0,loseSum=0;
		wins=new int[SIZE];
		losses=new int [SIZE];
		for(int i=1;i<=GAMES;i++){
			sum=rollDice();
			roll=0;
			switch(sum){
				case 7:
				case 11:
					gameStatus=WIN;
					break;
				case 2:
				case 3:
				case 12:
					gameStatus=LOSE;
					break;
				default:
					gameStatus=COUTINUE;
					myPoint=sum;
					break;
			}
			while(gameStatus==COUTINUE){
				sum=rollDice();
				++roll;
				if(sum==myPoint)
					gameStatus=WIN;
				else
					if(sum==7)
						gameStatus=LOSE;
			}
			if(roll>21)
				roll=21;
			if(gameStatus==WIN){
				++wins[roll];
				++winSum;
			}else{
				++losses[roll];
				++loseSum;
			}
		}
		for(int i=1;i<=21;i++){
			if(i==21)
				System.out.println(wins[i]+" games won and "+losses[i]+" game lost on rolls after the 20 th rool");
			else
				System.out.println(wins[i]+" games won and "+losses[i]+" game lost on rolls #"+i);
		}
		System.out.println("\nThe chance of winning are "+winSum+" / "+(winSum+loseSum)+" = "+(100.0*winSum/(winSum+loseSum))+"%");
		for(int i=0;i<=21;i++)
			length+=wins[i]*i+losses[i]*i;
		System.out.println("The average game length is "+( length / 1000.0 )+"rolls.");
	}
	public static int rollDice(){
		int die1=(int)(1+Math.random()*6);
		int die2=(int)(1+Math.random()*6);
		int workSum=die1+die2;
		return workSum;
	}
}
