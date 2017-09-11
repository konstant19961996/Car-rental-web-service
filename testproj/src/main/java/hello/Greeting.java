package hello;

import com.google.maps.model.DistanceMatrix;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static hello.HTMLParseExample1.*;

/**
 * Created by 803100 on 23.03.2017.
 */
public class Greeting {
    private String ettcity;
    private String ettdate;
    private String etttimeh;
    private String etttimem;
    private String dropcity;
    private String dropdate;
    private String droptimeh;
    private String droptimem;
    private String teststr;
    private String[] testmass = new String[100];


    public String getEttcity() {
        return ettcity;
    }

    public void setEttcity(String ettcity) {
        this.ettcity = ettcity;
    }

    public String getEttdate() {
        return ettdate;
    }

    public void setEttdate(String ettdate) {
        this.ettdate = ettdate;
    }

    public String getEtttimeh() {
        return etttimeh;
    }

    public void setEtttimeh(String etttimeh) {
        this.etttimeh = etttimeh;
    }

    public String getEtttimem() {
        return etttimem;
    }

    public void setEtttimem(String etttimem) {
        this.etttimem = etttimem;
    }

    public String getDropcity() {
        return dropcity;
    }

    public void setDropcity(String dropcity) {
        this.dropcity = dropcity;
        //this.dropcity = "Hello world";
    }

    public String getDropdate() {
        return dropdate;
    }

    public void setDropdate(String dropdate) {
        this.dropdate = dropdate;
    }

    public String getDroptimeh() {
        return droptimeh;
    }

    public void setDroptimeh(String droptimeh) {
        this.droptimeh = droptimeh;
    }

    public String getDroptimem() {
        return droptimem;
    }

    public void setDroptimem(String droptimem) {
        this.droptimem = droptimem;
    }


    public String[] newtest(String ettcity, String ettdate, String etttimeh, String etttimem, String dropcity,
                            String dropdate, String droptimeh, String droptimem) {
        String[] m = new String[300];
        String[] cities = {"SFO", "LAX", "SAN", "Orange County airport", "JFK", "DFW", "IAH"};
        Document doc, doc1;
        //String beg=ettcity, end=dropcity, med;
       // String beg = "LAX", end = "JFK", med;
        //ПОТОМ ДРОПНУТЬ
        String beg = "LAX", end = "LAX", med;
        /*if(beg==SNA) beg=cities[4]; if (end==SNA) end=cities[4]*/
        Integer i = 0;
        try {
            /*doc = Jsoup.connect("http://pluto.budgetinternational.com/budgetonline/ru/IBE" +
                    ".nsf/ReservationStep2?OpenForm&SessionID=F9C9B7F342D23DE5C125812000699992").get();
            doc1 = Jsoup.connect("https://eixnbeweb04.rent-at-avis.com/avisonline/ru/IBE" +
                    ".nsf/ReservationStep2?OpenForm&MST=2E196B6D812D1AA5C12577460054C08B&SessionID" +
                    "=9929AB879A53D8D8C12581200069D13D&IBEOwner=RU&LNG=RU&KS=Y&rnd=-593296311").get();*/
            /*ЭТО ПОТОМ ДРОПНУТЬ*/
            doc = Jsoup.connect("http://pluto.budgetinternational.com/budgetonline/ru/IBE" +
                    ".nsf/ReservationStep2?OpenForm&SessionID=675C8DB816B9538AC1258120006D039E").get();
            doc1 = Jsoup.connect("https://eixnbeweb04.rent-at-avis.com/avisonline/ru/IBE" +
                    ".nsf/ReservationStep2?OpenForm&MST=2E196B6D812D1AA5C12577460054C08B&SessionID" +
                    "=E9FA411F4C1137F9C1258120006CE4C3&IBEOwner=RU&LNG=RU&KS=Y&rnd=1550805245").get();
            m[i] = "avis";
            i++;
            Integer k = 0;
            while ((avisCarPrice(doc1)[k] != null) && (avisCarType(doc1)[k] != null)) {
                m[i] = "Авто: " + avisCarType(doc1)[k];
                i++;
                m[i] = "Стоимость: " + avisCarPrice(doc1)[k];
                i++;
                k++;
            }
            m[i] = "Budget: ";
            i++;
            k = 0;
            while ((budgetCarPrice(doc)[k] != null) && (budgetCarType(doc)[k] != null)) {
                m[i] = "Авто: " + budgetCarType(doc)[k];
                i++;
                m[i] = "Стоимость: " + budgetCarPrice(doc)[k];
                i++;
                k++;
            }
            if (beg != end) {
                // Document[] docs1 = new Document[cities.length-2];
                // Document[] docs2 = new Document[cities.length-2];
                Document[] docs1 = new Document[4];
                Document[] docs2 = new Document[4];
                /*for (int i=0; i<doc1.length; i++) docs1[i]="avis...+cities[i]"*/
                docs1[0] = Jsoup.connect("https://eixnbeweb04.rent-at-avis.com/avisonline/ru/IBE" +
                        ".nsf/ReservationStep2?OpenForm&MST=2E196B6D812D1AA5C12577460054C08B&SessionID" +
                        "=45557D543DA91C6DC1258120006A00BD&IBEOwner=RU&LNG=RU&KS=Y&rnd=-777452117").get();
                docs1[1] = Jsoup.connect("https://eixnbeweb04.rent-at-avis.com/avisonline/ru/IBE" +
                        ".nsf/ReservationStep2?OpenForm&MST=2E196B6D812D1AA5C12577460054C08B&SessionID" +
                        "=4DAC613348267A63C1258120006A211F&IBEOwner=RU&LNG=RU&KS=Y&rnd=1147148156").get();
                docs1[2] = Jsoup.connect("https://eixnbeweb04.rent-at-avis.com/avisonline/ru/IBE" +
                        ".nsf/ReservationStep2?OpenForm&MST=2E196B6D812D1AA5C12577460054C08B&SessionID" +
                        "=4CA46240093CB02BC1258120006A3D64&IBEOwner=RU&LNG=RU&KS=Y&rnd=442548726").get();
                docs1[3] = Jsoup.connect("https://eixnbeweb04.rent-at-avis.com/avisonline/ru/IBE" +
                        ".nsf/ReservationStep2?OpenForm&MST=2E196B6D812D1AA5C12577460054C08B&SessionID" +
                        "=9EF976E537415E09C1258120006A6570&IBEOwner=RU&LNG=RU&KS=Y&rnd=-801952722").get();
                docs2[0] = Jsoup.connect("https://eixnbeweb04.rent-at-avis.com/avisonline/ru/IBE" +
                        ".nsf/ReservationStep2?OpenForm&MST=2E196B6D812D1AA5C12577460054C08B&SessionID" +
                        "=00F31AC276287EDDC1258120006A8523&IBEOwner=RU&LNG=RU&KS=Y&rnd=-1524204607").get();
                docs2[1] = Jsoup.connect("https://eixnbeweb04.rent-at-avis.com/avisonline/ru/IBE" +
                        ".nsf/ReservationStep2?OpenForm&MST=2E196B6D812D1AA5C12577460054C08B&SessionID" +
                        "=2049742933744423C1258120006AA3EE&IBEOwner=RU&LNG=RU&KS=Y&rnd=1504877568").get();
                docs2[2] = Jsoup.connect("https://eixnbeweb04.rent-at-avis.com/avisonline/ru/IBE" +
                        ".nsf/ReservationStep2?OpenForm&MST=2E196B6D812D1AA5C12577460054C08B&SessionID" +
                        "=90754E7E987804B7C1258120006ABAA8&IBEOwner=RU&LNG=RU&KS=Y&rnd=2912970").get();
                docs2[3] = Jsoup.connect("https://eixnbeweb04.rent-at-avis.com/avisonline/ru/IBE" +
                        ".nsf/ReservationStep2?OpenForm&MST=2E196B6D812D1AA5C12577460054C08B&SessionID" +
                        "=200F844B107E336AC1258120006AD215&IBEOwner=RU&LNG=RU&KS=Y&rnd=1693342118").get();
                k = 0;
                for (int q = 0; q < cities.length; q++) {

                    StringBuffer start = new StringBuffer(), stop = new StringBuffer(), medium = new StringBuffer();
                    JSONInterface ji = new JSONInterface();
                    med = cities[q];
                    start.append(beg);
                    stop.append(end);
                    medium.append(med);
                    for (int j = 0; j < start.length(); j++) {
                        if (start.charAt(j) == ' ') {
                            start.deleteCharAt(j);
                            start.insert(j, "%20");
                        }
                    }
                    for (int j = 0; j < stop.length(); j++) {
                        if (stop.charAt(j) == ' ') {
                            stop.deleteCharAt(j);
                            stop.insert(j, "%20");
                        }
                    }
                    for (int j = 0; j < medium.length(); j++) {
                        if (medium.charAt(j) == ' ') {
                            medium.deleteCharAt(j);
                            medium.insert(j, "%20");
                        }
                    }
                    if (med != beg && med != end) {
                        float range = ji.calcDistance(start, medium) + ji.calcDistance(medium, stop);
                        if ((ji.calcDistance(start, stop) * 1.15) > range) {
                            m[i] = beg + " to " + end + " = " + ji.calcDistance(start, stop) + " via " +
                                    med + " = " + range;
                            i++;
                            String[] newa = new String[1000];
                            String[] newb = new String[1000];
                            Integer j = 0;
                            while ((avisCarPrice(docs1[k])[j] != null) && (avisCarType(docs1[k])[j] != null)) {
                                newa[j] = avisCarType(docs1[k])[j];
                                j++;
                            }
                            j = 0;
                            while ((avisCarPrice(docs1[k])[j] != null) && (avisCarType(docs1[k])[j] != null)) {
                                newb[j] = avisCarPrice(docs1[k])[j];
                                j++;
                            }
                            m[i] = "Avis " + beg + " to " + med;
                            i++;
                            for (j = 0; newa[j] != null || newb[j] != null; j++) {
                                m[i] = "Авто: " + newa[j];
                                i++;
                                m[i] = "Стоимость: " + newb[j];
                                i++;
                            }
                            j = 0;
                            while ((avisCarPrice(docs2[k])[j] != null) && (avisCarType(docs2[k])[j] != null)) {
                                newa[j] = avisCarType(docs2[k])[j];
                                j++;
                            }
                            j = 0;
                            while ((avisCarPrice(docs2[k])[j] != null) && (avisCarType(docs2[k])[j] != null)) {
                                newb[j] = avisCarPrice(docs2[k])[j];
                                j++;
                            }
                            m[i] = "Avis " + med + " to " + end;
                            i++;
                            for (j = 0; newa[j] != null || newb[j] != null; j++) {
                                m[i] = "Авто: " + newa[j];
                                i++;
                                m[i] = "Стоимость: " + newb[j];
                                i++;
                            }
                            k++;
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return m;
    }

    public String makeTeststr() {
        String strt = "";
        String[] m;
        m = newtest(ettcity, ettdate, etttimeh, etttimem, dropcity, dropdate, droptimeh, droptimem);

        for (int i = 0; m[i] != null; i++) {
            strt = strt + m[i] + "\n";
        }
        return strt;
    }


    //private String[]testmass=makeTestmass(ettcity,ettdate,etttimeh,etttimem,dropcity,dropdate,droptimeh,droptimem);
    //private String[]testmass={mass[0],mass[1]};
    public String[] getTestmass() {
        testmass = newtest(ettcity, ettdate, etttimeh, etttimem, dropcity, dropdate, droptimeh, droptimem);
        return testmass;
    }

    public void setTestmass(String[] testmass) {
        this.testmass = testmass;
    }

    public String getTeststr() {
        teststr = makeTeststr();
        return teststr;
    }

    public void setTeststr(String teststr) {
        this.teststr = teststr;
    }
}
