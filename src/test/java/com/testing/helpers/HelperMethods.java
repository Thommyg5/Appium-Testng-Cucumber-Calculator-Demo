package com.testing.helpers;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

import java.io.IOException;

public class HelperMethods {

    public static void useCommandLine(String ... cmdInput) throws IOException {
        CommandLine cl = new CommandLine(cmdInput[0]);
        for(int i = 1; i < cmdInput.length; i++) {
            cl.addArgument(cmdInput[i]);
        }
        DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.execute(cl,handler);
    }
}
