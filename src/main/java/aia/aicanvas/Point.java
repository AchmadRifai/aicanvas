package aia.aicanvas;

import java.math.BigInteger;

/**
 * @author AchmadRifai
 * class Point adalah digunakan untuk menggambar sebuah titik dengan warna yang fleksibel
 */
public class Point {

	private BigInteger x, y;
	private char col;

	/**
	 * @param x = indeks horizontal
	 * @param y = indeks vertikal
	 * @param col = warna yang akan dipakai (diwakili dengan sebuah karakter)
	 * @throws SpellException = akan muncul jika indeks tidak memenuhi syarat
	 */
	public Point(BigInteger x, BigInteger y, char col) throws SpellException {
		super();

		validasi(x, y);

		this.x = x;
		this.y = y;
		this.col = col;
	}

	/**
	 * @param x2 = indeks horizontal yang akan disimpan
	 * @param y2 = indeks vertical yang akan disimpan
	 * @throws SpellException = akan muncul jika tiap indeks kurang dari 0
	 */
	private void validasi(BigInteger x2, BigInteger y2) throws SpellException {
		if (x2.compareTo(BigInteger.ZERO) == -1)
			throw new SpellException("X must be positive");

		if (y2.compareTo(BigInteger.ZERO) == -1)
			throw new SpellException("Y must be positive");
	}

	/**
	 * @return col
	 */
	public char getCol() {
		return col;
	}

	/**
	 * @return x
	 */
	public BigInteger getX() {
		return x;
	}

	/**
	 * @return y
	 */
	public BigInteger getY() {
		return y;
	}

}
