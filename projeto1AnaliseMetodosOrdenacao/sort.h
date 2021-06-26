#ifndef SORT_H
#define SORT_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SORT_FUNCS_ARGUMENTS void *vector, u_long tamVector, size_t SizeValuesVector, int (*comparator)(void *, void *)

typedef unsigned long u_long;

void bubble_sort(SORT_FUNCS_ARGUMENTS);
void merge_sort(SORT_FUNCS_ARGUMENTS);
void heap_sort(SORT_FUNCS_ARGUMENTS);
void print_vector(const int *vector, const int tamVector);
int compare_integer(void *i1, void *i2);

#endif // !SORT_H