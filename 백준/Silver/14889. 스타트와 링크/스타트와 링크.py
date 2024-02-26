n = int(input())
s = [list(map(int, input().split())) for _ in range(n)]

arr = [0] * n
isused = [0] * n
result = []

def divide_team(cnt):
    if cnt == (n // 2):
        start = [arr[i] for i in range(n // 2)]
        link = [i for i in range(n) if not isused[i]]
        result.append(get_ability([start, link]))
        return 

    for i in range(n):
        if not isused[i] and arr[cnt - 1] < i + 1:
            arr[cnt] = i
            isused[i] = 1
            divide_team(cnt + 1)
            isused[i] = 0

def get_ability(t):
    start, link = 0, 0
    for i in range((n // 2) - 1):
        for j in range(i + 1, n // 2):
            start_i, start_j = t[0][i], t[0][j]
            link_i, link_j = t[1][i], t[1][j]
            start += s[start_i][start_j] + s[start_j][start_i]
            link += s[link_i][link_j] + s[link_j][link_i]
    return abs(start - link)

divide_team(0)
print(min(result))

