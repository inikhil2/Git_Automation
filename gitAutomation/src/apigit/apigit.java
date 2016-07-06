package apigit;
import com.qainfotech.gitAutomation.*;
import java.io.IOException;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class apigit {
@SuppressWarnings("deprecation")
public static void main(String a[]){
	try {
		loginPage lp= new loginPage();
		GitHub github = GitHub.connectUsingPassword(lp.user, lp.pass);
		
		GHRepository repo=github.createRepository("Test2", "Test", "abcd", true);
		System.out.println(repo.getUrl());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
