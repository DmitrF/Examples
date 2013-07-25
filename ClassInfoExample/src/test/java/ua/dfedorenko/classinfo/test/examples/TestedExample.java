package ua.dfedorenko.classinfo.test.examples;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings({ "serial", "rawtypes" })
public class TestedExample implements Serializable, Comparable {

	int a = 0;
	double b;
	private float c;
	public String d;
	public static List<Integer> e;
	public static final int F = 4894;
	protected Boolean g;

	public int compareTo(Object o) {

		return 0;
	}

	public static void add(int i, double j) throws IOException,
			ArithmeticException {

	}

	@SuppressWarnings("unused")
	private String robot() {
		return null;
	}

	protected String[] robots() {
		return null;
	}

	String[][] armyOfRobots() {
		return null;
	}

}
