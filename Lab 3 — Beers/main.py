from graph import Graph

'''First function for sort_beer'''

# def sort_beer(graph: dict,  n: int, b: int) -> None:
#     count_array: list = []
#     count_of_sort: int = 0
#
#     for first_values in graph.values():
#         count_of_sort = 1
#         new_set: set = set(first_values)
#
#         for second_values in graph.values():
#             if first_values != second_values:
#                 new_set.update(second_values)
#                 count_of_sort += 1
#                 if len(new_set) == n:
#                     count_array.append(count_of_sort)
#                     break
#
#     if count_of_sort > b:
#         raise "It`s so many beer than We have"
#
#     print(f'We need to buy {min(count_array)} sort piva for IoT')


def sort_beer(graph: dict,  n: int, b: int) -> None:
    count_array: list = []
    count_of_sort: int = 0
    list_ways: list[list[int]] = Graph([i for i in range(1, len(graph) + 1)]).get_all_path()

    for way in list_ways:
        new_set: set = set()
        count_of_sort = 0
        for index in way:
            count_of_sort += 1
            new_set.update(graph[index])
            if len(new_set) == n:
                count_array.append(count_of_sort)
                break

    if count_of_sort > b:
        raise "It`s so many beer than We have"

    print(f'We need to buy {min(count_array)} sort piva for IoT')


def main():
    with open("input.txt", 'r') as r:
        n, b = map(int, r.readline().split())
        beers: list = r.readline().split()
        graph: dict[int, set[int]] = {}
        for i in range(n):
            for j in range(b):
                if beers[i][j] == 'Y':
                    graph.setdefault(j + 1, set()).add(i + 1)
        sort_beer(graph, n, b)


if __name__ == '__main__':
    main()
