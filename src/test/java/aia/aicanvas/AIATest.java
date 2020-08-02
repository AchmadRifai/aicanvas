package aia.aicanvas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AIATest {

	@Test
	void coba() {
		Assertions.assertAll(()->{
			Magician m = new Magician();
			spell(m, "C 20 4");
			spell(m, "L 1 2 6 2");
			spell(m, "L 6 3 6 4");
			spell(m, "R 14 1 18 3");
			spell(m, "B 10 3 o");
		});
	}

	private void spell(Magician m, String string) throws NumberFormatException, SpellException {
		System.out.println("Spelling : \"" + string + "\"");
		m.spelling(string);
		System.out.println("" + m + "\n");
	}

}
