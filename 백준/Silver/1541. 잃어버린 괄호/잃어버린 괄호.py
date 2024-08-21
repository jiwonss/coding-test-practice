from sys import stdin
input = stdin.readline


def solve():
    expression = input().strip()

    result = 0
    num, sign = '', 1
    for e in expression:
        if e == '+' or e == '-':
            result += int(num) * sign
            num = ''
            if e == '-':
                sign = -1
        else:
            num += e
    result += int(num) * sign
    print(result)


if __name__ == "__main__":
    solve()
