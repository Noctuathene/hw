package com.company;

public class Truck extends Transport {
        public int TransportedCargo;
        private static double FuelPrice  = 48.90;
        private  static double FuelСonsumption = 12;

        public double CalcluateGCM()
        {
                return Mileage / FuelСonsumption * FuelPrice;
        }

}
