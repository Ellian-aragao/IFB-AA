#include "config.h"

int main(int argc, char const *argv[])
{
  if (argc < 2)
  {
    perror("Deve-se enviar valores de entrada no programa");
    exit(EXIT_FAILURE);
  }
  FILE *fp = fopen(argv[1], "rb");
  

  return 0;
}