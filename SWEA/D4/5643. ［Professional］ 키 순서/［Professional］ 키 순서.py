from collections import deque

T = int(input())
for t in range(1, T + 1):
    N = int(input())
    M = int(input())

    graph1, graph2 = [[] for _ in range(N + 1)], [[] for _ in range(N + 1)]
    for _ in range(M):
        a, b = map(int, input().split())
        graph1[a].append(b) # a -> b
        graph2[b].append(a) # b -> a

    result = 0
    q1, q2 = deque(), deque()
    for i in range(1, N + 1):
        visited1, visited2 = [0] * (N + 1), [0] * (N + 1)
        # i번 학생보다 키가 큰 학생 찾기
        q1.append(i)
        while q1:
            x = q1.popleft()
            for v in graph1[x]:
                if not visited1[v]:
                    visited1[v] = 1
                    q1.append(v)
        # i번 학생보다 키가 작은 학생 찾기
        q2.append(i)
        while q2:
            x = q2.popleft()
            for v in graph2[x]:
                if not visited2[v]:
                    visited2[v] = 1
                    q2.append(v)
        # i번 학생보다 키가 큰 학생 수 + i번 학생보다 키가 작은 학생 수
        # 더한 값이 N - 1일 경우 자신의 키가 몇 번째인지 정확히 할 수 있다.
        if sum(visited1) + sum(visited2) == N - 1:
            result += 1
    print(f'#{t} {result}')