
/** Method main to represent WinTIleMail
 * Created by Olga on 18.10.2014.
 */
public class Desktop {
    public static void main(String[] args) {

        WinTileMail gmail = new WinTileMail();

        gmail.receivedNewLetter("habrahabr@mail.ru", "Habrahabr", "Habrahabr represents Geek Times",
                "Visit habrahabr.ru for additional information");

        //Illusion of mouse movements and actions
        gmail.mouseOn();
        gmail.mouseOff();
        gmail.click();
        gmail.mouseOff();
        gmail.receivedNewLetter("lms@edu.hse.ru", "LMS", "Project 5 has been added",
                "You should do linear search");
        gmail.receivedNewLetter("noreply@ted.com", "TED", "There are some new video for you!",
                "TEDx Talks: \"Architecture as a human narrative | Barbara Stehle | TEDxFultonStreet");

        gmail.mouseOn();
        gmail.mouseOff();
        gmail.click();
    }
}
