package main

import "fmt"

func maxUncrossedLines(nums1 []int, nums2 []int) int {
	r, c := len(nums1), len(nums2)
	dp := make([][]int, r+2)
	for i := range dp {
		dp[i] = make([]int, c+2)
	}

	for i := r; i > 0; i-- {
		n1 := nums1[i-1]
		for j := c; j > 0; j-- {
			if n1 == nums2[j-1] {
				dp[i][j] = 1 + dp[i+1][j+1]

			} else {
				if dp[i][j+1] > dp[i+1][j] {
					dp[i][j] = dp[i][j+1]
				} else {
					dp[i][j] = dp[i+1][j]
				}

			}
		}
	}
	return dp[1][1]
}

func main() {
	nums1 := []int{1, 4, 2}
	nums2 := []int{1, 2, 4}
	ans := maxUncrossedLines(nums1, nums2)
	//2
	fmt.Println(ans)
}
