from sys import stdin
input = stdin.readline


def get_distance(selected):
    city_distance = 0
    for r1, c1 in home:
        distance = []
        for idx in selected:
            r2, c2 = chicken[idx]
            distance.append(abs(r2 - r1) + abs(c2 - c1))
        city_distance += min(distance)
    return city_distance


def select(k, start):
    global result

    if k == M:
        selected = [i for i in range(len(chicken)) if visited[i]]
        result = min(result, get_distance(selected))
        return

    for i in range(start, len(chicken)):
        if visited[i]:
            continue
        visited[i] = 1
        select(k + 1, i + 1)
        visited[i] = 0


def solve():
    global N, M, home, chicken, visited, result

    N, M = map(int, input().split())
    city, home, chicken = [], [], []
    for i in range(N):
        city.append(list(map(int, input().split())))
        for j in range(N):
            if city[i][j] == 1:
                home.append([i, j])
            if city[i][j] == 2:
                chicken.append([i, j])

    result, visited = 1e9, [0] * len(chicken)
    select(0, 0)
    print(result)


if __name__ == "__main__":
    solve()
