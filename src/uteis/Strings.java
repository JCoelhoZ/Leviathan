package uteis;

import java.util.Objects;

public class Strings {

	public static boolean isNullOrEmpty(String aString){
		return Objects.isNull(aString) || aString.isEmpty();
	}
	public static boolean isEqual(String aString, String anotherString){
		return Objects.equals(aString, anotherString);
	}
}
