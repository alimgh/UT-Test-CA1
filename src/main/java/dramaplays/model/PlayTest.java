package dramaplays.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayTest {

    @Test
    void testPlay() {
        Play play = new Play("Hamlet", "tragedy");
        assertEquals("Hamlet", play.name);
        assertEquals("tragedy", play.type);
    }

    @Test
    void testPlayEquals() {
        Play play1 = new Play("Hamlet", "tragedy");
        Play play2 = new Play("Hamlet", "tragedy");
        assertEquals(play1, play2);
    }

    @Test
    void testPlayNotEquals() {
        Play play1 = new Play("Hamlet", "tragedy");
        Play play2 = new Play("Othello", "tragedy");
        assertNotEquals(play1, play2);
    }

    @Test
    void nullName() {
        assertThrows(NullPointerException.class, () -> new Play(null, "tragedy"));
        assertThrows(NullPointerException.class, () -> new Play("Hamlet", null));
    }

}