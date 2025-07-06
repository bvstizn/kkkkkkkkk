package com.mycompany.primesecure;

import java.util.ArrayList;

public class PrimeList extends ArrayList<Integer> {
    // Verifica si un número es primo
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Sobrescribe el método add para que sólo acepte números primos
    @Override
    public boolean add(Integer n) {
        if (!isPrime(n)) {
            throw new IllegalArgumentException(n + " no es un número primo.");
        }
        return super.add(n);
    }

    // Sobrescribe remove para asegurarse de que sólo se eliminen primos (opcional)
    @Override
    public boolean remove(Object o) {
        if (o instanceof Integer) {
            Integer n = (Integer) o;
            if (!isPrime(n)) {
                throw new IllegalArgumentException(n + " no es un número primo.");
            }
        }
        return super.remove(o);
    }

    // Devuelve la cantidad de números primos en la lista
    public int getPrimesCount() {
        return this.size();
    }
}