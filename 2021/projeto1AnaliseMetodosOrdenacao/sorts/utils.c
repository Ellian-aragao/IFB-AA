#include "utils.h"

arg_cli verify_arguments_return_needs_to_read(int argc, char const *argv[])
{
  if_true_print_msg_exit(
      argc < 3,
      "Deve-se enviar o nome do algoritmo de ordenação e um arquivo de entrada no programa");
  if_true_print_msg_exit(
      strlen(argv[1]) > 1 || !valid_algorithm_parameter(argv[1][0]),
      "Algoritmo enviado inválido. Envie:\nb: bubble_sort\nh: heap_sort\nm: merge_sort\n");

  if_true_print_msg_exit(
      argc == 4 && !valid_read_parameter(argv[3][0]),
      "Modo de leitura de arquivo inválido\nEnvie:\nc: character\nb: binário\nvazio: binário\n");
  arg_cli args = {&argv[1][0],
                  argv[2],
                  (argc == 4 && argv[3][0] == 'c') ? "r" : "rb",
                  argc == 5 ? atoll(argv[4]) : QUANTIDADE_DE_NUMEROS};
  return args;
}

void if_true_print_msg_exit(int is_true, const char *msg)
{
  if (is_true)
  {
    perror(msg);
    exit(EXIT_FAILURE);
  }
}

int valid_read_parameter(const char read_mode)
{
  return (read_mode == 'b' || read_mode == 'c') ? 1 : 0;
}

int valid_algorithm_parameter(const char algoritmo)
{
  switch (algoritmo)
  {
  case bubble:
  case heap:
  case merge:
    return 1;
  default:
    return 0;
  }
}

void apply_algorithm(void *vector, const char *algoritmo, const llong *quantidade_numeros)
{
  switch (*algoritmo)
  {
  case bubble:
    bubble_sort(vector, *quantidade_numeros, sizeof(int), compare_integer);
    break;
  case heap:
    heap_sort(vector, *quantidade_numeros, sizeof(int), compare_integer);
    break;
  case merge:
    merge_sort(vector, *quantidade_numeros, sizeof(int), compare_integer);
    break;
  }
}

void read_file_and_save_in_vector(int *vector, const arg_cli *args)
{
  FILE *read;
  if ((read = fopen(args->file_name, args->type_file)) == NULL)
  {
    fprintf(stderr, "Erro ao ler o arquivo %s\n", args->file_name);
    exit(EXIT_FAILURE);
  }
  for (llong i = 0; i < args->lenght_input; i++)
    fread(&vector[i], sizeof(int), 1, read);
  fclose(read);
}

void print_vector(const int *vector, const int tamVector)
{
  putchar('[');
  for (int i = 0; i < tamVector; i++)
    printf(i == tamVector - 1 ? "%d" : "%d, ", vector[i]);
  puts("]");
}

int compare_integer(void *i1, void *i2)
{
  return ((*(int *)i1) < ((*(int *)i2)) ? 1 : 0);
}
