package motorcontrol;

/**
 * Serial command bytes expected by the motor/RC-car firmware.
 */
public final class CommandProtocol {

    public static final String CLOCKWISE = "C";
    public static final String ANTI_CLOCKWISE = "N";
    public static final String STOP = "S";
    public static final String SPEED_PREFIX = "P";
    public static final String FORWARD = "F";
    public static final String BACKWARD = "B";
    public static final String LEFT = "L";
    public static final String RIGHT = "R";
    public static final String HEAD_LIGHT = "H";
    public static final String RED_LIGHT = "Z";
    public static final String HORN = "O";

    private CommandProtocol() {
    }

    public static int sliderValueToRpm(int sliderValue) {
        if (sliderValue < 0 || sliderValue > 100) {
            throw new IllegalArgumentException("Slider value must be between 0 and 100");
        }
        return sliderValue * 24;
    }

    public static int normalizeRepeatInterval(int milliseconds) {
        return Math.max(100, milliseconds);
    }
}
