#!/bin/env python3

from distutils.ccompiler import new_compiler
from os import listdir, remove, mkdir
from os.path import isdir
from typing import List


def listdir_and_filter(path, endswith):
    return filterendwith_mappath_listfiles(path, listdir(path), endswith)


def filterendwith_mappath_listfiles(base_path: str, list_os_listdir: List[str], end: str):
    source_files = filter(lambda file: file.endswith(end), list_os_listdir)
    relative_path = map(
        lambda file: '{}/{}'.format(base_path, file), source_files)
    return list(relative_path)


def compile_sources(list_sources: List[str], name_source: str):
    compiler = new_compiler()
    compiled_programs = compiler.compile(
        list_sources,
        extra_preargs=['-O3', '-w']
    )
    compiler.link_executable(
        compiled_programs,
        output_progname=name_source,
        output_dir='dist',
        libraries=['pthread']
    )


if __name__ == '__main__':
    if not isdir('dist'):
        mkdir('dist')
    for dirname in ['generate_numbers', 'sorts']:
        files = listdir_and_filter(dirname, '.c')
        print('Compiling {}'.format(dirname))
        compile_sources(files, name_source=dirname)
        for file in listdir_and_filter(dirname, '.o'):
            remove(file)
