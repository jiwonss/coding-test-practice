N = int(input())
paper = [list(map(int, list(map(int, input().split())))) for _ in range(N)]
check = [0] * 3


def divide(x, y, n):
    if n == 1:
        check[paper[x][y]] += 1
        return check[paper[x][y]]

    for i in range(x, x + n):
        for j in range(y, y + n):
            if paper[i][j] != paper[x][y]:
                divide(x, y, n // 3)
                divide(x, y + (n // 3), n // 3)
                divide(x, y + (2 * (n // 3)), n // 3)
                divide(x + (n // 3), y, n // 3)
                divide(x + (n // 3), y + (n // 3), n // 3)
                divide(x + (n // 3), y + (2 * (n // 3)), n // 3)
                divide(x + (2 * (n // 3)), y, n // 3)
                divide(x + (2 * (n // 3)), y + (n // 3), n // 3)
                divide(x + (2 * (n // 3)), y + (2 * (n // 3)), n // 3)
                return
    check[paper[x][y]] += 1
    return check[paper[x][y]]


divide(0, 0, N)

print(check[-1])
print(check[0])
print(check[1])
