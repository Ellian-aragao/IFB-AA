## Sort library

copy algorithm from:

https://github.com/Ellian-aragao/IFB-EDA/tree/main/7_Sort

## Compiling program

just use your C compiler preferred to compile main.c and sort.c as:

```sh
clang -O3 main.c sort.c
```

## running program

the program wait 2 arguments, the fist is selection of algorithm,
the last is path of binary file generated by `create_numbers.sh`

| sort algorithm | argument |
| :------------: | :------: |
|     bubble     |    b     |
|     merge      |    m     |
|      heap      |    h     |

### Reading other file

If want to try with another files, should send more arguments,
more than before, has to send the type of file:

| type of file | argument |
| :----------: | :------: |
|  character   |    c     |
|    binary    |    b     |

and quantity of numbers in file to be sorted

example:

```sh
./{name_of_compiled_program} {sort_algorithm} {path_of_file} {type_of_file} {length_of_number_saved_in_file}
```