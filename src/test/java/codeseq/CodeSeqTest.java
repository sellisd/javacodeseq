package codeseq;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class CodeSeqTest {
    
    @Test
    void testClassNameExtraction() throws IOException {
        // Use the current working directory
        Path currentDir = Paths.get("").toAbsolutePath();

        // Create a test Java file
        Path testFile = currentDir.resolve("TestClass.java");
        String testContent = 
            "public class TestClass {\n" +
            "    public void method1() { // a comment of a method\n" +
            "        System.out.println(\"Hello\");\n" +
            "    }\n" +
            "}\n";
        Files.writeString(testFile, testContent);

        // Create output file path
        Path outputFile = currentDir.resolve("output.tsv");
        
        // Run CodeSeq
        CodeSeq codeSeq = new CodeSeq();
        codeSeq.RootPath = currentDir.toString();
        codeSeq.outputFilePath = outputFile.toString();
        codeSeq.run();

        // Read and verify output
        assertTrue(Files.exists(outputFile), "Output file should be created");
        List<String> lines = Files.readAllLines(outputFile);
        
        // Write the output to a file for verification
        Path logFile = currentDir.resolve("test_output.log");
        Files.write(logFile, lines);

        // Verify header
        assertEquals("class\tclass_lines\tmethod\tmethod_lines", lines.get(0), "Header line should match expected format");
        
        // Verify content
        assertTrue(lines.stream().anyMatch(line -> line.startsWith("TestClass\t")), 
                  "Output should contain TestClass");
    }
}
