from sys import stdin
input = stdin.readline


def rotate(n, d):
    temp = cogwheel[n]
    if d == -1:
        cogwheel[n] = temp[1:] + [temp[0]]
    if d == 1:
        cogwheel[n] = [temp[7]] + temp[:7]


def check(n, d):
    direction = [0] * 4
    direction[n] = d

    for i in range(n, 0, -1):
        if cogwheel[i][6] == cogwheel[i - 1][2]:
            break
        direction[i - 1] = direction[i] * (-1)
    for i in range(n, 3):
        if cogwheel[i][2] == cogwheel[i + 1][6]:
            break
        direction[i + 1] = direction[i] * (-1)

    return direction


def solve():
    global cogwheel

    cogwheel = []
    for _ in range(4):
        cogwheel.append(list(input().strip()))

    K = int(input())
    for _ in range(K):
        n, d = map(int, input().split())
        direction = check(n - 1, d)
        for i in range(4):
            rotate(i, direction[i])

    result = 0
    for i in range(4):
        if cogwheel[i][0] == '1':
            result += 1 << i
    print(result)


if __name__ == "__main__":
    solve()
