from sys import stdin

input = stdin.readline


def calc(k, total, plus, minus, multi, div):
    if k == N - 1:
        result.append(total)
        return

    if plus:
        calc(k + 1, total + A[k + 1], plus - 1, minus, multi, div)
    if minus:
        calc(k + 1, total - A[k + 1], plus, minus - 1, multi, div)
    if multi:
        calc(k + 1, total * A[k + 1], plus, minus, multi - 1, div)
    if div:
        calc(k + 1, int(total / A[k + 1]), plus, minus, multi, div - 1)


def solve():
    global N, A, op, result

    N = int(input())
    A = list(map(int, input().split()))
    op = list(map(int, input().split()))

    result = []
    calc(0, A[0], op[0], op[1], op[2], op[3])
    print(max(result))
    print(min(result))


if __name__ == "__main__":
    solve()
