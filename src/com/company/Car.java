package com.company;

public class Car extends Transport{
    private static double FuelPrice  = 46.10;
    private  static double FuelСonsumption = 12.5;

    public double CalcluateGCM()
    {
        return Mileage / FuelСonsumption * FuelPrice;
    }


}
