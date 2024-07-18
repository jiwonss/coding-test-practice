from sys import stdin
input = stdin.readline


def solve():
    N, M = map(int, input().split())

    num_book, name_book = {}, {}
    for i in range(1, N + 1):
        name = input().strip()
        num_book[i] = name
        name_book[name] = i

    for _ in range(M):
        problem = input().strip()
        if problem.isdigit():
            print(num_book[int(problem)])
        else:
            print(name_book[problem])


if __name__ == "__main__":
    solve()
