from sys import stdin
input = stdin.readline


def solve():
    T = int(input())
    for _ in range(T):
        ps = input().strip()

        check, stack = 0, []
        for s in ps:
            if s == '(':
                stack.append(s)
            else:
                if not stack:
                    check = 1
                    break
                stack.pop()

        if check or stack:
            print('NO')
        else:
            print('YES')


if __name__ == "__main__":
    solve()
