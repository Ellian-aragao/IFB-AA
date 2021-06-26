#include "sort.h"

#define get_address(vector, position, size) ((vector) + ((position) * (size)))

static inline void *create_tmp_pointer(size_t *size)
{
  void *tmp = malloc(*size);
  if (!tmp)
    exit(EXIT_FAILURE);
  return tmp;
}

static inline void swap(void *item1, void *item2, void *tmp, size_t *size)
{
  memcpy(tmp, item1, *size);
  memcpy(item1, item2, *size);
  memcpy(item2, tmp, *size);
}

void bubble_sort(void *vector, u_long tamVector, size_t SizeValuesVector, int (*comparator)(void *, void *))
{
  u_long boolean = 1;
  void *tmp = create_tmp_pointer(&SizeValuesVector);
  while (boolean != 0)
  {
    u_long i;
    for (boolean = 0, i = 0; i < tamVector - 1; i++)
    {
      if (comparator(get_address(vector, i + 1, SizeValuesVector), get_address(vector, i, SizeValuesVector)))
      {
        swap(get_address(vector, i, SizeValuesVector), get_address(vector, i + 1, SizeValuesVector), tmp, &SizeValuesVector);
        boolean = i;
      }
    }
    tamVector--;
  }
  free(tmp);
}

static inline void merge_sort_merge_vectors(void *vector, const u_long *init, const u_long *mid, const u_long *end, void *tmpV, const size_t *SizeValuesVector, int (*comparator)(void *, void *))
{
  u_long left = *init;
  u_long right = *mid;
  for (u_long i = *init; i < *end; i++)
  {
    if ((left < *mid) && ((right >= *end) || comparator(get_address(vector, left, *SizeValuesVector), get_address(vector, right, *SizeValuesVector))))
    {
      memcpy(get_address(tmpV, i, *SizeValuesVector), get_address(vector, left, *SizeValuesVector), *SizeValuesVector);
      left++;
    }
    else
    {
      memcpy(get_address(tmpV, i, *SizeValuesVector), get_address(vector, right, *SizeValuesVector), *SizeValuesVector);
      right++;
    }
  }
  for (u_long i = *init; i < *end; ++i)
    memcpy(get_address(vector, i, *SizeValuesVector), get_address(tmpV, i, *SizeValuesVector), *SizeValuesVector);
}

static void merge_sort_recursive(void *vector, const u_long *init, const u_long *end, void *tmpV, const size_t *SizeValuesVector, int (*comparator)(void *, void *))
{
  if ((*end - *init) < 2)
    return;
  const u_long mid = ((*init + *end) / 2);
  merge_sort_recursive(vector, init, &mid, tmpV, SizeValuesVector, comparator);
  merge_sort_recursive(vector, &mid, end, tmpV, SizeValuesVector, comparator);
  merge_sort_merge_vectors(vector, init, &mid, end, tmpV, SizeValuesVector, comparator);
}

void merge_sort(void *vector, const u_long tamVector, const size_t SizeValuesVector, int (*comparator)(void *, void *))
{
  size_t var = SizeValuesVector * tamVector;
  void *tmp = create_tmp_pointer(&var);
  var = 0;
  merge_sort_recursive(vector, &var, &tamVector, tmp, &SizeValuesVector, comparator);
}

void heap_sort(void *vector, u_long tamVector, size_t SizeValuesVector, int (*comparator)(void *, void *))
{
  void *tmp = create_tmp_pointer(&SizeValuesVector);
  u_long i = tamVector / 2;
  while (1)
  {
    if (i > 0)
    {
      i--;
      memcpy(tmp, get_address(vector, i, SizeValuesVector), SizeValuesVector);
    }
    else
    {
      tamVector--;
      if (tamVector <= 0)
        return;
      memcpy(tmp, get_address(vector, tamVector, SizeValuesVector), SizeValuesVector);
      memcpy(get_address(vector, tamVector, SizeValuesVector), get_address(vector, 0, SizeValuesVector), SizeValuesVector);
    }

    u_long root = i;
    u_long node = i * 2 + 1;
    while (node < tamVector)
    {
      if ((node + 1 < tamVector) && comparator(get_address(vector, node, SizeValuesVector), get_address(vector, node + 1, SizeValuesVector)))
        node++;
      if (comparator(tmp, get_address(vector, node, SizeValuesVector)))
      {
        memcpy(get_address(vector, root, SizeValuesVector), get_address(vector, node, SizeValuesVector), SizeValuesVector);
        root = node;
        node = root * 2 + 1;
      }
      else
        break;
    }
    memcpy(get_address(vector, root, SizeValuesVector), tmp, SizeValuesVector);
  }
}
