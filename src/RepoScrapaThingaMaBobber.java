import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by robertsg on 5/20/2016.
 **/

public class RepoScrapaThingaMaBobber {

    public static void main(String[] args) {
        RepoScrapaThingaMaBobber program = new RepoScrapaThingaMaBobber();
        program.retrieveUrl();
    }

    private void retrieveUrl() {
        //Todo Use this method to create a menu to retrieve multiple versions
        String url = "http://packages.ubuntu.com/xenial/allpackages";

        try {
            Document doc = Jsoup.connect(url).userAgent("Chrome").get();
            System.out.println(doc.title() +"\n");

            Elements repoPackages = doc.select("a[href] > dt");
            for (Element repoPackage : repoPackages) {
                System.out.print("\nPackage : " + repoPackage.attr("href") + " | ");
                System.out.println(repoPackage.attr("dl.dd"));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
