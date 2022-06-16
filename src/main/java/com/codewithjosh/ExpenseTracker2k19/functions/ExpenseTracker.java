package main.java.com.codewithjosh.ExpenseTracker2k19.functions;

public class ExpenseTracker
{

    public String getString(final String stringOf)
    {

        final String sResources = "/main/res/ic_%.png";

        switch (stringOf.toLowerCase())
        {

            case "background01":
                return sResources.replace("%", "background_01");

            case "background02":
                return sResources.replace("%", "background_02");

            case "background03":
                return sResources.replace("%", "background_03");

            case "background04":
                return sResources.replace("%", "background_04");

            case "budget":
                return sResources.replace("%", "budget");

            case "budgethover":
                return sResources.replace("%", "budget_hover");

            case "center":
                return sResources.replace("%", "center");

            case "centerhover":
                return sResources.replace("%", "center_hover");

            case "day":
                return sResources.replace("%", "day");

            case "dayhover":
                return sResources.replace("%", "day_hover");

            case "daylogo":
                return sResources.replace("%", "day_logo");

            case "end":
                return sResources.replace("%", "end");

            case "endhover":
                return sResources.replace("%", "end_hover");

            case "expenses":
                return sResources.replace("%", "expenses");

            case "expenseshover":
                return sResources.replace("%", "expenses_hover");

            case "head":
                return sResources.replace("%", "head");

            case "income":
                return sResources.replace("%", "income");

            case "incomehover":
                return sResources.replace("%", "income_hover");

            case "login":
                return sResources.replace("%", "login");

            case "loginhover":
                return sResources.replace("%", "login_hover");

            case "logo":
                return sResources.replace("%", "logo");

            case "moon":
                return sResources.replace("%", "moon");

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

            case "start":
                return sResources.replace("%", "start");

            case "starthover":
                return sResources.replace("%", "start_hover");

            case "sun":
                return sResources.replace("%", "sun");

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
