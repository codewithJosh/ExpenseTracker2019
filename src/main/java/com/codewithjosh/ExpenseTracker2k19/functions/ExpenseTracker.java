package main.java.com.codewithjosh.ExpenseTracker2k19.functions;

public class ExpenseTracker
{

    public String getString(final String stringOf)
    {

        final String sResources = "/main/res/ic_%.png";

        switch (stringOf.toLowerCase())
        {

            case "day":
                return sResources.replace("%", "day");

            case "dayhover":
                return sResources.replace("%", "day_hover");

            case "daylogo":
                return sResources.replace("%", "day_logo");

            case "head":
                return sResources.replace("%", "head");

            case "login":
                return sResources.replace("%", "login");

            case "loginhover":
                return sResources.replace("%", "login_hover");

            case "logo":
                return sResources.replace("%", "logo");

            case "navlogin":
                return sResources.replace("%", "nav_login");

            case "navloginhover":
                return sResources.replace("%", "nav_login_hover");

            case "navregister":
                return sResources.replace("%", "nav_register");

            case "navregisterhover":
                return sResources.replace("%", "nav_register_hover");

            case "night":
                return sResources.replace("%", "night");

            case "nighthover":
                return sResources.replace("%", "night_hover");

            case "nightlogo":
                return sResources.replace("%", "night_logo");

            case "register":
                return sResources.replace("%", "register");

            case "registerhover":
                return sResources.replace("%", "register_hover");

            case "taillogin":
                return sResources.replace("%", "tail_login");

            case "tailregister":
                return sResources.replace("%", "tail_register");

            case "":
                return sResources.replace("%", "");

        }

        return null;

    }

}
