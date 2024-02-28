#include "generate_numbers.h"

int main()
{
  puts("Analizando arquivo de configuração");
  if (QUANTIDADE_DE_NUMEROS <= 0)
    error_exit("quantidade de numeros não pode ser menor que 1");

  const int NUM_THREADS = 3;
  pthread_t thread[NUM_THREADS];

  for (int i = 0; i < NUM_THREADS; i++)
  {
    if (pthread_create(&thread[i], NULL, generate_teste_files, (void *)i))
      error_exit("ERROR from pthread_create");
  }

  for (int i = 0; i < NUM_THREADS; i++)
  {
    if (pthread_join(thread[i], NULL))
      error_exit("ERROR from pthread_join");
  }

  pthread_exit(NULL);
}