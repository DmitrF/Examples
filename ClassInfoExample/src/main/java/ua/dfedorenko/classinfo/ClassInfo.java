package ua.dfedorenko.classinfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class ClassInfo {

	private Class<?> subject;

	public ClassInfo(Class<?> subject) {
		this.subject = subject;
	}

	public ClassInfo(Object subject) {
		this(subject.getClass());
	}

	public ClassInfo(String classname) throws ClassNotFoundException {
		this(Class.forName(classname));
	}

	public String getClassModifiers() {
		int modifiers = subject.getModifiers();
		return returnModifiersStr(modifiers);
	}

	public Object getSubject() {
		return subject;
	}

	public String getClassname() {
		return subject.getName();
	}

	public String getClassParent() {
		return subject.getSuperclass().getName();
	}

	@SuppressWarnings("rawtypes")
	public String getClassInterfaces() {

		Class[] interfaces = subject.getInterfaces();

		StringBuffer interfacesStr = new StringBuffer();
		for (Class cInterface : interfaces) {
			interfacesStr.append(cInterface.getName()).append(" ");
		}
		return interfacesStr.toString().trim();
	}

	public String getClassMethods() {
		StringBuilder methodsStr = new StringBuilder();
		Method[] methods = subject.getDeclaredMethods();

		for (Method method : methods) {
			StringBuilder methodStr = new StringBuilder();
			String modifiersStr = returnModifiersStr(method.getModifiers());
			if (modifiersStr.length() != 0) {
				modifiersStr += " ";
			}
			methodStr.append(modifiersStr)
					.append(method.getReturnType().getName()).append(" ")
					.append(method.getName()).append("(")
					.append(returnParametersStr(method)).append(")")
					.append(returnThrowsStr(method));
			methodsStr.append(methodStr.toString().trim()).append("\n");
		}

		return methodsStr.toString().trim();
	}

	public String getClassFields() {
		StringBuilder fieldsStr = new StringBuilder();
		for (Field field : subject.getDeclaredFields()) {
			String modifiersStr = returnModifiersStr(field.getModifiers());
			if (modifiersStr.length() != 0) {
				modifiersStr += " ";
			}
			fieldsStr.append(modifiersStr).append(field.getType().getName())
					.append(" ").append(field.getName()).append("\n");

		}
		return fieldsStr.toString().trim();
	}

	private String returnModifiersStr(int modifiers) {

		return Modifier.toString(modifiers);
	}

	private String returnThrowsStr(Method method) {
		@SuppressWarnings("rawtypes")
		Class[] exeptions = method.getExceptionTypes();
		if (exeptions.length == 0)
			return "";

		StringBuilder throwsStr = new StringBuilder(" throws ");
		for (Class<?> exeption : exeptions) {
			throwsStr.append(exeption.getName()).append(", ");
		}
		throwsStr.delete(throwsStr.length() - 2, throwsStr.length());
		return throwsStr.toString();
	}

	private String returnParametersStr(Method method) {
		Type[] parameters = method.getGenericParameterTypes();
		if (parameters.length == 0)
			return "";

		StringBuilder parametersStr = new StringBuilder();
		for (Type parameter : parameters) {
			parametersStr.append(parameter.toString()).append(", ");
		}
		parametersStr
				.delete(parametersStr.length() - 2, parametersStr.length());
		return parametersStr.toString().trim();

	}

}
