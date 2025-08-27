from sys import stdin

input = stdin.readline


def solve():
    T = int(input())
    for _ in range(T):
        N = int(input())
        team_number = list(map(int, input().split()))
        
        team = {i: [0, []] for i in range(1, max(team_number) + 1)}
        for i in range(N):
            team[team_number[i]][0] += 1

        cnt = 1
        for i in range(N):
            t = team_number[i]
            if team[t][0] < 6:
                continue
            team[t][1].append([i, cnt])
            cnt += 1

        score = []
        for k, v in team.items():
            if v[0] < 6:
                continue
            score.append([k, sum([b for a, b in v[1]][:4]), v[1][4][1]])
        
        answer = sorted(score, key=lambda x : (x[1], x[2]))
        print(answer[0][0])
        

if __name__ == "__main__":
    solve()