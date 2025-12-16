package moi.gda.data.backend_gda_data.utils;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
  private boolean success;
  private T data;

  public static <T> ApiResponse<T> ok(T data) {
    return new ApiResponse<>(true, data);
  }
}

