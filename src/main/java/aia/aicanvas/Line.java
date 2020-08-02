package aia.aicanvas;

import java.math.BigInteger;

/**
 * @author AchmadRifai
 * class Line digunakan untuk menggambar sebuah garis pada Canvas
 */
public class Line {

	private BigInteger left, top, right, bottom;

	/**
	 * @param leftleft adalah batas kiri dari Line
	 * @param top adalah batas atas dari Line
	 * @param right adalah batas kanan dari Line
	 * @param bottom adalah batas bawah dari Line
	 * @throws SpellException jika ada kesalahan ukuran dan index sebuah Line
	 */
	public Line(BigInteger left, BigInteger top, BigInteger right, BigInteger bottom) throws SpellException {
		super();

		setLeft(left);
		setTop(top);
		setRight(right);
		setBottom(bottom);

		cekPos(left, 'l');
		cekPos(top, 't');
		cekPos(right, 'r');
		cekPos(bottom, 'b');
	}

	/**
	 * @return left
	 * mengambil batas kiri dari Line ini
	 */
	public BigInteger getLeft() {
		return left;
	}

	/**
	 * @param leftbertujuan untuk menentukan batas kiri Line ini
	 * @throws SpellException untuk menvalidasi apakah param masih bisa diterima
	 */
	public void setLeft(BigInteger left) throws SpellException {
		cekPos(left, 'l');
		this.left = left;
	}

	/**
	 * @return top
	 * mengambil batas atas dari Line ini
	 */
	public BigInteger getTop() {
		return top;
	}

	/**
	 * @param topbertujuan untuk menentukan batas atas Line ini
	 * @throws SpellException untuk menvalidasi apakah param masih bisa diterima
	 */
	public void setTop(BigInteger top) throws SpellException {
		cekPos(top, 't');
		this.top = top;
	}

	/**
	 * @return right
	 * mengambil batas kanan dari Line ini
	 */
	public BigInteger getRight() {
		return right;
	}

	/**
	 * @param right bertujuan untuk menentukan batas kanan Line ini
	 * @throws SpellException untuk menvalidasi apakah param masih bisa diterima
	 */
	public void setRight(BigInteger right) throws SpellException {
		cekPos(right, 'r');
		this.right = right;
	}

	/**
	 * @return bottom
	 * mengambil batas bawah dari Line ini
	 */
	public BigInteger getBottom() {
		return bottom;
	}

	/**
	 * @param bottom bertujuan untuk menentukan batas bawah Line ini
	 * @throws SpellException untuk menvalidasi apakah param masih bisa diterima
	 */
	public void setBottom(BigInteger bottom) throws SpellException {
		cekPos(bottom, 'b');
		this.bottom = bottom;
	}

	/**
	 * @param v = nilai yang akan disimpan
	 * @param c = posisi nilai disimpan
	 * @throws SpellException = akan muncul jika v tidak memenuhi syarat
	 */
	private void cekPos(BigInteger v, char c) throws SpellException {
		if (left == null) return;
		if (top == null) return;
		if (right == null) return;
		if (bottom == null) return;

		if (c == 'l') {
			horizontalCheck(v, right);
		} else if (c == 't') {
			verticalCheck(v, bottom);
		} else if (c == 'r') {
			horizontalCheck(left, v);
		} else if (c == 'b') {
			verticalCheck(top, v);
		}
	}

	/**
	 * @param top2 = nilai top yang akan disimpan
	 * @param bottom2 = nilai bottom yang akan disimpan
	 * @throws SpellException = akan muncul jika bottom2 tidak lebih dari top2 atau Line membentuk titik 
	 */
	private void verticalCheck(BigInteger top2, BigInteger bottom2) throws SpellException {
		if (0 == left.compareTo(right)) {
			if (1 != bottom2.compareTo(top2))
				throw new SpellException("If left is right, bottom must be bigger than top");
		} else if (1 == right.compareTo(left)) {
			if (0 != bottom2.compareTo(top2))
				throw new SpellException("If right is bigger than left, bottom must be same top");
		}
	}

	/**
	 * @param left2 = nilai left yang akan disimpan
	 * @param right2 = nilai right yang akan disimpan
	 * @throws SpellException = akan muncul jika right2 tidak lebih dari left2 atau Line membentuk titik
	 */
	private void horizontalCheck(BigInteger left2, BigInteger right2) throws SpellException {
		if (0 == top.compareTo(bottom)) {
			if (1 != right2.compareTo(left2)) 
				throw new SpellException("If top is bottom, right must be bigger than left");
		} else if (1 == bottom.compareTo(top)) {
			if (0 != right2.compareTo(left2))
				throw new SpellException("If bottom is bigger than top, right must be same left");
		}
	}

}
