from sys import stdin

input = stdin.readline


def calc():
    total = A[0]
    for i in range(1, N):
        if op[i - 1] == 0:
            total += A[i]
        if op[i - 1] == 1:
            total -= A[i]
        if op[i - 1] == 2:
            total *= A[i]
        if op[i - 1] == 3:
            total = int(total / A[i])
    return total


def select(k):
    if k == N - 1:
        result.append(calc())
        return

    for i in range(N - 1):
        if visited[i]:
            continue
        visited[i] = 1
        op.append(op_list[i])
        select(k + 1)
        op.pop()
        visited[i] = 0


def solve():
    global N, A, op_list, op, visited, result

    N = int(input())
    A = list(map(int, input().split()))
    cnt = list(map(int, input().split()))

    op_list = []
    for i in range(4):
        if cnt[i] == 0:
            continue
        for _ in range(cnt[i]):
            op_list.append(i)

    op, visited = [], [0] * (N - 1)
    result = []
    select(0)
    print(max(result))
    print(min(result))


if __name__ == "__main__":
    solve()
