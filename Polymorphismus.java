
/**
  * Polymorphismus ("Mehrfoermig") erlaubt Methoden mit dem gleichen Namen,
  * die sich lediglich in ihrem Input unterscheiden.
  * Bei Aufruf wird die Methode benutzt, die von der Vererbunghierachie der
  * Parameter moeglichst nah an den gegebenen Input liegen.
  *
  * Gibt es zum Aufruf keine passende Methode kommt es zu einem Kompilierfehler.
*/
public class Polymorphismus {
	public static void main(String[] args) {
		Calculator c = new Calculator();
		double test = c.add(1,2);
		System.out.println(test);
		System.out.println(c.add(1,2));
		System.out.println(c.add(1.0,2));
		System.out.println(c.add("1","2"));
		System.out.println(c.add(1,2,3));
		System.out.println(c.add(1F,2F));
	}

	/**
	  * Calculator ist "nested class" - Klasse in Klasse.
	  * Sie enthaelt die polymorphe Methode add.
	*/
	static class Calculator {

		public String add(String a, String b) {
			System.out.println("add mit String");
			return a+b;
		}

		public double add(double a, double b) {
			System.out.println("add mit double");
			return a+b;
		}

		public int add(int a, int b) {
			System.out.println("add mit int");
			return a+b;
		}

		// funktioniert nicht weil add(int a, int b) schon existiert unabhaengig vom return Typ
		// public double add(int a, int b) {
		// 	System.out.println("add mit int aber double return");
		// }

		public double add(double a, double b, int n) {
			System.out.println("add b zu a n mal");
			while(n-- > 0)
				a += b;
			return a;
		}

		/**
		* Wird aufgerufen wenn kein spezifischerer Typ angegeben ist.
		* Da alles von Object abgeleitet ist, kann alles zu Object konvertiert werden.
		* Das Konvertierte verliert dadurch Eigenschaften, hier ist a+b nicht mehr moeglich.
		* Fuer konvertieren benutzt man im Englischen "to cast".
		*/
		public int add(Object a, Object b) {
			System.out.println("add mit Object");
			// nicht implementiert, lediglich als Beispiel hier
			return 0;
		}
	}
}
