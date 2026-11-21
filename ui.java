import java.util.*;
import java.time.*;

public class ui
{
    public static class Hotels{
        public String name;
        public int rooms;
        public int[] arr ;
      

        public Hotels(int room)
        {
            this.rooms=room;
            this.arr=new int[room+1];
        }

        public void displayrooms()
        {
            
            for(int i=1;i<=rooms;i++)
              {
                if(arr[i]==0)
                System.out.println("Room No. "+i+" -- ");
                else
                System.out.println("Room No. "+i+"Booked");
              }
        }

        public void bookroom(int roomno)
        {
            Scanner sc=new Scanner(System.in);
            if(roomno>rooms)
              System.out.println("Invalid room ");
            else{
                while(true){
              System.out.println("Please enter the check in date and time ");

              System.out.print("Date: ");
              int date = sc.nextInt();
              System.out.print("\nMonth :");
              int month = sc.nextInt();
              System.out.print("\n Year");
              int year = sc.nextInt();
                
              try
              {
                LocalDate entered = LocalDate.of(year,month,date);
                LocalDate today= LocalDate.now();

                if(entered.isBefore(today))
                   System.out.println("Please enter the date after today's date ");
                else
                {
                    System.out.println("Enter the checkout date ");
                    System.out.print("\nDate : ");
                    int cday = sc.nextInt();
                    System.out.print("\n Month : ");
                    int cmonth = sc.nextInt();
                    System.out.print("\n year : ");
                    int cyear = sc.nextInt();

                    LocalDate centered = LocalDate.of(cyear,cmonth,cday);
                    if(centered.isBefore(entered))
                    {
                        System.out.println("Please enter the date after checkin date ");
                    }

                    else
                    {
                        System.out.println("Please pay 500 to book the room ");
                        int paid =0; 
                        while(paid<500)
                        {
                            System.out.println("Please enter the "+paid +" amount ");
                            paid += sc.nextInt();
                        }
                        arr[room] = 1;
                        break;
                    }
                }
              }  
              catch(DateTimeException e)
               {
                System.out.println("Please enter the valid date  "+ e.getMessage());
               }
            }
            }

        }
    }



    public static void main(String args[])
        {
            Hotels h1=new Hotels(10);
            Hotels h2=new Hotels(12);
            Hotels h3=new Hotels(13);

           

            int ch=0;
            
            
            System.out.println("1.Hotel Sagar \n 2.Shanti Sagar \n 3.Pakashale \n");
            System.out.println("Plase slect the hotel ");
            Scanner sc = new Scanner(System.in);
            ch = sc.nextInt();
            switch(ch){
                case 1: h1.displayrooms();
                       break;
                case 2 : h2.displayrooms();
                       break;
                case 3 : h3.displayrooms();
                      break;
                default : System.out.println("Please enter correct hotel number");
                      break;
            }

            System.out.println(" -- -> vacant \n");

            System.out.println("Please enter any vacant room number to book the room ");
            int sel = sc.nextInt();
            if(ch==1)
               h1.bookroom(sel);
            
            
            
        }
}