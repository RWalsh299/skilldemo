
import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.*;
import org.junit.Test;


public class JUnitFile extends MarkdownParseSkill {   


@Test
public void file1() throws IOException{
    ArrayList<String> testArr = new ArrayList<>();
    testArr.add("https://github.com/RWalsh299.com");

    Path fileName = Path.of("test-file.md");
    String content = Files.readString(fileName);
    ArrayList<String> links = getLinks(content);
    
    assertEquals(testArr,links);
    }
}
