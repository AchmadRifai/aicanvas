package aia.aicanvas;

/**
 * @author AchmadRifai
 *
 */
public class SpellException extends Exception {

	/**
	 * SpellException digunakan untuk menangkap error ketika membuat spell object(Canvas, Rect, Line, Point)
	 * SpellException juga digunakan untuk class Magician sebagai penangkap error ketika user memasukkan spell
	 */
	private static final long serialVersionUID = 5453962066055179072L;

	public SpellException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
