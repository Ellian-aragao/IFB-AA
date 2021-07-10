from typing import List


def filterendwith_mappath_listfiles(base_path: str, list_os_listdir: List[str], end: str) -> List[str]:
    listed_files_with_ends = filter(
        lambda file: file.endswith(end),
        list_os_listdir
    )
    relative_path = map(
        lambda file: '{}/{}'.format(base_path, file),
        listed_files_with_ends
    )
    return list(relative_path)
