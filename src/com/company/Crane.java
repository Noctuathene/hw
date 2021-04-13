package com.company;

import java.util.Comparator;

public class Crane extends Transport {
    public int LiftedLoads;
    private static double FuelPrice  = 48.90;
    private  static double FuelСonsumption = 20;



    public double CalcluateGCM()
    {
        return Mileage / FuelСonsumption * FuelPrice;
    }



}
