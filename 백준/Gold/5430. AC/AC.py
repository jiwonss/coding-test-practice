from sys import stdin
from collections import deque
input = stdin.readline


def solve():
    T = int(input())
    for _ in range(T):
        p = list(input().strip())
        n = int(input())

        arr, num = input().strip()[1:-1], deque()
        if arr:
            num = deque(arr.split(','))

        check, error = 1, 0
        for op in p:
            if op == 'R':
                check *= (-1)
            else:
                if not num:
                    error = 1
                    break

                if check == 1:
                    num.popleft()
                else:
                    num.pop()

        if error:
            print('error')
        else:
            result = list(num)
            if check == 1:
                print('[' + ','.join(result) + ']')
            else:
                print('[' + ','.join(result[::-1]) + ']')


if __name__ == "__main__":
    solve()
