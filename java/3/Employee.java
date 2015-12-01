package ntou.cs.java2015.yuhang;
import java.util.Scanner;
public  abstract class Employee{
  protected Bonus bonus;
  protected Scanner sc;
  protected abstract void inputData();
  public abstract int getEarning();
  public abstract int getBonus();
}

class SalariedEmployee extends Employee{
  private int week;
  private int workWeek;
  private int bonusType;

  public SalariedEmployee(){
    inputData();
  }
  protected void inputData(){
    sc = new Scanner(System.in);
    System.out.printf("Please input weekly salary: ");
    week = sc.nextInt();
    System.out.printf("Please input working weeks: ");
    workWeek = sc.nextInt();
    System.out.printf("Please input type of Bonus (1: static, 2: dynamic): ");
    bonusType = sc.nextInt();
    if(bonusType == 1){
      bonus = new StaticBonus();
    }
    else if(bonusType == 2){
      bonus = new DynamicBonus();
    }
  }
  public int getEarning(){
    return week*workWeek;
  }
  public int getBonus(){
    return bonus.getBonus(getEarning());
  }
  public String toString(){
    return "Salaried Employee => weekly salary: "+ week+", week: "+workWeek+", calculated earnings: "+getEarning()+", bonus: "+ getBonus();
  }
}

class HourlyEmployee extends Employee{
  private int hour;
  private int workHour;
  private int bonusType;

  public HourlyEmployee(){
    inputData();
  }
  protected void inputData(){
    sc = new Scanner(System.in);
    System.out.printf("Please input hourly salary: ");
    hour = sc.nextInt();
    System.out.printf("Please input working hours: ");
    workHour = sc.nextInt();
    System.out.printf("Please input type of Bonus (1: static, 2: dynamic): ");
    bonusType = sc.nextInt();
    if(bonusType == 1){
      bonus = new StaticBonus();
    }
    else if(bonusType == 2){
      bonus = new DynamicBonus();
    }
  }
  public int getEarning(){
    return hour*workHour;
  }
  public int getBonus(){
    return bonus.getBonus(getEarning());
  }
  public String toString(){
    return "Hourly Employee => hourly salary: " + hour + ", hours: " + workHour + ", calculated earnings: " + getEarning() + ", bonus: " + getBonus();
  }
}

class CommissionEmployee extends Employee{
  private int commissionRate;
  private int grossSales;
  private int bonusType;

  public CommissionEmployee(){
    inputData();
  }
  protected void inputData(){
    sc = new Scanner(System.in);
    System.out.printf("Please input commission rate: ");
    commissionRate = sc.nextInt();
    System.out.printf("Please input gross sales: ");
    grossSales = sc.nextInt();
    System.out.printf("Please input type of Bonus (1: static, 2: dynamic): ");
    bonusType = sc.nextInt();
    if(bonusType == 1){
      bonus = new StaticBonus();
    }
    else if(bonusType == 2){
      bonus = new DynamicBonus();
    }
  }
  public int getEarning(){
    return commissionRate*grossSales;
  }
  public int getBonus(){
    return bonus.getBonus(getEarning());
  }
  public String toString(){
    return "Commission Employee => commission rate: "+commissionRate+", gross sales: "+grossSales+", calculated earnings: "+getEarning()+", bonus: "+getBonus();
  }
}

class PieceWorker extends Employee{
  private int wage;
  private int piece;
  private int bonusType;

  public PieceWorker(){
    inputData();
  }
  protected void inputData(){
    sc = new Scanner(System.in);
    System.out.printf("Please input wage: ");
    wage = sc.nextInt();
    System.out.printf("Please input piece: ");
    piece = sc.nextInt();
    System.out.printf("Please input type of Bonus (1: static, 2: dynamic): ");
    bonusType = sc.nextInt();
    if(bonusType == 1){
      bonus = new StaticBonus();
    }
    else if(bonusType == 2){
      bonus = new DynamicBonus();
    }
  }
  public int getEarning(){
    return wage*piece;
  }
  public int getBonus(){
    return bonus.getBonus(getEarning());
  }
  public String toString(){
    return "Piece Worker => wage: "+wage+", piece: "+piece+", calculated earnings: "+getEarning()+", bonus: "+getBonus();
  }
}
