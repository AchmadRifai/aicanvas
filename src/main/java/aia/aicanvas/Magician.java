package aia.aicanvas;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * @author AchmadRifai
 * class Magician adalah class yang akan mengeksekusi spell serta membuat dan menggambar canvas
 */
public class Magician {

	private Canvas bg;
	private List<Line> garis2;
	private List<Point> warna;
	private List<Rect> kotaks;

	/**
	 * construktor awak untuk canvas, garis - garis, titik - titik warna dan kotak - kotak
	 */
	public Magician() {
		super();
		bg = null;
		garis2 = new LinkedList<Line>();
		warna = new LinkedList<Point>();
		kotaks = new LinkedList<Rect>();
	}

	@Override
	public String toString() {
		String s = "";
		if (bg != null) {
			CharMatriks cm = new CharMatriks(bg.toString());
			for (Line garis : garis2) fillLine(cm, garis);
			for (Rect kotak : kotaks) fillRect(cm, kotak);
			for (Point p : warna) cm.set(p.getCol(), p.getY().longValue(), p.getX().longValue());
			s = cm.toString();
		} return s;
	}

	/**
	 * @param cm = Matriks tiap karakter yang akan disisipi sebuah Rect
	 * @param kotak = Object Rect yang akan disisipkan
	 */
	private void fillRect(CharMatriks cm, Rect kotak) {
		for (Line garis : kotak.borderLines()) fillLine(cm, garis);
	}

	/**
	 * @param cm = Matriks tiap karakter yang akan disisipi sebuah Line
	 * @param garis = Object Line yang akan disisipkan
	 */
	private void fillLine(CharMatriks cm, Line garis) {
		for (BigInteger y = garis.getTop(); 1 > y.compareTo(garis.getBottom()); y = y.add(BigInteger.ONE))
			for (BigInteger x = garis.getLeft(); 1 > x.compareTo(garis.getRight()); x = x.add(BigInteger.ONE))
				cm.set('x', y.longValue(), x.longValue());
	}

	/**
	 * @param s = spell yang akan dijalankan
	 * @throws SpellException = akan muncul jika spell bermasalah
	 * @throws NumberFormatException = akan muncul jika sebuah string gagal diparser ke sebuah BigInteger
	 */
	public void spelling(String s) throws SpellException, NumberFormatException {
		if ("".equals(s)) return;
		if (s.equals("Q") || s.equals("q")) {
			System.out.println("Bye!");
			System.gc();
			System.exit(0);
		} if (bg == null) jikaTanpaBG(s);
		else query(s);
	}

	/**
	 * @param s = spell yang telah didefinisikan
	 * @throws SpellException = akan muncul jika ada object selain Canvas yang gagal dibuat
	 * @throws NumberFormatException = akan muncul jika ada string yang gagal diparsing
	 */
	private void query(String s) throws SpellException, NumberFormatException {
		String[]sa = s.split(" ");
		if ((sa[0].equals("C") || sa[0].equals("c")) && 3 == sa.length) bgBaru(sa);
		else if (5 == sa.length && (sa[0].equals("L") || sa[0].equals("l"))) newLine(sa);
		else if (5 == sa.length && (sa[0].equals("R") || sa[0].equals("r"))) newRect(sa);
		else if (4 == sa.length && (sa[0].equals("B") || sa[0].equals("b"))) newBucket(sa);
		else throw new SpellException("Please don't use unknown spell");
	}

	/**
	 * @param sa = string array yang akan digunakan untuk membuat Point baru
	 * @throws SpellException = akan muncul jika Point gagal dibuat
	 * @throws NumberFormatException = akan muncul jika ada elemen sa yang gagal diparsing
	 */
	private void newBucket(String[] sa) throws SpellException, NumberFormatException {
		fillPoint(new Point(new BigInteger(sa[1]), new BigInteger(sa[2]), sa[3].charAt(0)));
	}

	/**
	 * @param cm = peta karakter yang tersedia
	 * @param p = Point pangkal sebar
	 * @throws SpellException = akan muncul jika ada subPoint yang gagal dibuat
	 */
	private void through(CharMatriks cm, Point p) throws SpellException {
		if (' ' != cm.get(p.getY().longValue(), p.getX().longValue())) {
			fillPoint(new Point(p.getX(), p.getY().subtract(BigInteger.ONE), p.getCol()));
			fillPoint(new Point(p.getX(), p.getY().add(BigInteger.ONE), p.getCol()));
			fillPoint(new Point(p.getX().subtract(BigInteger.ONE), p.getY(), p.getCol()));
			fillPoint(new Point(p.getX().add(BigInteger.ONE), p.getY(), p.getCol()));
		}
	}

	/**
	 * @param p = Point yang akan disimpan
	 * @throws SpellException = akan muncul jika ada subPoint yang gagal dibuat
	 */
	private void fillPoint(Point p) throws SpellException {
		CharMatriks cm = new CharMatriks(toString());
		if (' ' == cm.get(p.getY().longValue(), p.getX().longValue())) {
			warna.add(p);
			through(new CharMatriks(toString()), p);
		}
	}

	/**
	 * @param sa = string array yang akan digunakan untuk membuat Rect baru
	 * @throws SpellException = akan muncul jika rect tidak bisa dibuat
	 * @throws NumberFormatException = akan muncul jika sebuah string gagal diparsing
	 */
	private void newRect(String[] sa) throws SpellException, NumberFormatException {
		kotaks.add(new Rect(new BigInteger(sa[1]), new BigInteger(sa[2]), new BigInteger(sa[3]), new BigInteger(sa[4])));
	}

	/**
	 * @param sa = string array yang akan digunakan untuk membuat Line baru
	 * @throws SpellException = akan muncul jika Line tidak bisa dibuat
	 * @throws NumberFormatException = akan muncul jika sebuah string gagal diparsing
	 */
	private void newLine(String[] sa) throws SpellException, NumberFormatException {
		garis2.add(new Line(new BigInteger(sa[1]), new BigInteger(sa[2]), new BigInteger(sa[3]), new BigInteger(sa[4])));
	}

	/**
	 * @param s = spell yang telah didefinisikan
	 * @throws SpellException = Akan muncul jika canvas tidak bisa dibuat
	 * @throws NumberFormatException = Akan muncul jika sebuah string gagal diparsing
	 */
	private void jikaTanpaBG(String s) throws SpellException, NumberFormatException {
		String[]sa = s.split(" ");
		if ((sa[0].equals("C") || sa[0].equals("c")) && 3 == sa.length) {
			bgBaru(sa);
		} else throw new SpellException("Please create the canvas first");
	}

	/**
	 * @param sa = string array yang akan digunakan untuk membuat Canvas baru 
	 * @throws SpellException = Akan muncul jika Canvas tidak bisa dibuat
	 * @throws NumberFormatException = Akan muncul jika sebuah string gagal diparsing
	 */
	private void bgBaru(String[] sa) throws SpellException, NumberFormatException {
		bg = new Canvas(new BigInteger(sa[1]), new BigInteger(sa[2]));
		garis2.clear();
		warna.clear();
		kotaks.clear();
	}

}
