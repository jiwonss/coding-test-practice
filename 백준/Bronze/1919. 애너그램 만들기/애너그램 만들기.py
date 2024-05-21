from sys import stdin
input = stdin.readline


def solve():
    s1 = input().strip()
    s2 = input().strip()

    check = [0] * 26
    for s in s1:
        check[ord(s) - 97] += 1
    for s in s2:
        check[ord(s) - 97] -= 1

    result = 0
    for i in range(26):
        if check[i] != 0:
            result += abs(check[i])
    print(result)


if __name__ == "__main__":
    solve()
