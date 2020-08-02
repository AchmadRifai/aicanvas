package aia.aicanvas;

import java.io.Console;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Magician m = new Magician();
        Console c = System.console();
        if (c == null) {
        	System.out.println("Please using cmd or terminal");
        	return;
        } while (true) {
        	System.out.println("" + m);
        	System.out.print("enter command: ");
        	String spell = c.readLine(); try {
				m.spelling(spell);
			} catch (NumberFormatException | SpellException e) {
				e.printStackTrace();
			} c.flush();
        }
    }
}
