from sys import stdin
input = stdin.readline


def tie(num):
    global result

    while len(num) > 1:
        a, b = num.pop(), num.pop()
        result += a * b

    if len(num):
        result += num[-1]


def solve():
    global result

    N = int(input())

    result = 0
    negative, positive = [], []
    for _ in range(N):
        n = int(input())
        if n == 1:
            result += 1
            continue
        if n > 0:
            positive.append(n)
        else:
            negative.append(n)

    negative, positive = sorted(negative, reverse=True), sorted(positive)
    tie(negative)
    tie(positive)
    print(result)


if __name__ == "__main__":
    solve()
