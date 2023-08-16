package com.example.demo.help;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;

import java.net.URL;

public class HelpSystem {
    public static  void showJavaHelp() throws HelpSetException {
        URL hsURL = HelpSystem.class.getResource("/help/help_set.hs");
        HelpSet helpSet = new HelpSet(HelpSystem.class.getClassLoader(), hsURL);
        HelpBroker helpBroker = helpSet.createHelpBroker();
        helpBroker.setDisplayed(true);
    }
}
