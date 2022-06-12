package main.java.com.codewithjosh.ExpenseTracker2k19.functions;

public class ExpenseTracker {

    public String getString(final String stringOf) {

        final String sResources = "/main/res/ic_%.png";

        switch (stringOf.toLowerCase()) {

            case "head":
                return sResources.replace("%", "head");

            case "login":
                return sResources.replace("%", "login");

            case "logo":
                return sResources.replace("%", "logo");

            case "navregister":
                return sResources.replace("%", "nav_register");

            case "taillogin":
                return sResources.replace("%", "tail_login");

            case "":
                return sResources.replace("%", "");

        }

        return null;

    }

}
