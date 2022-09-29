from queue import Queue


def btf(graph: list[list[str]], i: int, j: int, new_color: str, m: int, n: int) -> None:
    old_color = graph[i][j]
    if old_color == new_color:
        return

    queue = Queue()
    queue.put((i, j))

    while not queue.empty():
        i, j = queue.get()
        if i < 0 or i >= n or j < 0 or j >= m or graph[i][j] != old_color:
            continue
        else:
            graph[i][j] = new_color
            queue.put((i + 1, j))
            queue.put((i - 1, j))
            queue.put((i, j + 1))
            queue.put((i, j - 1))
