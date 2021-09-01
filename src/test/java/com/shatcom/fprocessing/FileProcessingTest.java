package com.shatcom.fprocessing;

import org.apache.commons.io.IOUtils;
import org.hamcrest.core.StringContains;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class FileProcessingTest extends FprocessingBaseTests {

    private static final int JOB_DELAY = 2500;

    @Test
    public void test_valid_input_file() throws Exception {
        String file = "validFile.json";
        genProcessingFile(file);
        wait(JOB_DELAY);
        File f = new File(doneFolder + file);
        assertTrue(f.exists());
        String c = IOUtils.toString(new FileInputStream(f),"UTF-8");
        assertThat(c, StringContains.containsString("\"workAddress\":\"testWorkAddress1\""));
    }

    @Test
    public void test_valid_input_file_with_no_work_address() throws Exception {
        String file = "noWorkAddressFile.json";
        genProcessingFile(file);
        wait(JOB_DELAY);
        File f = new File(doneFolder + file);
        assertTrue(f.exists());
        String c = IOUtils.toString(new FileInputStream(f),"UTF-8");
        assertThat(c, StringContains.containsString("\"workAddress\":null"));
    }

    @Test
    public void test_invalid_phone_code() throws Exception {
        String file = "invalidPhoneCodeFile.json";
        genProcessingFile(file);
        wait(JOB_DELAY);
        File f = new File(invalidFolder + file + "." + errorPostfix);
        assertTrue(f.exists());
        String c = IOUtils.toString(new FileInputStream(f),"UTF-8");
        assertThat(c, StringContains.containsString("Error occurred. Mobile phone code doesn't match work phone code."));
    }

    @Test
    public void test_invalid_schema1() throws Exception {
        String file = "invalidSchema1.json";
        genProcessingFile(file);
        wait(JOB_DELAY);
        File f = new File(invalidFolder + file + "." + errorPostfix);
        assertTrue(f.exists());
        String c = IOUtils.toString(new FileInputStream(f),"UTF-8");
        assertThat(c, StringContains.containsString("$.firstName: may only be 10 characters long"));
    }

    @Test
    public void test_invalid_schema2() throws Exception {
        String file = "invalidSchema2.json";
        genProcessingFile(file);
        wait(JOB_DELAY);
        File f = new File(invalidFolder + file + "." + errorPostfix);
        assertTrue(f.exists());
        String c = IOUtils.toString(new FileInputStream(f),"UTF-8");
        assertThat(c, StringContains.containsString("$.lastName: may only be 20 characters long"));
    }

    //TODO fix schema phone number
    //@Test
    public void test_invalid_schema3() throws Exception {
        String file = "invalidSchema3.json";
        genProcessingFile(file);
        wait(JOB_DELAY);
        File f = new File(invalidFolder + file + "." + errorPostfix);
        assertTrue(f.exists());
    }

    @Test
    public void test_invalid_schema4() throws Exception {
        String file = "invalidSchema4.json";
        genProcessingFile(file);
        wait(JOB_DELAY);
        File f = new File(invalidFolder + file + "." + errorPostfix);
        assertTrue(f.exists());
        String c = IOUtils.toString(new FileInputStream(f),"UTF-8");
        assertThat(c, StringContains.containsString("$.mobile: does not match the regex pattern "));
    }

    @Test
    public void test_invalid_schema5() throws Exception {
        String file = "invalidSchema5.json";
        genProcessingFile(file);
        wait(JOB_DELAY);
        File f = new File(invalidFolder + file + "." + errorPostfix);
        assertTrue(f.exists());
        String c = IOUtils.toString(new FileInputStream(f),"UTF-8");
        assertThat(c, StringContains.containsString("$.workPhone: does not match the regex pattern "));
    }

    @Test
    public void test_invalid_schema6() throws Exception {
        String file = "invalidSchema6.json";
        genProcessingFile(file);
        wait(JOB_DELAY);
        File f = new File(invalidFolder + file + "." + errorPostfix);
        assertTrue(f.exists());
        String c = IOUtils.toString(new FileInputStream(f),"UTF-8");
        assertThat(c, StringContains.containsString("$.mobile: does not match the regex pattern "));
    }

    @Test
    public void test_invalid_schema7() throws Exception {
        String file = "invalidSchema7.json";
        genProcessingFile(file);
        wait(JOB_DELAY);
        File f = new File(invalidFolder + file + "." + errorPostfix);
        assertTrue(f.exists());
        String c = IOUtils.toString(new FileInputStream(f),"UTF-8");
        assertThat(c, StringContains.containsString("$.email: does not match the email pattern ^\\S+@\\S+$"));

    }
}
