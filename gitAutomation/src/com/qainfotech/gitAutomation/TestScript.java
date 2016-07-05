package com.qainfotech.gitAutomation;

import java.io.IOException;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

public class TestScript {
	public void exec() {
		DefaultExecutor oDefaultExecutor = new DefaultExecutor();
		CommandLine oCmdLine = new CommandLine("./executor.sh");
		try {
			oDefaultExecutor.execute(oCmdLine);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}