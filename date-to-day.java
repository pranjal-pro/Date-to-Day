import java.util.*;

public class DateToDay {
     public static void main(String args[]) {
      
               Scanner sc = new Scanner(System.in);
               // Input dd mm yyyy
               int date = sc.nextInt();
               int month = sc.nextInt();
               int year = sc.nextInt();

               // leap year allowance
               int leap_year_count = year / 4;
               boolean leap_year = (year % 4 == 0);

               // since 1900 not leap while 2000 is....
               if (year % 100 == 0 && year % 400 != 0 && year >= 1800)
                    leap_year = false;
               if (leap_year == true && month <= 2)
                    leap_year_count--;

               if (year >= 1800)
                    for (int leap_cen_check = year / 100; leap_cen_check >= 18; leap_cen_check--)
                         if (leap_cen_check % 4 == 0)
                              continue;
                         else
                              leap_year_count--;

               // Verifying Inputs...
               boolean end = true;

               if ((year <= 0) ||
                         (month < 1 || month > 12) ||
                         (date < 1 || date > 31))
                    end = false;

               if (month == 2 && date >= 29 && leap_year == false)
                    end = false;

               if ((month == 4 || month == 6 || month == 9 || month == 11) && (date >= 31))
                    end = false;

               int day_count = 0;

               // British accepts Gorgian Calender
               // Skipping 3-13 Sept`1752....
               if (year == 1752 && month == 9 && date >= 3 && date <= 13)
                    end = false;
               if (year == 1752 && month >= 9 && date > 13)
                    day_count -= 4;
               if (year > 1752)
                    day_count -= 4;

               // Calculation
               day_count += leap_year_count + (year);
               day_count += date - 1;
               switch (month) {
                    case 12:
                         day_count += 2;
                    case 11:
                         day_count += 3;
                    case 10:
                         day_count += 2;
                    case 9:
                         day_count += 3;
                    case 8:
                         day_count += 3;
                    case 7:
                         day_count += 2;
                    case 6:
                         day_count += 3;
                    case 5:
                         day_count += 2;
                    case 4:
                         day_count += 3;
                    case 3:
                         day_count += 0;
                    case 2:
                         day_count += 3;
                    default:
                         day_count += 0;
               }

               if (end == true)
                    switch (day_count % 7) {
                         case 2:
                              System.out.println("Sunday");
                              break;
                         case 3:
                              System.out.println("Monday");
                              break;
                         case 4:
                              System.out.println("Tuesday");
                              break;
                         case 5:
                              System.out.println("Wednesday");
                              break;
                         case 6:
                              System.out.println("Thursday");
                              break;
                         case 0:
                              System.out.println("Friday");
                              break;
                         case 1:
                              System.out.println("Saturday");
                              break;
                    }
               else
                    System.out.print("Date Dosent Exist");
         
     }
}
