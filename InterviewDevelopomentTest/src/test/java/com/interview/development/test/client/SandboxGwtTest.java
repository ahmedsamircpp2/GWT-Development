package com.interview.development.test.client;

import com.google.gwt.junit.client.GWTTestCase;

public class SandboxGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "com.interview.development.test.InterviewDevelopomentTest";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}