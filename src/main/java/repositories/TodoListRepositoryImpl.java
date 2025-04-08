package repositories;

import entities.TodoList;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoListRepositoryImpl implements TodoListRepository {
    private DataSource dataSource;
    public TodoList[] data = new TodoList[10];

    public TodoListRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public TodoList[] getAll() {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM todo_list";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    List<TodoList> lists = new ArrayList<>();
                    while (resultSet.next()) {
                        TodoList todoList = new TodoList();
                        todoList.setId(resultSet.getInt("id"));
                        todoList.setTodo(resultSet.getString("todo"));

                        lists.add(todoList);
                    }

                    return lists.toArray(new TodoList[]{});
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void add(TodoList todoList) {
       try (Connection connection = dataSource.getConnection()) {
           String sql = "INSERT INTO todo_list (todo) VALUES (?)";
           try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
               preparedStatement.setString(1, todoList.getTodo());
               preparedStatement.executeUpdate();
           }
       } catch (SQLException exception) {
           throw new RuntimeException(exception);
       }
    }

    private boolean isExist(Integer number) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT id FROM todo_list WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, number);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public boolean remove(Integer number) {
        if (isExist(number)) {
            try (Connection connection = dataSource.getConnection()) {
                String sql = "DELETE FROM todo_List WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, number);
                    preparedStatement.executeUpdate();
                }

                return true;
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
        }

        return false;
    }
}
