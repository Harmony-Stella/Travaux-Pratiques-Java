package TP2;

import java.util.*;

public class Pair3 <U extends Comparable<U>, V extends Comparable<V>> implements Comparable<Pair3<U, V>> {

	private U fst;
	private V snd;

	public Pair3(U fst, V snd) {
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
	
    @Override
    public int compareTo(Pair3<U, V> other) {
        int comparer = this.fst.compareTo(other.fst);
        if (comparer == 0) {
            comparer = this.snd.compareTo(other.snd);
        }
        return comparer;
    }
    
    public static <U extends Comparable<U>, V extends Comparable<V>> void sort(List<Pair3<U, V>> pairs) {
        Collections.sort(pairs);
    }
    

    public static void main(String[] args) {
        List<Pair3<Integer, String>> pairs = new ArrayList<>();
        pairs.add(new Pair3<>(5, "cinq"));
        pairs.add(new Pair3<>(1, "un"));
        pairs.add(new Pair3<>(3, "trois"));
        pairs.add(new Pair3<>(2, "deux"));

        System.out.println("Avant le tri: " + pairs);

        Pair3.sort(pairs);

        System.out.println("Après le tri: " + pairs);
    }

}
