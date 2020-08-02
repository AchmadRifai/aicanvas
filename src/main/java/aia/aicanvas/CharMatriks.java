package aia.aicanvas;

import java.util.LinkedList;
import java.util.List;

/**
 * @author AchmadRifai
 * class CharMatriks adalah class pembantu yang akan memecah string berbentuk matriks
 */

public class CharMatriks {

	/**
	 * l akan menyimpan setiap karakter yang dipecah dari sebuah baris
	 * dan tiap baris berasal dari matriks string
	 */
	private List<List<Character>> l;

	/**
	 * @param s
	 * s adalah matriks string from Canvas atau Magician
	 * dan s akan dipecah dan dianalisa
	 */
	public CharMatriks(String s) {
		super();
		l = new LinkedList<>();
		analyze(s.split("\n"));
	}

	/**
	 * @param y = indeks vertikal
	 * @param x = indeks horizontal
	 * @return nilai[y, x]
	 */
	public char get(long y, long x) {
		char c = ' ';
		if (y < l.size()) {
			List<Character> lc = l.get((int) y);
			if (x < lc.size()) c = lc.get((int) x);
		} return c;
	}

	/**
	 * @param c = karakter yang akan disimpan
	 * @param y = indeks vertikal
	 * @param x = indeks horizontal
	 * c akan disimpan jika nilai[y, x] adalah spasi
	 */
	public void set(char c, long y, long x) {
		if (y < l.size()) {
			List<Character> lc = l.get((int) y);
			if (x < lc.size()) {
				if (' ' == lc.get((int) x)) lc.set((int) x, c);
			}
		}
	}

	/**
	 * @param split adalah matriks string yang dipecah tiap baris
	 * dan tiap baris akan dipecah tiap karakter
	 * dan tiap karakter akan disimpan di l
	 */
	private void analyze(String[] split) {
		for (String s: split) {
			List<Character> lc = new LinkedList<>();
			for (char c : s.toCharArray())
				lc.add(c);
			l.add(lc);
		}
	}

	@Override
	public String toString() {
		String s = "";
		for (List<Character> lc : l) {
			for (Character c : lc)
				s += c;
			s += "\n";
		}
		return s;
	}

	/**
	 * @return l
	 */
	public List<List<Character>> getL() {
		return l;
	}

}
