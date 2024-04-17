from sys import stdin
input = stdin.readline


def calc(times):
    y_plan, m_plan = 0, 0
    for time in times:
        y_plan += ((time // 30) + 1) * 10
        m_plan += ((time // 60) + 1) * 15
    return [y_plan, m_plan]


def solve():
    N = int(input())
    times = list(map(int, input().split()))

    y_plan, m_plan = calc(times)
    if y_plan < m_plan:
        print(f'Y {y_plan}')
    elif y_plan > m_plan:
        print(f'M {m_plan}')
    else:
        print(f'Y M {y_plan}')


if __name__ == "__main__":
    solve()
