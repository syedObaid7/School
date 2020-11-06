import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jibble.pircbot.PircBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DecimalFormat;


public class Convertor extends PircBot
{
    String countryFrom = null;
    String countryTo = null;
    double amount;

    public Convertor()
    {
        this.setName("Syed");
    }

    public void onMessage(String channel, String sender,
                          String login, String hostname, String message)
    {
        message = message.toLowerCase();
        String[] words = message.split(" ");
        String output = null;

        if (words.length == 3)
        {
            amount = Double.parseDouble(words[0]);
            countryFrom = words[1];
            countryTo = words[2];

            try
            {
                output = connect(countryFrom, channel);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            sendMessage(channel, output);
        }
        else
        {
            System.out.println("ERROR, message not in correct format");
        }
    }


    public String jsonParse(String s)
    {
        JsonObject obj = new JsonParser().parse(s).getAsJsonObject();

        double rate = obj.getAsJsonObject("conversion_rates").get(countryTo.toUpperCase()).getAsDouble();

        DecimalFormat format = new DecimalFormat("###.##");

        return amount + " " + countryFrom.toUpperCase() + " is equal to " + format.format(rate * amount) +
                " in " + countryTo.toUpperCase();
    }

    public String connect(String countryFrom, String channel) throws IOException
    {
        try
        {
            // Creates URL object
            URL url = null;
            try
            {
                url = new URL("https://v6.exchangerate-api.com/v6/4e6aded565321b8472bca5da/latest/" + countryFrom);
            } catch (MalformedURLException e)
            {
                e.printStackTrace();
            }

            // Retrieves a URL connection object
            HttpURLConnection con = null;
            try
            {
                assert url != null;
                con = (HttpURLConnection) url.openConnection();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            // Use the object to create a GET Request
            try
            {
                assert con != null;
                con.setRequestMethod("GET");
            } catch (ProtocolException e)
            {
                e.printStackTrace();
            }

            // Adds header to the request
            con.setRequestProperty("Content-Type", "application/json");

            // Creates a BufferedReader on the input stream and reads from it.
            // Connection is opened implicitly by calling getInputStream which gets an input stream from the connection
            BufferedReader in = null;
            try
            {
                in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
            } catch (IOException e)
            {
                e.printStackTrace();
            }

            // Converts BufferReader to String and stores in a result variable
            String inputLine;
            StringBuilder content = new StringBuilder();
            while (true)
            {
                assert in != null;
                if ((inputLine = in.readLine()) == null) break;
                content.append(inputLine);
            }
            try
            {
                in.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }

            return jsonParse(content.toString());
        } catch (Exception e)
        {
            return "Error! Exception : " + e;
        }
    }
}
