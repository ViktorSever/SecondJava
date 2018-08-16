import sun.rmi.runtime.Log;

import java.util.ArrayList;
/*
    *author Viktor Shkuratov
    * date 16/08/2018
    * Java2 HomeWorkFirst
 */
public class SecondJavaHomeworkFirst {

    private static ArrayList<Lada> cars = new ArrayList<>();

    public static void main(String[] args) {

        cars.add(new Lada("Lada 2101", "passenger car", 4, 4, 1970));
        cars.add(new Lada("Lada 2102", "passenger car", 4, 6, 1975));
        cars.add(new Lada("Lada 2103", "passenger car", 4, 3, 1980));
        cars.add(new Lada("Lada 2104", "passenger car", 4, 1, 1990));
        cars.add(new Lada("Lada 2105", "passenger car", 4, 7, 1984));
        cars.add(new Lada("Lada 2107", "passenger car", 4, 8, 1995));
        cars.add(new Lada("Lada 2108", "passenger car", 4, 10, 2005));
        cars.add(new Lada("Lada 2109", "passenger car", 4, 2, 2000));
		
        getByYear(1995);//Получаю автомобили моложе 1995г
        getByRating(4);//Получаю автомобили райтингом 4 или ниже

    }
	
	/*
		Метод получения машины 
		моложе передаваемого года
	*/
    public static void getByYear (int year) {
        System.out.println("Get by Year \n");
        try {
            for (Lada lada:cars) {
                if (lada.getYear() > year) {
                    System.out.println(lada.toString());
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }
	/*
		Метод получения автомобиля
		рейтингом ниже или соответствующего передаваемого
	*/
    public static void getByRating(int rating) {
        System.out.println("Get by Rating \n");
        try {
            for (Lada lada:cars) {
                if (lada.getRating() <= rating) {
                    System.out.println(lada.toString());
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }


}


abstract class Car   {
    private String model;//Название модели
    private String TYPE;//Тип машины
    private int wheels;//Количество колес

    public Car(String model, String TYPE, int wheels) {
        this.model = model;
        this.TYPE = TYPE;
        this.wheels = wheels;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
}

class Lada extends Car {

    private int rating;//райтинг машины
    private int weight;//Масса
    private int year;//Год производства

    public Lada(String model, String TYPE, int wheels, int rating, int year) {
        super(model, TYPE, wheels);
        this.rating = rating;
        this.year = year;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Model: " + this.getModel() + "\nType: " + this.getTYPE() + "\nWheels: " +this.getWheels() + "\nRating: " + getRating() + "\nYear: " + getYear() + "\n"; //Получение информации об автомобили
    }
}

