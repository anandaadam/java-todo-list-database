package services;

import entities.TodoList;
import repositories.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {
    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = todoListRepository.getAll();

        System.out.println("Todo List");
        for (int i = 0; i < model.length; i++) {
            var todo = model[i];
            var number = todo.getId();

            if (todo != null) {
                System.out.println(number + ". " + todo.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
    }

    @Override
    public boolean removeTodoList(Integer number) {
        return todoListRepository.remove(number);
    }
}
