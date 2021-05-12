import java.util.Scanner;
public class FactorialWithWhileLoop {
   public static void main(String args[]){
      int i =1, factorial=1, number;
      System.out.println("Enter the number to which you need to find the factorial:");
      Scanner sc = new Scanner(System.in);
      number = sc.nextInt();

      while(i <=number) {
         factorial = factorial * i;
         i++;
      }
      System.out.println("Factorial of the given number is:: "+factorial);
   }
}