package hello;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
/**
 * Created by 803100 on 03.05.2017.
 */
public class HTMLParseExample1 {
    public static String[] avisCarType(Document doc1) {
        String title = doc1.title();
        Elements links = doc1.select("div");
        String[] a = new String[100];
        Integer i = 0;
        for (Element link : links) {
            if (link.attr("class").equals("descriptionTextUpsell")) {
                a[i] = link.text();
                i++;
            }
        }
        return a;
    }

    public static String[] avisCarPrice(Document doc1) {
        String title = doc1.title();
        String[] b = new String[100];
        Integer i = 0;
        Elements links1 = doc1.select("td");
        for (Element link : links1) {
            if (link.attr("class").equals("priceTextUpsellPrice") && link.attr("style").equals
                    ("text-align:right;")) {
                if (!link.text().equals("")) {
                    b[i] = link.text() + " USD";
                    i++;
                }
            }
        }
        return b;
    }

    public static String[] budgetCarType(Document doc) {
        String[] a1 = new String[100];
        Elements links;
        Integer i = 0;
        links = doc.select("div");
        for (Element link : links) {
            if (link.attr("class").equals("cg_details_tab")) {
                a1[i] = link.text();
                i++;
            }
        }
        return a1;
    }

    public static String[] budgetCarPrice(Document doc) {
        String[] b1 = new String[100];
        Integer i = 0;
        Elements links1;
        links1 = doc.select("span");
        for (Element link : links1) {
            if (link.attr("class").equals("price")) {
                if (!link.text().equals("")) {
                    b1[i] = link.text();
                    i++;
                }
            }
        }
        return b1;
    }

}
