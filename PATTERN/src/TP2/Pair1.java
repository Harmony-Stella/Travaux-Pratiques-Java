package TP2;

import java.util.*;
//1
public class Pair1 <X, Y>{

	private X fst;
	private Y snd;
	
	public Pair1(X fst, Y snd) {
		super();
		this.fst = fst;
		this.snd = snd;
	}
	
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
	

    public static void main(String[] args) {
        Pair2<Integer, Integer> paire1 = new Pair2<>(2, 3);
        Pair2<String, String> paire2 = new Pair2<>("bonjour", "monde");

        System.out.println("Paire1 : " + paire1.getFst() + " " + paire1.getSnd());
        System.out.println("Max de Paire1 : " + Pair2.max(paire1));
        System.out.println("Paire2 : " + paire2.getFst() + " " + paire2.getSnd());
        //System.out.println("Max de Paire2 : " + Pair2.max(paire2)); // cette ligne ne compilera pas
    }

}
