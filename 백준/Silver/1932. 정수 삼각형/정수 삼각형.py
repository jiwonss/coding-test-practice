from sys import stdin
input = stdin.readline

n = int(input())
triangle = [list(map(int, input().split())) + [0] * (n - i - 1) for i in range(n)]
for i in range(1, n):
    for j in range(n):
        triangle[i][j] += max(triangle[i - 1][j - 1], triangle[i - 1][j])
print(max(triangle[n - 1]))