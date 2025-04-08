public class TodoList {
    public static String[] list = new String[5];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewGetTodoList();
    }

    public static void getTodoList() {
        System.out.println("Todo List");
        for (int i = 0; i < list.length; i++) {
            var todo = list[i];
            var number = i + 1;

            if (todo != null) {
                System.out.println(number + ". " + todo);
            }
        }
    }

    public static void testGetTodoList() {
        list[0] = "Learn DSA";
        list[1] = "Learn Java";
        list[2] = "Learn SpringBoot";
        getTodoList();
    }

    public static void addTodoList(String todo) {
        var isFull = true;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            var temp = list;
            list = new String[list.length * 2];

            for (int i = 0; i < temp.length; i++) {
                list[i] = temp[i];
            }
        }

        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 1; i <= 25; i++) {
            addTodoList(String.valueOf(i));
        }

        getTodoList();
    }

    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= list.length) {
            return false;
        } else if (list[number - 1] == null) {
            return false;
        } else {
            list[number - 1] = null;

            for (int i = number - 1; i < list.length; i++) {
                if (i == (list.length - 1)) {
                    list[i] = null;
                } else {
                    list[i] = list[i + 1];
                }
            }

            return true;
        }
    }

    public static void testRemoveTodoList() {
        for (int i = 1; i <= 5; i++) {
            addTodoList(String.valueOf(i));
        }

        System.out.println(removeTodoList(3));
        getTodoList();
    }

    public static String input(String info) {
        System.out.print(info + ": ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("nama");
        System.out.println("hi, " + name);
    }

    public static void viewGetTodoList() {
        while (true) {
            getTodoList();

            System.out.println("Menu");
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("3. Done");

            var input = input("Choose");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Choose 1 or 2 or 3");
            }
        }
    }

    public static void testViewGetTodoList() {
        viewGetTodoList();
    }

    public static void viewAddTodoList() {
        System.out.println("Add Todo List");

        var todo = input("Todo (x for cancel)");
        if (todo.equals("x")) {

        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList() {
        viewAddTodoList();
        getTodoList();
    }

    public static void viewRemoveTodoList() {
        System.out.println("Remove Todo List");

        var number = input("Number todo (x for cancel)");
        if (number.equals("x")) {

        } else {
            var isSuccess = removeTodoList(Integer.valueOf(number));
            if (!isSuccess) {
                System.out.println("Fail to remove todo at " + number);
            }
        }
    }

    public static void testViewRemoveTodoList() {
        getTodoList();
        viewRemoveTodoList();
        getTodoList();
    }
}
