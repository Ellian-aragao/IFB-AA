#include "../config.h"
#include <string.h>
#include "sort.h"

enum Sort
{
  bubble = 'b',
  heap = 'h',
  merge = 'm'
};

typedef long long llong;

void read_file_and_save_in_vector(int *vector, const char *file_name);
int compare_integer(void *i1, void *i2);
void print_vector(const int *vector, const int tamVector);
void apply_algorithm(void *vector, const char algoritmo);
int valid_algorithm_parameter(const char algoritmo);
int valid_read_parameter(const char read_mode);
void if_true_print_msg_exit(int is_true, const char *msg);
llong verify_arguments(int argc, char const *argv[]);

int main(int argc, char const *argv[])
{
  const llong quantidade_numeros = verify_arguments(argc, argv);

  int *vector;
  if ((vector = (int *)malloc((sizeof(int)) * quantidade_numeros)) == NULL)
  {
    perror("Erro o alocar memória para vetor de ordenação");
    exit(EXIT_FAILURE);
  }

  read_file_and_save_in_vector(vector, argv[2]);
  apply_algorithm(vector, argv[1][0]);
  free(vector);
  return EXIT_SUCCESS;
}

llong verify_arguments(int argc, char const *argv[])
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

  return argc == 5 ? atoll(argv[4]) : QUANTIDADE_DE_NUMEROS;
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

void apply_algorithm(void *vector, const char algoritmo)
{
  switch (algoritmo)
  {
  case bubble:
    bubble_sort(vector, QUANTIDADE_DE_NUMEROS, sizeof(int), compare_integer);
    break;
  case heap:
    heap_sort(vector, QUANTIDADE_DE_NUMEROS, sizeof(int), compare_integer);
    break;
  case merge:
    merge_sort(vector, QUANTIDADE_DE_NUMEROS, sizeof(int), compare_integer);
    break;
  }
}

void read_file_and_save_in_vector(int *vector, const char *file_name)
{
  FILE *read;
  if ((read = fopen(file_name, "rb")) == NULL)
  {
    fprintf(stderr, "Erro ao ler o arquivo %s\n", file_name);
    exit(EXIT_FAILURE);
  }
  for (size_t i = 0; i < QUANTIDADE_DE_NUMEROS; i++)
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
