#include <time.h>
#include "utils.h"

double get_time_execution(void *vector, const char algoritmo, const llong *quantidade_numeros)
{
  clock_t begin = clock();
  apply_algorithm(vector, &algoritmo, quantidade_numeros);
  clock_t end = clock();
  return (double)(end - begin) / CLOCKS_PER_SEC;
}

int main(int argc, char const *argv[])
{
  const arg_cli args = verify_arguments_return_needs_to_read(argc, argv);

  int *vector;
  if ((vector = (int *)malloc((sizeof(int)) * args.lenght_input)) == NULL)
  {
    perror("Erro o alocar memória para vetor de ordenação");
    exit(EXIT_FAILURE);
  }
  read_file_and_save_in_vector(vector, &args);
  double time_execution = get_time_execution(vector, argv[1][0], &args.lenght_input);
  free(vector);
  printf("Sort %s | arquivo de entrada %s -> tipo: %s | quantidade de entradas %ld | tempo de execução %lf | ",
         args.algorithm, args.file_name, args.type_file, args.lenght_input, time_execution);
  return EXIT_SUCCESS;
}
