package ellian.aragao.github.models;

public record ResultadoBusca<T, E>(T index, E item) {
    public static <T, E> ResultadoBusca<T, E> of(T index, E item) {
        return new ResultadoBusca<>(index, item);
    }
}
