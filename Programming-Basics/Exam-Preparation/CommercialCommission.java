    package Basics;

    import java.util.Scanner;

    public class CommercialCommission {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String city = scanner.nextLine();
           double sales = Double.parseDouble(scanner.nextLine());
           double bonus =0;

            if(city.equals("Sofia")){
                if(sales>=0 && sales<=500){
                    bonus = sales *0.05;
                } else if(sales>=500 && sales<=1000){
                    bonus = sales * 0.07;
                }   else if(sales>=1000 && sales<=10000){
                bonus = sales * 0.08;
            }     else if(sales>10000){
                bonus = sales * 0.12;
            }
            } else if(city.equals("Varna")){
                if(sales>=0 && sales<=500){
                    bonus = sales *0.045;
                } else if(sales>=500 && sales<=1000){
                    bonus = sales * 0.075;
                }   else if(sales>=1000 && sales<=10000){
                    bonus = sales * 0.10;
                }     else if(sales>10000) {
                    bonus = sales * 0.13;
                }
            } else if(city.equals("Plovdiv")){
                    if(sales>=0 && sales<=500){
                        bonus = sales *0.055;
                    } else if(sales>=500 && sales<=1000){
                        bonus = sales * 0.08;
                    }   else if(sales>=1000 && sales<=10000){
                        bonus = sales * 0.12;
                    }     else if(sales>10000){
                        bonus = sales * 0.145;
                }
            }
                if(bonus>0) {
                    System.out.printf("%.2f",bonus);
                }else{
                System.out.println("error");
            }


        }
    }

