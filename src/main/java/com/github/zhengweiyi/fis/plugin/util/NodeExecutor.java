package com.github.zhengweiyi.fis.plugin.util;

import org.slf4j.Logger;

import java.io.File;
import java.util.List;

public final class NodeExecutor {
    private final ProcessExecutor executor;

    public NodeExecutor(File workingDirectory, List<String> arguments, Platform platform){
        final String node = workingDirectory + Utils.normalize("/node/node");
        this.executor = new ProcessExecutor(workingDirectory, Utils.prepend(node, arguments), platform);
    }

    public NodeExecutor(File workingDirectory, List<String> arguments, Platform platform, File fisBase){
        final String node = workingDirectory + Utils.normalize("/node/node");
        this.executor = new ProcessExecutor(fisBase, Utils.prepend(node, arguments), platform);
    }

    public String executeAndGetResult() throws ProcessExecutionException {
        return executor.executeAndGetResult();
    }

    public int executeAndRedirectOutput(final Logger logger) throws ProcessExecutionException {
        return executor.executeAndRedirectOutput(logger);
    }
}
