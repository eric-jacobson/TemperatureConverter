import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        double temperature;

        Scanner sc = new Scanner(System.in);

        ConvertC temp = new ConvertC();

        System.out.println("Enter Fahrenheit temperature to convert to Celsius: ");
        temperature = sc.nextDouble();

        System.out.println(temp.convertC(temperature));


    }

}
