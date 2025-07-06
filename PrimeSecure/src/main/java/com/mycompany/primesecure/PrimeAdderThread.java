package com.mycompany.primesecure;

public class PrimeAdderThread extends Thread {
    private final PrimesList primesList;
    private final int numberToCheck;

    public PrimeAdderThread(PrimesList primesList, int numberToCheck) {
        this.primesList = primesList;
        this.numberToCheck = numberToCheck;
    }

    @Override
    public void run() {
        try {
            primesList.add(numberToCheck);
            System.out.println("Hilo " + this.getName() + ": Agregado " + numberToCheck + " a la lista de primos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Hilo " + this.getName() + ": " + numberToCheck + " no es primo (" + e.getMessage() + ")");
        }
    }
}