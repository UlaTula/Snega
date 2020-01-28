import org.junit.jupiter.api.Test;

public class HomeWork01 {
    @Test
    public void nameAgeFuelWheel() {

        //output name and age
        String name = "Дима";
        int age = 33;
        System.out.println("Привет, " + name + ", тебе увы аж " + age + "!");

        //car average fuel usage
        countFuel(34.4, 344.4);

        //cycle wheel length
        wheelLength(15); //in cm

    }

    private void countFuel(double liters, double km) {
        double count = (liters / km) * 100;
        System.out.println("Car average fuel usage: " + count);
    }

    private void wheelLength(double radiusWheel) {
        double length = 10000000 / (2 * radiusWheel * Math.PI);
        System.out.println("Wheel length count in 100 km: " + length);
    }

}

