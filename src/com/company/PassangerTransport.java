package com.company;

public class PassangerTransport extends Transport {
    public int PassengersCarried;
    private static double FuelPrice  = 47.5;
    private  static double FuelСonsumption = 11.5;

    public double CalcluateGCM()
    {
        return Mileage / FuelСonsumption * FuelPrice;
    }
}
