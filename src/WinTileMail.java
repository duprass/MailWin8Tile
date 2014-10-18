import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Windows 8 Tile for email letters in console
 * Attention, please!
 * It's only widget, that shows the last and the new letter
 * So there is no need to keep all letters,
 * but I think, that the information about
 * the number of the new letters is useful
 * Also, it allows to see full content of message
 * Created by Olga on 18.10.2014.
 */

//TODO: Add comments!
public class WinTileMail extends Component {
    private String name;
    private Letter letter;
    private boolean newLetter = false;

    public WinTileMail(String name, int x, int y, String font, int width, int height) {
        super(x, y, font, width, height);
        this.name = name;
    }

    public WinTileMail() {
        this("Mail", 100, 100, "Comic San", 300, 150);
    }

    private boolean getNewLetter() {
        return newLetter;
    }

    private String getLetter() {
        return letter.toString();
    }

    private String getFullLetter() {
        newLetter = false;
        Parametrs.setCountLetters(false);
        return letter.toString()
                + "Decription:\n\n" + letter.getContent();
    }

    public String getName() {
        return name;
    }

    public void receivedNewLetter(String mailAddress, String author, String theme, String content) {
        boolean rightMailAdress = verifyMail(mailAddress);
        if (rightMailAdress) {
            letter = new Letter(mailAddress, author, theme, content);
        } else {
            System.out.println("It's a suspicious file, because the email adrress isn't correct");
            return;
        }

        Parametrs.setCountLetters(true);
        newLetter = true;
        System.out.print("\nYou received one new letter!");
    }

    private boolean verifyMail(String mailAddress) {
        class Mail {

            private Pattern pattern;
            private Matcher matcher;

            private static final String EMAIL_PATTERN =
                    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

            public Mail() {
                pattern = Pattern.compile(EMAIL_PATTERN);
            }

            public boolean verify() {
                matcher = pattern.matcher(mailAddress);
                return matcher.matches();
            }
        }

        Mail mail = new Mail();

        return mail.verify();
    }

    @Override
    public void mouseOn() {
        if (getNewLetter()) {
            System.out.println(getLetter());
        }
    }

    @Override
    public void click() {
        System.out.println(this.getFullLetter());
    }

    @Override
    public void mouseOff() {
        final WinTileMail a = this;

        ActionMouse made = new ActionMouse() {
            @Override
            public void action() {
                System.out.println(a.toString());
            }
        };

        made.action();
    }


    public String toString() {
        return "\n\n\n\t\t\t" + name.toUpperCase()
                + "\n\n\t\t\t" + Parametrs.getCountLetters();
    }

    public class Letter {
        private String mailAddress;
        private String author;
        private String theme;
        private String content;

        public Letter(String mailAddress, String author, String theme, String content) {
            this.mailAddress = mailAddress;
            this.author = author;
            this.theme = theme;
            this.content = content;
        }

        public String getMailAddress() {
            return mailAddress;
        }

        public String getAuthor() {
            return author;
        }

        public String getTheme() {
            return theme;
        }

        public String getContent() {
            return content;
        }

        public String toString() {
            return "\n" + this.getMailAddress()
                    + "\n" + this.getAuthor()
                    + "\n" + this.getTheme();
        }
    }

    private static class Parametrs {
        public final static String COLOR = "RED";
        private static int countNewLetters = 0;

        private static void setCountLetters(boolean increase) {
            if (increase) {
                countNewLetters++;
            } else {
                countNewLetters--;
            }
        }

        public static String getCountLetters() {
            if (countNewLetters == 0) {
                return "You don't have any new letters";
            } else if (countNewLetters == 1) {
                return "\n You have one new letter! ";
            } else {
                return "\n New Letters: " + countNewLetters + " ";
            }
        }
    }
}

interface ActionMouse {
    void action();
}