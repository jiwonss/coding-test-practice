from sys import stdin
input = stdin.readline


def solve():
    N, M = map(int, input().split())

    password_list = {}
    for _ in range(N):
        address, password = input().split()
        password_list[address] = password

    for _ in range(M):
        address = input().strip()
        print(password_list[address])


if __name__ == "__main__":
    solve()
