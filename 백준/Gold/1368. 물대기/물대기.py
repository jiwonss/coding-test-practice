from sys import stdin

input = stdin.readline


class DisjointSet:
    def __init__(self, n) -> None:
        self.parent = list(range(n))
        self.rank = [1] * n

    def find(self, u):
        if self.parent[u] != u:
            self.parent[u] = self.find(self.parent[u])
        return self.parent[u]

    def union(self, u, v):
        root_u = self.find(u)
        root_v = self.find(v)

        if root_u != root_v:
            if self.rank[root_u] < self.rank[root_v]:
                self.parent[root_u] = root_v
            elif self.rank[root_u] > self.rank[root_v]:
                self.parent[root_v] = root_u
            else:
                self.parent[root_u] = root_v
                self.rank[root_v] += 1


def kruskal():
    edges.sort(key=lambda x: x[2])
    disjoint_set = DisjointSet(N + 1)

    weight = 0
    for u, v, w in edges:
        if disjoint_set.find(u) != disjoint_set.find(v):
            disjoint_set.union(u, v)
            weight += w
    return weight


def solve():
    global N, W, edges

    N = int(input())

    edges = []
    for i in range(N):
        W = int(input())
        edges.append([i, N, W])

    temp = [list(map(int, input().split())) for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if i == j:
                continue
            edges.append([i, j, temp[i][j]])

    result = kruskal()
    print(result)


if __name__ == "__main__":
    solve()
