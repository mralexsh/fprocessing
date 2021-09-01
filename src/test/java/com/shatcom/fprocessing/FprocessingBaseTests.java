package com.shatcom.fprocessing;

import org.apache.camel.CamelContext;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.Thread.sleep;

@Ignore
@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
public class FprocessingBaseTests {
    private static final String MOCKED_DIR = "/mocked-content/";

    @Value("${files.work_folder}")
    private String workFolder;

    @Value("${files.done_folder}")
    protected String doneFolder;

    @Value("${files.invalid_folder}")
    protected String invalidFolder;

    @Value("${files.error_postfix}")
    protected String errorPostfix;

    @Value("${files.marker_extension}")
    private String filesMarkerExtension;

    @Value("${files.extension}")
    private String filesExtension;

    @Autowired
    protected CamelContext camelContext;

    @BeforeClass
    public static void clear() throws IOException {
        FileUtils.deleteDirectory(new File("target/fprocessing"));
    }

    protected void genProcessingFile(String fileName) throws IOException {
        String c = IOUtils.toString(FprocessingBaseTests.class.getResourceAsStream(MOCKED_DIR + fileName),
                "UTF-8");
        BufferedWriter writer = new BufferedWriter(new FileWriter(workFolder + fileName));
        writer.write(c);
        writer.close();

        writer = new BufferedWriter(new FileWriter(workFolder + fileName.replaceAll(filesExtension, filesMarkerExtension)));
        writer.write("");
        writer.close();
    }

    protected void wait(int milliseconds) {
        try {
            sleep(milliseconds);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }



}
