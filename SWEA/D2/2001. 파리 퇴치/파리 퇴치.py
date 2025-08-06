T = int(input())
 
for tc in range(T):
    N, M = map(int, input().split())
    flies = []
    for i in range(N):
        flies.append(list(map(int, input().split())))
    max = 0
    for i in range(N - M + 1):
        for j in range(N - M + 1):
            total = 0
            for k in range(M):
                for l in range(M):
                   total += flies[i + k][j + l]
            if total > max:
                max = total
 
    print(f'#{tc + 1} {max}')