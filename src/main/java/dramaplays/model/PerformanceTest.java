package dramaplays.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerformanceTest {

    @Test
    void null_values() {
        Performance performance = new Performance(null, 0);
        assertNotEquals(null, performance.playID);
    }

    @Test
    void negative_audience() {
        assertThrows(IllegalArgumentException.class, () -> new Performance("playID", -1));
    }

    @Test
    void empty_playID() {
        assertThrows(IllegalArgumentException.class, () -> new Performance("", 0));
    }
}