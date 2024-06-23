from sys import stdin
input = stdin.readline


def solve():
    N = int(input())

    result = 0
    for _ in range(N):
        word = input().strip()

        stack = []
        for w in word:
            if stack:
                if stack[-1] == w:
                    stack.pop()
                else:
                    stack.append(w)
            else:
                stack.append(w)

        if not stack:
            result += 1
    print(result)


if __name__ == "__main__":
    solve()
