#!/bin/env python3

from subprocess import call, Popen
from os import listdir, replace
from os.path import isdir
from typing import List
from util import filterendwith_mappath_listfiles


def verify_generated_numbers_files(listFiles: List[str]) -> List[str]:
    if len(listFiles) > 2:
        return filterendwith_mappath_listfiles('dist', listFiles, '.bin')
    print('Iniciando programa de geração de números para sort')
    call(['dist/generate_numbers'])
    listBinarys = []
    for file in filter(lambda file: file.endswith('.bin'), listdir()):
        filePath = 'dist/{}'.format(file)
        replace(file, filePath)
        listBinarys.append(filePath)
    return listBinarys


if __name__ == '__main__':
    if not isdir('dist'):
        raise RuntimeError('Compile before execute program')

    listFiles: List[str] = listdir('dist')
    binArray = verify_generated_numbers_files(listFiles)
    algArray = ['b', 'm', 'h']
    for file in binArray:
        for alg in algArray:
            call(['dist/sorts', alg, file])
