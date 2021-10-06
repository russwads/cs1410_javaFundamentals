package phones;

/**
 * Dimensions on a phone, measured in height, width, and depth
 * @author Russell
 *
 */
public class Dimension {
	private double height;
	private double width;
	private double depth;
	
	/**
	 * Creates a dimension measurement for a phone
	 * @param h height
	 * @param w width
	 * @param d depth
	 */
	public Dimension(double h, double w, double d) {
		if (h < 1 || w < 1 || d < 1) {
			throw new IllegalArgumentException("The height, width, and depth of a dimension needs to be positive.");
		}
		else {
			height = Math.round(h * 10) / 10.0;
			width = Math.round(w * 10) / 10.0;
			depth = Math.round(d * 10) / 10.0;
		}
	}
	
	/**
	 * Returns the height of the phone
	 * @return
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * Returns the width of the phone
	 * @return
	 */
	public double getWidth() {
		return width;
	}
	/**
	 * Returns the depth of the phone
	 * @return
	 */
	public double getDepth() {
		return depth;
	}

	@Override
	public String toString() {
		return "(" + height + " x " + width + " x " + depth + ")";
	}
}
