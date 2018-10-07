import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
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

    //public static String[] table = {"Arizona State University, Tempe Campus","Spokes On Southern","Nowhere"};
    public static String[][] table = {{"Arizona State University, Tempe Campus","0",},{"Spokes On Southern","4960"},{"Nowhere","25000"}};

    public static final double CON = 1609.34;

    public static void main(String args[]) //Test Case dummy input
    {
        try
        {
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("Enter an X-mile radius to search: ");
            int n = reader.nextInt(); // Scans the next token of the input as an int.
            reader.close();
            double rad = n*CON;
            List<String> Names = new ArrayList<String>();
            //List<String[]> Names = new ArrayList<String[]>;
            for(int i = 0; i<table.length; i++)
            {
                //if (getDistance(41.43206,-81.38992,table[i])>rad)
                if (Integer.parseInt(table[i][1])<rad)
                        Names.add(table[i][0]);
            }
            for (int j=0; Names.get(j) != null; j++)
            {
                System.out.println(Names.get(j));
            }
        } catch(Exception e)
        {
            return;
        }
    }

    public static int getDistance(double lat, double log, String end) throws Exception {
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
        return Integer.parseInt(lines[2].substring(lines[2].indexOf(":")+2, lines[2].length()-1));
    }
}
