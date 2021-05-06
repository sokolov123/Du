import org.junit.jupiter.api.Test;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CoreFileTest {

    @Test
    void coreFile() throws Exception{
        String[] s1 = {"src/test/file1"};
        CoreFile f1 = new CoreFile(s1);
        assertEquals(new File(s1[0]), f1.files[0]);
    }


    @Test
    void getLengthTest() throws Exception {
        assertEquals(1649535.0, new CoreFile(new String[]{}).getLength(new File("src/test/WarAndPies.txt")));
    }

    @Test
    void coreTest() throws Exception{
        CoreFile c = new CoreFile(new String[] {"src/test/file1"});
        assertEquals("5.4130859375", c.core(null, null, null)[0]);
        assertEquals("5.4130859375 KB", c.core(true, null, null)[0]);
        assertEquals("5.543 KB", c.core(true, true, true)[0]);
    }
}