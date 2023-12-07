package todo.list.moraes.toDoList.authentication.user.dto;

import jakarta.validation.constraints.NotNull;
import todo.list.moraes.toDoList.authentication.user.UserRole;

public record RegisterDto(@NotNull String email, @NotNull String password, @NotNull UserRole role) {
}
