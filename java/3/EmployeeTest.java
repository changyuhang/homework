package ntou.cs.java2015.yuhang;
import java.util.*;
public class EmployeeTest{
    public static void main(String[] args){
        int inputType;
        int count = 1;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.printf("---Earnings Calculation System:\n1. Salaried Employee\n2. Hourly Employee\n3. Commission Employee\n4. Piece Worker\nPlease input (1~4, -1 to end): ");
            inputType = sc.nextInt();
            Set<Employee> temp=new LinkedHashSet<>();
            switch(inputType){
                case 1:{
                    //Employee yee = new SalariedEmployee();
                    temp.add(new SalariedEmployee());
                    break;
                }
                case 2:{
                    Employee yee = new HourlyEmployee();
                    temp.add(yee);
                    break;
                }
                case 3:{
                    Employee yee = new CommissionEmployee();
                    temp.add(yee);
                    break;
                }
                case 4:{
                    Employee yee = new PieceWorker();
                    temp.add(yee);
                    break;
                }
                case -1:
                    System.out.println("end\n"+temp.size());
                    int c= 1;
                    for(Employee i : temp){
                        System.out.printf("No.%d\n", c);
                        System.out.println(i);
                        c++;
                    }
                    return;
                default:
            }
            count++;
            /*if(inputType==1){
                Employee yee = new SalariedEmployee();
                temp.add(yee);
                //System.out.println(yee);
                count++;
            }
            else if(inputType==2){
                Employee yee = new HourlyEmployee();
                temp.add(yee);
                //System.out.println(yee);
                count++;
            }
            else if(inputType==3){
                Employee yee = new CommissionEmployee();
                temp.add(yee);
                //System.out.println(yee);
                count++;
            }
            else if(inputType==4){
                Employee yee = new PieceWorker();
                temp.add(yee);
                //System.out.println(yee);
                count++;
            }
            else if(inputType==-1){
                System.out.println("end\n");
                int c= 1;
                for(Employee i : temp){
                    System.out.printf("No.%d\n", c);
                    System.out.println(i);
                    c++;
                }
                break;
            }*/
        }
    }
}
