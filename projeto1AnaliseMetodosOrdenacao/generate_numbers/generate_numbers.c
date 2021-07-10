#include "generate_numbers.h"

inline void error_exit(const char *error_msg)
{
  perror(error_msg);
  exit(EXIT_FAILURE);
}

void create_bin_file(const char *file_name, void (*func)(FILE *))
{
  FILE *file;
  printf("Criando arquivo: %s\n", file_name);
  if ((file = fopen(file_name, "w")) == NULL)
    error_exit("Erro ao criar arquivo");
  printf("Iniciando escrita %s\n", file_name);
  func(file);
  printf("Finalizando escrita %s\n", file_name);
  fclose(file);
}

void generate_numbers_crescente(FILE *file)
{
  for (int i = 0; i < QUANTIDADE_DE_NUMEROS; i++)
    fwrite(&i, sizeof(int), 1, file);
}

void generate_numbers_decrescente(FILE *file)
{
  for (int i = QUANTIDADE_DE_NUMEROS; i > 0; i--)
    fwrite(&i, sizeof(int), 1, file);
}

void generate_numbers_random(FILE *file)
{
  srand(time(NULL));
  for (int i = 0; i < QUANTIDADE_DE_NUMEROS; i++)
  {
    int random = rand();
    fwrite(&random, sizeof(int), 1, file);
  }
}

void verify_configs(const char *file_names)
{
  const char *nome_invalido = "Nome do arquivo não pode ser vazio";
  if (!strlen(file_names))
    error_exit(nome_invalido);
}

void *generate_teste_files(void *index_from_thread)
{
  const int index = (int)index_from_thread;

  const char *file_names[] = {
      FILENAME_NUMEROS_CRESCENTES,
      FILENAME_NUMEROS_DECRESCENTES,
      FILENAME_NUMEROS_RANDOMICOS};

  void (*functions[])(FILE *) = {
      generate_numbers_crescente,
      generate_numbers_decrescente,
      generate_numbers_random};

  verify_configs(file_names[index]);
  create_bin_file(file_names[index], functions[index]);
  pthread_exit(index_from_thread);
}
