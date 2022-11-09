from collections import defaultdict
from typing import List


class Graph:

    def __init__(self, graph: list[int]) -> None:
        self.graph = defaultdict(list)
        self.all_path: list[list[int]] = []
        for i in graph:
            for j in graph:
                if i != j:
                    self.add_edge(i, j)

    def add_edge(self, u, v) -> None:
        self.graph[u].append(v)

    def get_path_util(self, from_v, to_v, visited, path) -> None:

        visited[from_v - 1] = True
        path.append(from_v)

        if from_v == to_v:
            self.all_path.append(list(path))
        else:
            for i in self.graph[from_v]:
                if not visited[i - 1]:
                    self.get_path_util(i, to_v, visited, path)

        path.pop()
        visited[from_v - 1] = False

    def get_all_path(self) -> list[list[int]]:

        for i in self.graph:
            visited: list[bool] = [False] * (len(self.graph))
            path: list[int] = []
            for j in self.graph:
                if i != j:
                    self.get_path_util(i, j, visited, path)

        return self.all_path
