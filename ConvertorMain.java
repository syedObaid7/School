
public class ConvertorMain
{

    public static void main(String[] args) throws Exception
    {
        // Now start our bot up.
        Convertor bot = new Convertor();

        // Enable debugging output.
        bot.setVerbose(true);

        // Connect to the IRC server.
        bot.connect("irc.freenode.net");

        // Join the #pircbot channel.
        bot.joinChannel("#obaid");

        bot.sendMessage("#obaid", "Enter the amount then the currency code then the currency code to convert to");
    }
}
