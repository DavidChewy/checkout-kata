package solution.models;

import org.junit.jupiter.api.Test;
import solution.SKUNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class SKUTest {

    @Test
    void fromName() throws SKUNotFoundException {
        SKU.fromName("A");
    }

    @Test
    void fromName_NotFound() {
        assertThrows(SKUNotFoundException.class, () -> {
            SKU.fromName("Item Not Exist");
        });
    }
}