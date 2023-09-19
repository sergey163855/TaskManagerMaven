package Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "позвонить родителям");

        String[] subtasks = {"молоко", "яйца", "хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenFewTasksFound() {
        SimpleTask simpleTask = new SimpleTask(5, "купить хлеб");

        String[] subtasks = {"молоко", "яйца", "хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("хлеб");
        Task[] expected = {simpleTask, epic};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenOneTaskFound() {
        SimpleTask simpleTask = new SimpleTask(5, "купить хлеб");

        String[] subtasks = {"молоко", "яйца", "хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("молоко");
        Task[] expected = {epic};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenZeroTaskFound() {
        SimpleTask simpleTask = new SimpleTask(5, "купить хлеб");

        String[] subtasks = {"молоко", "яйца", "хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("помидор");
        Task[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenOne1TaskFound() {
        SimpleTask simpleTask = new SimpleTask(5, "купить хлеб");

        String[] subtasks = {"молоко", "яйца", "хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Выкатка");
        Task[] expected = {meeting};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenMeetingNotTaskFound() {
        SimpleTask simpleTask = new SimpleTask(5, "купить хлеб");

        String[] subtasks = {"молоко", "яйца", "хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Во вторник");
        Task[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenIDTaskFound() {
        SimpleTask simpleTask = new SimpleTask(5, "купить хлеб");

        String[] subtasks = {"Приложение", "яйца", "хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка третьей версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Приложение");
        Task[] expected = {epic, meeting};

        Assertions.assertArrayEquals(expected, actual);
    }
}

