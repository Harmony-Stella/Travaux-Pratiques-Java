package TP2;

import java.util.*;

public class Pair2 <U,V>{

	private U fst;
	private V snd;
	
	public Pair2(U fst, V snd) {
		super();
		this.fst = fst;
		this.snd = snd;
	}

	public U getFst() {
		return fst;
	}

	public void setFst(U fst) {
		this.fst = fst;
	}

	public V getSnd() {
		return snd;
	}

	public void setSnd(V snd) {
		this.snd = snd;
	}

	public static <U extends Comparable<U>> U max(Pair2<U, U> pair) {
	    if (pair.getFst().compareTo(pair.getSnd()) >= 0) {
	        return pair.getFst();
	    } else {
	        return pair.getSnd();
	    }
	}
	
    public static void main(String[] args) {
        Pair2<Integer, Integer> paire1 = new Pair2<>(2, 3);
        Pair2<String, String> paire2 = new Pair2<>("bonjour", "monde");

        System.out.println("Paire1 : " + paire1.getFst() + " " + paire1.getSnd());
        System.out.println("Max de Paire1 : " + Pair2.max(paire1));
        //System.out.println("Paire2 : " + paire2.getFst() + " " + paire2.getSnd());
        //System.out.println("Max de Paire2 : " + Pair2.max(paire2)); // cette ligne ne compilera pas

        Pair2<Double, Double> paire3 = new Pair2<>(3.5, 1.2);
        System.out.println("Paire3 : " + paire3.getFst() + " " + paire3.getSnd());
        System.out.println("Max de Paire3 : " + Pair2.max(paire3));
    }
	
}
