#include "config.h"
#include "sort.h"

void salve_read_file_data_in_vector(int *vector, const char *file_name);
int compare_integer(void *i1, void *i2);
void print_vector(const int *vector, const int tamVector);

int main(int argc, char const *argv[])
{
  if (argc < 2)
  {
    perror("Deve-se enviar valores de entrada no programa");
    exit(EXIT_FAILURE);
  }
  int *vector;
  if ((vector = (int *)malloc((sizeof(int)) * QUANTIDADE_DE_NUMEROS)) == NULL)
  {
    perror("Erro o alocar memória para vetor de ordenação");
    exit(EXIT_FAILURE);
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