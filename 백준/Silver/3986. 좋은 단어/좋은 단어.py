from sys import stdin
input = stdin.readline

def check(word):
    stack = []
    for w in word:
        if stack:
            if stack[-1] == w:
                stack.pop()
            else:
                stack.append(w)
        else:
            stack.append(w)
    return 0 if stack else 1

def solve():
    N = int(input())

    result = 0
    for _ in range(N):
        word = input().strip()
        if check(word):
            result += 1
    print(result)

if __name__ == "__main__":
    solve()