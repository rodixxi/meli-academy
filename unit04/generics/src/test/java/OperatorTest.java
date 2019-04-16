import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    Integrante a0 = new Integrante("Aaa", "Bbb", "Ccc");
    Integrante a1 = new Integrante("Bbb", "Ccc", "Aaa");
    Integrante a2 = new Integrante("Ccc", "Aaa", "Bbb");
    Integrante[] integranteArray = new Integrante[3];
    Operator operator = new Operator();

    @BeforeEach
    void setUp() {
        integranteArray[0] = a0;
        integranteArray[1] = a1;
        integranteArray[2] = a2;
    }

    @Test
    void smallestIntegrante() {
        Integrante smallest = operator.smallest(integranteArray);

        assertEquals(a2, smallest);
    }

    @Test
    void biggestIntegrante() {
        Integrante biggest = operator.biggest(integranteArray);

        assertEquals(a1, biggest);
    }

    @Test
    void getIndexIntegranteExist() {
        int index = operator.index(integranteArray, a1);

        assertEquals(1, index);
    }

    @Test
    void getIndexIntegranteNotExist() {
        Integrante notInArray = new Integrante("Zzz", "Xxx", "Yyy");
        int index = operator.index(integranteArray, notInArray);

        assertEquals(-1, -1);
    }
}