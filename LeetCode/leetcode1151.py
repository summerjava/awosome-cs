if __name__ == '__main__':
    a = list(map(int, input().split()))
    k = int(input())
    n = len(a)

    ##所有小于K的整数的个数
    tot = 0
    for x in a:
        tot += (x < k)

    #维持一个大小为tot的窗口，now表示窗口内小于K的整数的个数
    now = 0
    for i in range(tot):
        now += (a[i] < k)

    #初始化值为最大的交换次数
    ans = tot - now

    # 滑动窗口向右滑动
    for i in range(tot, n):
        # 如果窗口右侧的数据是小于K，而左侧的数据不是小于K，那now增加1，表示窗口内小于K的数据总数多了1
        now += (a[i] < k) - (a[i - tot] < k)
        # 总是取更小的那个值，tot - now表示最终交换的得到的小于K的整数都位于当前这个窗口的情况下，最小的交换次数
        ans = min(ans, tot - now)

    print(ans)