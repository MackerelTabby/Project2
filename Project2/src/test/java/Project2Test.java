import org.junit.Test;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.*;

public class Project2Test {

    @Test
    public void addition() throws Exception {

    }

    @Test
    public void addition1() throws Exception {
    NodeList<Integer> temp = new NodeList<>();
    //assertEquals(temp = addition(temp));
    }

    @Test
    public void save() throws Exception {
        FileOutputStream output = new FileOutputStream("result.bin");
        assertTrue(true);
    }

    @Test
    public void load() throws Exception {
        StringBuilder load = new StringBuilder("result.bin");
        ClassLoader classLoader = getClass().getClassLoader();
        assertTrue(true);
    }

}