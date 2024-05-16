package dramaplays.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {

    @Test
    void null_values() {
        Invoice invoice = new Invoice(null, null);
        assertThrows(NullPointerException.class, () -> invoice.performances.listIterator());
        assertNotEquals(null, invoice.customer);
    }


    public static void main(String[] args) {
        Invoice invoice = new Invoice("customer", null);
        invoice.performances.listIterator();
    }
}