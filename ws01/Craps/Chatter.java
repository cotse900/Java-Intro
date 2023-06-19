/**********************************************
 Workshop 1 Task 3
 Course: JAC444 - Semester 4
 Last Name: Tse
 First Name: Chungon
 ID: 154928188
 Section: NAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 CHUNGON
 Date: 1 Feb 2023
 **********************************************/
package Craps;
/**
 * Task 3 - Chatter
 * @author Chungon Tse 1 Feb 2023
 * {@link Craps.Task3} Chatter supports this module adding messages
 */
public class Chatter {
    Chatter(){};
    /**
     * Strings as messages
     */
    public String[] messages = {
            "Oh, you're going for broke, huh?",
            "Aw c'mon, take a chance!",
            "You're up big. Now's the time to cash in your chips!"
    };
    /**
     * index        generates random string
     */
    public void RandomString(){
        int index = (int)(Math.random() * messages.length);
        System.out.print("\n" + messages[index] + "\n");
    }
}
