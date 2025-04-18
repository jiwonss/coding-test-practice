from sys import stdin

input = stdin.readline


def calc(a, b, op):
    if op == "+":
        return a + b
    if op == "-":
        return a - b
    if op == "*":
        return a * b


def dfs(k, result):
    global max_result

    if k == len(operation):
        max_result = max(max_result, result)
        return

    dfs(k + 1, calc(result, number[k + 1], operation[k]))

    if k < len(operation) - 1:
        bracket = calc(number[k + 1], number[k + 2], operation[k + 1])
        dfs(k + 2, calc(result, bracket, operation[k]))


def solve():
    global number, operation, max_result

    N = int(input())
    formula = input().strip()

    number = [int(formula[i]) for i in range(0, N, 2)]
    operation = [formula[i] for i in range(1, N, 2)]

    max_result = -float("inf")
    dfs(0, number[0])
    print(max_result)


if __name__ == "__main__":
    solve()
