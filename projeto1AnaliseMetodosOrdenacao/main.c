#include "config.h"
#include "sort.h"


int main(int argc, char const *argv[])
{
  if (argc < 2)
  {
    perror("Deve-se enviar valores de entrada no programa");
    exit(EXIT_FAILURE);
  }
  FILE *read = fopen(FILENAME_NUMEROS_RANDOMICOS, "rb");
  int buf;
  for (size_t i = 0; i < QUANTIDADE_DE_NUMEROS; i++)
  {
    fread(&buf, sizeof(int), 1, read);
    printf("%d\n", buf);
  }
  fclose(read);
  return 0;
}