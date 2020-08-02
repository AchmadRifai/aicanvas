package aia.aicanvas;

import java.math.BigInteger;
import java.util.List;

/**
 * @author AchmadRifai
 * class Rect digunakan untuk menggambar sebuah persegi panjang pada Canvas
 */
public class Rect {

	private BigInteger left, top, right, bottom;

	/**
	 * @param left adalah batas kiri dari Rect
	 * @param top adalah batas atas dari Rect
	 * @param right adalah batas kanan dari Rect
	 * @param bottom adalah batas bawah dari Rect
	 * @throws SpellException jika ada kesalahan ukuran dan index sebuah Rect
	 */
	public Rect(BigInteger left, BigInteger top, BigInteger right, BigInteger bottom) throws SpellException {
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
	 * mengambil batas kiri dari Rect ini
	 */
	public BigInteger getLeft() {
		return left;
	}

	/**
	 * @param left bertujuan untuk menentukan batas kiri Rect ini
	 * @throws SpellException untuk menvalidasi apakah param masih bisa diterima
	 */
	public void setLeft(BigInteger left) throws SpellException {
		cekPos(left, 'l');
		this.left = left;
	}

	/**
	 * @return top
	 * mengambil batas atas dari Rect ini
	 */
	public BigInteger getTop() {
		return top;
	}

	/**
	 * @param top bertujuan untuk menentukan batas atas Rect ini
	 * @throws SpellException untuk menvalidasi apakah param masih bisa diterima
	 */
	public void setTop(BigInteger top) throws SpellException {
		cekPos(top, 't');
		this.top = top;
	}

	/**
	 * @return right
	 * mengambil batas kanan dari Rect ini
	 */
	public BigInteger getRight() {
		return right;
	}

	/**
	 * @param right bertujuan untuk menentukan batas kanan Rect ini
	 * @throws SpellException untuk menvalidasi apakah param masih bisa diterima
	 */
	public void setRight(BigInteger right) throws SpellException {
		cekPos(right, 'r');
		this.right = right;
	}

	/**
	 * @return bottom
	 * mengambil batas bawah dari Rect ini
	 */
	public BigInteger getBottom() {
		return bottom;
	}

	/**
	 * @param bottom bertujuan untuk menentukan batas bawah Rect ini
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
	 * @throws SpellException = akan muncul jika bottom2 tidak lebih dari top2
	 */
	private void verticalCheck(BigInteger top2, BigInteger bottom2) throws SpellException {
		if (1 > bottom2.compareTo(top2))
			throw new SpellException("Bottom must be bigger than top");
	}

	/**
	 * @param left2 = nilai left yang akan disimpan
	 * @param right2 = nilai right yang akan disimpan
	 * @throws SpellException = akan muncul jika right2 tidak lebih dari left2
	 */
	private void horizontalCheck(BigInteger left2, BigInteger right2) throws SpellException {
		if (1 > right2.compareTo(left2))
			throw new SpellException("Right must be bigger than left");
	}

	/**
	 * @return list line dari tepi Rect ini
	 */
	public List<Line> borderLines() {
		List<Line> l = new java.util.LinkedList<>(); try {
			l.add(new Line(left, top, right, top));
			l.add(new Line(left, bottom, right, bottom));
			l.add(new Line(left, top, left, bottom));
			l.add(new Line(right, top, right, bottom));
		} catch (SpellException e) {
			e.printStackTrace();
		} return l;
	}

}
