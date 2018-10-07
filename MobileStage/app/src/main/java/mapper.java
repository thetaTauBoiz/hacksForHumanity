import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class mapper {

    //Test String in format returned by querry.
    public static String test = "\"{\n" +
            "  \\\"status\\\": \\\"OK\\\",\n" +
            "  \\\"origin_addresses\\\": [ \\\"Vancouver, BC, Canada\\\", \\\"Seattle, État de Washington, États-Unis\\\" ],\n" +
            "  \\\"destination_addresses\\\": [ \\\"San Francisco, Californie, États-Unis\\\", \\\"Victoria, BC, Canada\\\" ],\n" +
            "  \\\"rows\\\": [ {\n" +
            "    \\\"elements\\\": [ {\n" +
            "      \\\"status\\\": \\\"OK\\\",\n" +
            "      \\\"duration\\\": {\n" +
            "        \\\"value\\\": 340110,\n" +
            "        \\\"text\\\": \\\"3 jours 22 heures\\\"\n" +
            "      },\n" +
            "      \"distance\" : { \n"+
            "      \"text\" : \"225 mi,\n"+
            "      \"value\" : 361715\n"+
            "      }\n" +
            "    }, {\n" +
            "      \\\"status\\\": \\\"OK\\\",\n" +
            "      \\\"duration\\\": {\n" +
            "        \\\"value\\\": 24487,\n" +
            "        \\\"text\\\": \\\"6 heures 48 minutes\\\"\n" +
            "      },\n" +
            "      \\\"distance\\\": {\n" +
            "        \\\"value\\\": 129324,\n" +
            "        \\\"text\\\": \\\"129 km\\\"\n" +
            "      }\n" +
            "    } ]\n" +
            "  }, {\n" +
            "    \\\"elements\\\": [ {\n" +
            "      \\\"status\\\": \\\"OK\\\",\n" +
            "      \\\"duration\\\": {\n" +
            "        \\\"value\\\": 288834,\n" +
            "        \\\"text\\\": \\\"3 jours 8 heures\\\"\n" +
            "      },\n" +
            "      \\\"distance\\\": {\n" +
            "        \\\"value\\\": 1489604,\n" +
            "        \\\"text\\\": \\\"1 490 km\\\"\n" +
            "      }\n" +
            "    }, {\n" +
            "      \\\"status\\\": \\\"OK\\\",\n" +
            "      \\\"duration\\\": {\n" +
            "        \\\"value\\\": 14388,\n" +
            "        \\\"text\\\": \\\"4 heures 0 minutes\\\"\n" +
            "      },\n" +
            "      \\\"distance\\\": {\n" +
            "        \\\"value\\\": 135822,\n" +
            "        \\\"text\\\": \\\"136 km\\\"\n" +
            "      }\n" +
            "    } ]\n" +
            "  } ]\n" +
            "}\"";

    public static void main(String args[]) //Test Case dummy input
    {
        try
        {
            System.out.println(getDistance(41.43206,-81.38992,"Seattle WA"));
        } catch(Exception e)
        {
            System.out.println("Error");
        }
    }

    public static double getDistance(double lat, double log, String end) throws Exception {
        // build a URL
        String s = "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial";
        s += "&origins=";
        s += lat+","+log;
        s += "&destinations=";
        s += URLEncoder.encode(end, "UTF-8");
        URL url = new URL(s);

        //System.out.println(url); //Make sure the URL is generated correctly.

        // read from the URL
        Scanner scan = new Scanner(url.openStream());
        String str = new String();
        while (scan.hasNext())
            str += scan.nextLine();
        scan.close();

        System.out.println(str);
        String[] lines;
        if (str.indexOf("OK")>-1)
        {
            lines = str.split("distance")[1].split("\n");
        }
        else
        {
            lines = test.split("distance")[1].split("\n");
        }
        double d;
        int i = Integer.parseInt(lines[2].substring(lines[2].indexOf(":")+2, lines[2].length()-1));
        d = i/1609.34;
        return d*10;
    }
}
