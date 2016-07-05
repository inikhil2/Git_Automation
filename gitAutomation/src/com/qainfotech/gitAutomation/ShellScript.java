package com.qainfotech.gitAutomation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ShellScript {

	public File file;
	public FileWriter fw;
	public PrintWriter write;
	loginPage log;
	repositoryFinal rpl;
	String sys;
	Process p;
	
	public void createShellFile() throws IOException{
		file = new File("executor.sh");
		file.createNewFile();
	    file.setExecutable(true);
	    file.setWritable(true);		
	}
	public void execute( String cloneURL, String userN, String passW) throws IOException, InterruptedException{
		String url= cloneURL;
		String user= userN;
		String pass= passW;
		sys=System.getProperty("os.name");
		  if(sys.equalsIgnoreCase("Linux")){
		String push= "http://"+user+":"+pass+"@github.com/"+user+"/Test_Repository.git master";
		System.out.println(push);
		fw = new FileWriter(file.getAbsoluteFile());
		
		write = new PrintWriter(fw);
		//write.write("Hello");
		write.println("#!/bin/bash");
		write.println("cd ~");		
		write.println("git clone "+url );
		write.println("cd Test_Repository");
		write.println("gedit >'Hello'");
		write.println("git status");
		write.println("git add .");
		write.println("git commit -m'First Commit'");
		write.println("git status");
		write.println("git push "+push);
		write.println("git config --global credential.helper cache");
		write.close();
		  }
		  else
		  {
			 String sys_user=System.getProperty("user.name");
			    file = new File("executor.bat");
		    	file.createNewFile();
		        file.setExecutable(true);
		        file.setWritable(true);
		    	fw = new FileWriter(file.getAbsoluteFile());
		    	write = new PrintWriter(fw);
		    	write.println("C:");
		    	write.println("cd users");
		        write.println("cd "+sys_user);
		        write.println("cd Desktop");
		        write.println("git clone "+url);
		        write.println("cd Test_Repository");
		        write.println("type nul > hello");
		        write.println("git add .");
		        write.println("git status");
		        write.println("git commit -m 'First Commit'");
		        write.println("git status");
		        write.println("git push http://"+user+":"+pass+"@github.com/"+user+"/Test_Repository.git master");
		        write.close();	
		        p=new ProcessBuilder("./executor.bat").start();
		        p.waitFor();
		  }
	}
	}
