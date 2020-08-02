package aia.aicanvas;

import java.math.BigInteger;

/**
 * @author AchmadRifai
 * class Canvas adalah medium pembatas untuk object dari class Line, Point dan Rect
 *
 */
public class Canvas {

	private final BigInteger width, height;

	/**
	 * @param width = lebar kanvas
	 * @param height = tinggi kanvas
	 * @throws SpellException = akan muncul jika width ataupun height bernilai kurang dari 1
	 */
	public Canvas(BigInteger width, BigInteger height) throws SpellException {
		super();
		if (0 == BigInteger.ZERO.compareTo(width) || 0 == BigInteger.ZERO.compareTo(height))
			throw new SpellException("Width or Height must be bigger than or same zero");
		this.width = width;
		this.height = height;
	}

	/**
	 * @return width
	 */
	public BigInteger getWidth() {
		return width;
	}

	/**
	 * @return height
	 */
	public BigInteger getHeight() {
		return height;
	}

	@Override
	public String toString() {
		String s = horizontal();
		for (BigInteger x = BigInteger.ZERO; 1 == height.compareTo(x); x = x.add(BigInteger.ONE)) {
			s += vertical();
		} s += horizontal();
		return s;
	}

	/**
	 * @return s
	 * menggambar garis tepi kanan dan kiri
	 */
	private String vertical() {
		String s = "|";
		BigInteger i = width.divide(BigInteger.ONE);
		while (1 == i.compareTo(BigInteger.ZERO)) {
			s += " ";
			i = i.subtract(BigInteger.ONE);
		} return s + "|\n";
	}

	/**
	 * @return s
	 * menggambar garis tepi atas dan bawah
	 */
	private String horizontal() {
		String s = "";
		for (BigInteger x = BigInteger.ZERO; 1 == width.add(BigInteger.valueOf(2)).compareTo(x); x = x.add(BigInteger.ONE)) s += "-";
		return s + "\n";
	}

}
