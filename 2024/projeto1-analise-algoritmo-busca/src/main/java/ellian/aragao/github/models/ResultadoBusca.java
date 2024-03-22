package ellian.aragao.github.models;

public record ResultadoBusca<T, E>(T index, E item, Long iteracao) {
    public static <T, E> ResultadoBusca<T, E> of(T index, E item, Long iteracao) {
        return new ResultadoBusca<>(index, item, iteracao);
    }
}
