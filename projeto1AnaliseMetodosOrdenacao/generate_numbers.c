#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include "config.h"

void create_bin_file(const char *file_name, void (*func)(FILE *))
{
  FILE *file;
  printf("Criando arquivo %s\n", file_name);
  if ((file = fopen(file_name, "wb")) == NULL)
  {
    perror("Erro ao criar arquivo");
    exit(EXIT_FAILURE);
  }
  puts("Arquivo criado com sucesso\nPopulando dados no arquivo");
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
  int
  if (MAX_NUMEROS <= 0)
  
  FILENAME_NUMEROS_CRESCENTES
  FILENAME_NUMEROS_DECRESCENTES
  FILENAME_NUMEROS_RANDOMICOS
}

int main()
{

  create_bin_file(FILENAME_NUMEROS_CRESCENTES, generate_numbers_crescente);
  create_bin_file(FILENAME_NUMEROS_DECRESCENTES, generate_numbers_decrescente);
  create_bin_file(FILENAME_NUMEROS_RANDOMICOS, generate_numbers_random);
  return 0;
}