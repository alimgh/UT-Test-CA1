package dramaplays;

import dramaplays.model.Invoice;
import dramaplays.model.Performance;
import dramaplays.model.Play;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FactorPrinterTest {

    @Test
    void print() {
        // Given
        FactorPrinter factorPrinter = new FactorPrinter();
        Invoice invoice = new Invoice("BigCo", List.of(new Performance[]{
                new Performance("hamlet", 55),
                new Performance("as-like", 35),
                new Performance("othello", 40)
        }));

        Map<String, Play> plays = new HashMap<>();
        plays.put("hamlet", new Play("hamlet", "tragedy"));
        plays.put("as-like", new Play("as-like", "comedy"));
        plays.put("othello", new Play("othello", "tragedy"));

        // When
        String result = factorPrinter.print(invoice, plays);

        // Then
        assertEquals("Factor for BigCo\n" +
                "  hamlet: $650.00 (55 seats)\n" +
                "  as-like: $580.00 (35 seats)\n" +
                "  othello: $500.00 (40 seats)\n" +
                "Amount owed is $1,730.00\n" +
                "You earned 47 credits\n", result);
    }

    @Test
    void print_invalid_play_type() {
        // Given
        FactorPrinter factorPrinter = new FactorPrinter();
        Invoice invoice = new Invoice("BigCo", List.of(new Performance[]{
                new Performance("test", 30),
                new Performance("as-like", 20),
                new Performance("othello", 10)
        }));

        Map<String, Play> plays = new HashMap<>();
        plays.put("hamlet", new Play("test", "drama"));
        plays.put("as-like", new Play("as-like", "comedy"));
        plays.put("othello", new Play("othello", "tragedy"));

        // Then
        assertThrows(Error.class, () -> factorPrinter.print(invoice, plays));
    }

    @Test
    void print_audience() {
        // Given
        FactorPrinter factorPrinter = new FactorPrinter();
        Invoice invoice = new Invoice("BigCo", List.of(new Performance[]{
                new Performance("hamlet", 25),
                new Performance("as-like", -10000),
                new Performance("othello", 10)
        }));

        Map<String, Play> plays = new HashMap<>();
        plays.put("hamlet", new Play("hamlet", "tragedy"));
        plays.put("as-like", new Play("as-like", "comedy"));
        plays.put("othello", new Play("othello", "tragedy"));

        // Then
        assertThrows(IllegalArgumentException.class, () -> factorPrinter.print(invoice, plays));
    }

    @Test
    void invalid_playID() {
        // Given
        FactorPrinter factorPrinter = new FactorPrinter();
        Invoice invoice = new Invoice("BigCo", List.of(new Performance[]{
                new Performance("hamlet", 55),
                new Performance("as-like", 35),
                new Performance("othello", 40)
        }));

        Map<String, Play> plays = new HashMap<>();
        plays.put("as-like", new Play("as-like", "comedy"));
        plays.put("othello", new Play("othello", "tragedy"));

        // When
        String result = factorPrinter.print(invoice, plays);

        // Then
        assertThrows(IndexOutOfBoundsException.class, () -> factorPrinter.print(invoice, plays));
    }
}