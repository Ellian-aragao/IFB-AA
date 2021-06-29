#include "config.h"
#include <string.h>
#include "sorts/sort.h"

enum Sort
{
  bubble = 'b',
  heap = 'h',
  merge = 'm'
};

void salve_read_file_data_in_vector(int *vector, const char *file_name);
int compare_integer(void *i1, void *i2);
void print_vector(const int *vector, const int tamVector);
void verifica_algoritmo(void *vector, const char algoritmo);
int is_algoritmo_enviado_valido(const char algoritmo);

int main(int argc, char const *argv[])
{
  if (argc < 3)
  {
    perror("Deve-se enviar o nome do algoritmo de ordenação e um arquivo de entrada no programa");
    exit(EXIT_FAILURE);
  }
  if (strlen(argv[1]) > 1 || !is_algoritmo_enviado_valido(argv[1][0]))
  {
    perror("Algoritmo enviado inválido. Envie: b: bubble_sort\nh: heap_sort\nm: merge_sort\n");
    exit(EXIT_FAILURE);
  }

  int *vector;
  if ((vector = (int *)malloc((sizeof(int)) * QUANTIDADE_DE_NUMEROS)) == NULL)
  {
    perror("Erro o alocar memória para vetor de ordenação");
    exit(EXIT_FAILURE);
  }

  salve_read_file_data_in_vector(vector, argv[2]);
  verifica_algoritmo(vector, argv[1][0]);
  free(vector);
  return EXIT_SUCCESS;
}

int is_algoritmo_enviado_valido(const char algoritmo)
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

void verifica_algoritmo(void *vector, const char algoritmo)
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

void salve_read_file_data_in_vector(int *vector, const char *file_name)
{
  FILE *read;
  if ((read = fopen(file_name, "rb")) == NULL)
  {
    fprintf(stderr, "Erro ao ler o arquivo %s\n", file_name);
    exit(EXIT_FAILURE);
  }
  for (size_t i = 0; i < QUANTIDADE_DE_NUMEROS; i++)
    fread(&vector[i], sizeof(int), 1, read);
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