from sys import stdin
input = stdin.readline

def dfs(k):
	if k == M:
		print(*result)
		return
	
	for i in range(N):
		result[k] = i + 1
		dfs(k + 1)

def solve():
	global N, M, result
	
	N, M = map(int, input().split())
	
	result = [0] * M
	dfs(0)

if __name__ == "__main__":
    solve()