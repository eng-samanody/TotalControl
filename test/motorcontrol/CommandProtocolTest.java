package motorcontrol;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandProtocolTest {

    @Test
    public void exposesMotorAndCarCommands() {
        assertEquals("C", CommandProtocol.CLOCKWISE);
        assertEquals("N", CommandProtocol.ANTI_CLOCKWISE);
        assertEquals("S", CommandProtocol.STOP);
        assertEquals("P", CommandProtocol.SPEED_PREFIX);
        assertEquals("F", CommandProtocol.FORWARD);
        assertEquals("B", CommandProtocol.BACKWARD);
        assertEquals("L", CommandProtocol.LEFT);
        assertEquals("R", CommandProtocol.RIGHT);
        assertEquals("H", CommandProtocol.HEAD_LIGHT);
        assertEquals("Z", CommandProtocol.RED_LIGHT);
        assertEquals("O", CommandProtocol.HORN);
    }

    @Test
    public void convertsSliderValueToRpm() {
        assertEquals(0, CommandProtocol.sliderValueToRpm(0));
        assertEquals(1200, CommandProtocol.sliderValueToRpm(50));
        assertEquals(2400, CommandProtocol.sliderValueToRpm(100));
    }

    @Test
    public void clampsRepeatIntervalToAvoidBusyLooping() {
        assertEquals(100, CommandProtocol.normalizeRepeatInterval(0));
        assertEquals(100, CommandProtocol.normalizeRepeatInterval(99));
        assertEquals(250, CommandProtocol.normalizeRepeatInterval(250));
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectsNegativeSliderValue() {
        CommandProtocol.sliderValueToRpm(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectsSliderValueOverOneHundred() {
        CommandProtocol.sliderValueToRpm(101);
    }
}
