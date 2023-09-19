package Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    public void testSimpleTaskFound() {
        SimpleTask simpleTask = new SimpleTask(5, "позвонить родителям");

        boolean actual = simpleTask.matches("родителям");
        boolean expected = true;

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskNotFound() {
        SimpleTask simpleTask = new SimpleTask(5, "позвонить родителям");

        boolean actual = simpleTask.matches("бабушке");
        boolean expected = true;

        Assertions.assertFalse(actual);
    }

    @Test
    public void testSubTaskFound() {
        String[] subtasks = {"молоко", "яйца", "хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("молоко");
        boolean expected = true;

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSubTaskNotFound() {
        String[] subtasks = {"молоко", "яйца", "хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("помидор");
        boolean expected = true;

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingFound() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("приложения");
        boolean expected = true;

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingNotFound() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("прилажения");
        boolean expected = true;

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingNot1Found() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("приложений");
        boolean expected = true;

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeeting1Found() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Нетобанка");
        boolean expected = true;

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingNot2Found() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Нетабанка");
        boolean expected = true;

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingNot3Found() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Нетобанкинг");
        boolean expected = true;

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingNot4Found() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("новое");
        boolean expected = true;

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeeting2Found() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("обеда");
        boolean expected = true;

        Assertions.assertFalse(actual);
    }
}
