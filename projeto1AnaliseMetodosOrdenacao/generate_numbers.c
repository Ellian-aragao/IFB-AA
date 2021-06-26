#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>
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

void verify_configs()
{
  puts("Analizando arquivo de configuração");
  if (QUANTIDADE_DE_NUMEROS <= 0)
    error_exit("quantidade de numeros não pode ser menor que 1");
  const char nome_invalido[] = "Nome do arquivo não pode ser vazio";
  if (!strlen(FILENAME_NUMEROS_CRESCENTES) || !strlen(FILENAME_NUMEROS_DECRESCENTES) || !strlen(FILENAME_NUMEROS_RANDOMICOS))
    error_exit(nome_invalido);
}

int main()
{
  verify_configs();
  create_bin_file(FILENAME_NUMEROS_CRESCENTES, generate_numbers_crescente);
  create_bin_file(FILENAME_NUMEROS_DECRESCENTES, generate_numbers_decrescente);
  create_bin_file(FILENAME_NUMEROS_RANDOMICOS, generate_numbers_random);
  return 0;
}