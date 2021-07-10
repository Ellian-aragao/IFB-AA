#ifndef GENERATE_NUMBERS_H
#define GENERATE_NUMBERS_H

#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>
#include "../config.h"

void *generate_teste_files(void *index_from_thread);
void error_exit(const char *error_msg);

#endif // !GENERATE_NUMBERS_H
