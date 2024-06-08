from sys import stdin
input = stdin.readline


def solve():
    T = int(input())
    for _ in range(T):
        word = input().strip()
        left, right = [], []
        for w in word:
            if w == '<':
                if left:
                    right.append(left.pop())
            elif w == '>':
                if right:
                    left.append(right.pop())
            elif w == '-':
                if left:
                    left.pop()
            else:
                left.append(w)
        result = left + right[::-1]
        print(''.join(result))


if __name__ == "__main__":
    solve()
