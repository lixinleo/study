package main

import "fmt"

type FrequencyTracker struct {
	mapN map[int]int
	mapF map[int]int
}

func Constructor() FrequencyTracker {
	var m1 = make(map[int]int)
	var m2 = make(map[int]int)
	return FrequencyTracker{m1, m2}
}

func (this *FrequencyTracker) Add(number int) {
	j, ok := this.mapN[number]
	if ok {
		this.mapN[number] = j + 1
		this.decreaseF(j)
		this.increaseF(j + 1)
	} else {
		this.mapN[number] = 1
		this.increaseF(1)
	}

}

func (this *FrequencyTracker) DeleteOne(number int) {
	j, ok := this.mapN[number]
	if ok {
		if j == 1 {
			delete(this.mapN, number)
		} else {
			this.mapN[number] = j - 1
		}

		this.decreaseF(j)
		this.increaseF(j - 1)
	}

}

func (this *FrequencyTracker) decreaseF(f int) {
	if f > 0 {
		j, _ := this.mapF[f]
		if j == 1 {
			delete(this.mapF, f)
		} else {
			this.mapF[f] = j - 1
		}
	}
}

func (this *FrequencyTracker) increaseF(f int) {
	if f > 0 {
		j, ok := this.mapF[f]
		if ok {
			this.mapF[f] = j + 1
		} else {
			this.mapF[f] = 1
		}
	}
}

func (this *FrequencyTracker) HasFrequency(frequency int) bool {
	_, ok := this.mapF[frequency]

	return ok
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Add(number);
 * obj.DeleteOne(number);
 * param_3 := obj.HasFrequency(frequency);
 */
func main() {
	obj := Constructor()
	obj.Add(2)
	obj.Add(2)
	obj.DeleteOne(2)

	//false
	ans := obj.HasFrequency(2)
	fmt.Println(ans)

	//true
	ans = obj.HasFrequency(1)
	fmt.Println(ans)

}
