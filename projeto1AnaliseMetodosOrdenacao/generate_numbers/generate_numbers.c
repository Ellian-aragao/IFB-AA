#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>
#include "config.h"

static inline void error_exit(const char *error_msg)
{
  perror(error_msg);
  exit(EXIT_FAILURE);
}

void create_bin_file(const char *file_name, void (*func)(FILE *))
{
  FILE *file;
  const char *divisor = "-------------------------------------------------\n";
  printf("%sCriando arquivo: %s\n", divisor, file_name);
  if ((file = fopen(file_name, "wb")) == NULL)
    error_exit("Erro ao criar arquivo");
  puts("Arquivo criado com SUCESSO\nPopulando dados no arquivo");
  func(file);
  puts("Processo concluído com sucesso");
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

void verify_configs(const char *file_names[])
{
  puts("Analizando arquivo de configuração");
  if (QUANTIDADE_DE_NUMEROS <= 0)
    error_exit("quantidade de numeros não pode ser menor que 1");

  const char *nome_invalido = "Nome do arquivo não pode ser vazio";
  for (int i = 0; i < 3; i++)
  {
    if (!strlen(file_names[i]))
      error_exit(nome_invalido);
  }
}

void generate_teste_files()
{
  const char *file_names[] = {
      FILENAME_NUMEROS_CRESCENTES,
      FILENAME_NUMEROS_DECRESCENTES,
      FILENAME_NUMEROS_RANDOMICOS};

  void (*functions[])(FILE *) = {
      generate_numbers_crescente,
      generate_numbers_decrescente,
      generate_numbers_random};

  verify_configs(file_names);
  for (int i = 0; i < 3; i++)
    create_bin_file(file_names[i], functions[i]);
}
