package ua.dfedorenko.classinfo.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import ua.dfedorenko.classinfo.ClassInfo;
import ua.dfedorenko.classinfo.test.examples.TestedExample;
import ua.dfedorenko.classinfo.test.examples.TestedExampleModifiersAndEmpty;

public class CommonTest {

	@Test
	public void testCreateByInstance() {
		TestedExample test = new TestedExample();
		ClassInfo info = new ClassInfo(test);
		assertEquals(test.getClass(), info.getSubject());
	}

	@Test
	public void testCreateByName() {
		ClassInfo info = null;
		try {
			info = new ClassInfo(
					"ua.dfedorenko.classinfo.test.examples.TestedExample");
			assertEquals("ua.dfedorenko.classinfo.test.examples.TestedExample",
					info.getClassname());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testCreateByClass() {
		ClassInfo info = new ClassInfo(TestedExample.class);
		assertEquals(TestedExample.class, info.getSubject());
	}

	@Test
	public void testModifiersClass() {
		ClassInfo info = new ClassInfo(TestedExample.class);
		assertEquals("public", info.getClassModifiers());
		info = new ClassInfo(TestedExampleModifiersAndEmpty.class);
		assertEquals("public abstract", info.getClassModifiers());
	}

	@Test
	public void testParents() {
		ClassInfo info = new ClassInfo(TestedExample.class);
		assertEquals("java.lang.Object", info.getClassParent());
		info = new ClassInfo(TestedExampleModifiersAndEmpty.class);
		assertEquals("ua.dfedorenko.classinfo.test.examples.TestedExample",
				info.getClassParent());
	}

	@Test
	public void testImplements() {
		ClassInfo info = new ClassInfo(TestedExample.class);
		assertEquals("java.io.Serializable java.lang.Comparable",
				info.getClassInterfaces());
	}

	@Test
	public void testMethods() {
		ClassInfo info = new ClassInfo(TestedExample.class);
		String methods = "private java.lang.String robot()\n"
				+ "protected [Ljava.lang.String; robots()\n"
				+ "[[Ljava.lang.String; armyOfRobots()\n"
				+ "public static void add(int, double) throws java.io.IOException, java.lang.ArithmeticException\n"
				+ "public int compareTo(class java.lang.Object)";
		assertEquals(methods, info.getClassMethods());
		info = new ClassInfo(TestedExampleModifiersAndEmpty.class);
		assertEquals("", info.getClassMethods());
	}

	@Test
	public void testFields() {
		ClassInfo info = new ClassInfo(TestedExample.class);
		String fields = "int a\n" + "double b\n" + "private float c\n"
				+ "public java.lang.String d\n"
				+ "public static java.util.List e\n"
				+ "public static final int F\n"
				+ "protected java.lang.Boolean g";
		assertEquals(fields, info.getClassFields());
		info = new ClassInfo(TestedExampleModifiersAndEmpty.class);
		assertEquals("", info.getClassFields());
	}

}
