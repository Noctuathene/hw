package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {

    public static LinkedList<Transport> Parse(LinkedList<String> carsList)
    {
        LinkedList<Transport> result= new LinkedList<>();
        for (var carString: carsList)
        {
            var splitCar = carString.split("-");
            var carCodeAndNumber = splitCar[0].split("_");
            var carCode = Integer.parseInt(carCodeAndNumber[0].replaceAll("C", ""));
            var carNumber = Integer.parseInt(carCodeAndNumber[1]);
            var carMileage = Integer.parseInt(splitCar[1]);
            switch (carCode)
            {
                case(100):
                {
                    var car = new Car();
                    car.CarCode = carCode;
                    car.Mileage = carMileage;
                    car.Number  =carNumber;
                    result.add(car);
                    break;
                }
                case(200):
                {
                    var car = new Truck();
                    car.CarCode = carCode;
                    car.Mileage = carMileage;
                    car.Number  = carNumber;
                    car.TransportedCargo = Integer.parseInt(splitCar[2]);
                    result.add(car);
                    break;
                }
                case(300):
                {
                    var car = new PassangerTransport();
                    car.CarCode = carCode;
                    car.Mileage = carMileage;
                    car.Number  = carNumber;
                    car.PassengersCarried = Integer.parseInt(splitCar[2]);
                    result.add(car);
                    break;
                }
                case (400):
                    var car = new Crane();
                    car.CarCode = carCode;
                    car.Mileage = carMileage;
                    car.Number  = carNumber;
                    car.LiftedLoads = Integer.parseInt(splitCar[2]);
                    result.add(car);
                    break;
            }

        }
        return result;
    }

    public static double GetFullGSM(LinkedList<Transport> transports){
        double result = 0;
        for (var transport: transports)
        {
            result += transport.CalcluateGCM();
        }
        return  result;
    }

    public static <T> LinkedList<Transport> FilterByType(LinkedList<Transport> transports, Class<T> tClass)
    {
        LinkedList<Transport> classedTransport = new LinkedList<>();
        for (var transport: transports)
        {
            if(transport.getClass() == tClass)
            {
                classedTransport.add(transport);
            }
        }
        return classedTransport;
    }

    public static <T> double GetFullGSMByClass(LinkedList<Transport> transports, Class<T> tClass){

        return  GetFullGSM(FilterByType(transports, tClass));
    }

    public static LinkedList<Car> SortCars (LinkedList<Transport> transports){
        var result = new LinkedList<Car>();
        for (var transport: transports
             ) {
            if (transport.getClass() == Car.class)
            {
                var car = (Car)transport;
                result.add(car);
            }
        }
        Comparator<Transport> comparator = Comparator.comparing(p -> p.Mileage);
        result.sort(comparator);
        return result;
    }
    public static LinkedList<Truck> SortTruck(LinkedList<Transport> transports){
        var result = new LinkedList<Truck>();
        for (var transport: transports
        ) {
            if (transport.getClass() == Truck.class)
            {
                var truck = (Truck)transport;
                result.add(truck);
            }
        }
        Comparator<Transport> comparator = Comparator.comparing(p -> p.Mileage);
        Comparator<Truck> comparator2 = Comparator.comparing(p -> p.TransportedCargo);

        result.sort(comparator);
        result.sort(comparator2);
        return result;

    }
    public static LinkedList<Crane> SortCrane(LinkedList<Transport> transports){
        var result = new LinkedList<Crane>();
        for (var transport: transports
        ) {
            if (transport.getClass() == Crane.class)
            {
                var crane = (Crane)transport;
                result.add(crane);
            }
        }
        Comparator<Transport> comparator = Comparator.comparing(p -> p.Mileage);
        Comparator<Crane> comparator2 = Comparator.comparing(p -> p.LiftedLoads);

        result.sort(comparator);
        result.sort(comparator2);
        return result;

    }
    public static LinkedList<PassangerTransport> SortPassengerTransport(LinkedList<Transport> transports){
        var result = new LinkedList<PassangerTransport>();
        for (var transport: transports
        ) {
            if (transport.getClass() == PassangerTransport.class)
            {
                var crane = (PassangerTransport)transport;
                result.add(crane);
            }
        }
        Comparator<Transport> comparator = Comparator.comparing(p -> p.Mileage);
        Comparator<PassangerTransport> comparator2 = Comparator.comparing(p -> p.PassengersCarried);

        result.sort(comparator);
        result.sort(comparator2);
        return result;

    }

    public static void main(String[] args) {
        var input = new LinkedList<>(Arrays.asList(
                "C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20",
                "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20",
                "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28",
                "C100_1-300", "C200_1-100-750", "C300_1-32-15"));
        var cars = Parse(input);


    }
}

