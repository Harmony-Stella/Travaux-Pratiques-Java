package TP2;

import java.util.*;

public class Pair4<X,Y> {
	private X fst;
	private Y snd;
	
	public X getFst() {
		return fst;
	}
	public void setFst(X fst) {
		this.fst = fst;
	}
	public Y getSnd() {
		return snd;
	}
	public void setSnd(Y snd) {
		this.snd = snd;
	}
	
	public Pair4(X fst, Y snd) {
		super();
		this.fst = fst;
		this.snd = snd;
	}
	
	public static <X extends Number , Y extends Number> double somme(Pair4<X,Y> pair) {
	    double somme = pair.getFst().doubleValue() + pair.getSnd().doubleValue();
	    return somme;
	}
//Question 5
	//Première methode
	public static <X extends Number> double[] sumPair(Collection<Pair4<X,X >> pairs) {
	    double[] sommes = new double[pairs.size()];
	    int i = 0;
	    for (Pair4<X, X> pair : pairs) {
	        sommes[i] = somme(pair);
	        i++;
	    }
	    return sommes;
	}
	
	
	//Deuxième methode
	public static double[] sumPairs(Collection<Pair4<? extends Number, ? extends Number>> pairs) {
	    double[] sums = new double[pairs.size()];
	    int i = 0;
	    for (Pair4<? extends Number, ? extends Number> pair : pairs) {
	        sums[i] = somme(pair);
	        i++;
	    }
	    return sums;
	}
	
	public static void main(String[] args) {
        Pair4<Integer, Integer> pair1 = new Pair4<>(2, 3);
        Pair4<Double, Double> pair2 = new Pair4<>(1.5, 2.5);
        Pair4<Long, Long> pair3 = new Pair4<>(1000000L, 2000000L);

        // Test de la méthode somme
        System.out.println(Pair4.somme(pair1)); // Résultat : 5.0
        System.out.println(Pair4.somme(pair2)); // Résultat : 4.0
        System.out.println(Pair4.somme(pair3)); // Résultat : 3000000.0

        // Test de la méthode sumPair
        List<Pair4<Integer, Integer>> pairs = new ArrayList<>();
        pairs.add(pair1);
        pairs.add(new Pair4<>(-1, 7));
        pairs.add(new Pair4<>(10, -5));
        double[] sums1 = Pair4.sumPair(pairs);
        System.out.println(Arrays.toString(sums1)); // Résultat : [5.0, 6.0, 5.0]

        // Test de la méthode sumPairs
        Collection<Pair4<? extends Number, ? extends Number>> pairs2 = new ArrayList<>();
        pairs2.add(pair1);
        pairs2.add(pair2);
        pairs2.add(pair3);
        double[] sums2 = Pair4.sumPairs(pairs2);
        System.out.println(Arrays.toString(sums2)); // Résultat : [5.0, 4.0, 3000000.0]
    }

}
