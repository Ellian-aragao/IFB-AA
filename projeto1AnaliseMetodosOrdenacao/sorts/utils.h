#ifndef UTILS_H
#define UTILS_H

#include "../config.h"
#include <string.h>
#include "sort.h"

enum Sort
{
  bubble = 'b',
  heap = 'h',
  merge = 'm'
};

typedef unsigned long long llong;

typedef struct arguments_from_cli
{
  const char *algorithm;
  const char *file_name;
  const char *type_file;
  llong lenght_input;
} arg_cli;

void read_file_and_save_in_vector(int *vector, const arg_cli *args);
int compare_integer(void *i1, void *i2);
void print_vector(const int *vector, const int tamVector);
void apply_algorithm(void *vector, const char *algoritmo, const llong *quantidade_numeros);
int valid_algorithm_parameter(const char algoritmo);
int valid_read_parameter(const char read_mode);
void if_true_print_msg_exit(int is_true, const char *msg);
arg_cli verify_arguments_return_needs_to_read(int argc, char const *argv[]);

#endif // !UTILS_H
