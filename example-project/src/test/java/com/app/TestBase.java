package com.app;

import com.app.sharedutil.SharedUtil;
import configuration.CustomAssert;
import org.testng.annotations.BeforeClass;

import java.util.List;

public class TestBase extends SharedUtil {

    public List<String> errors;
    public CustomAssert $ = new CustomAssert();

    @BeforeClass
    public void setup() {
        initWebDriverWait(20);
    }

}
